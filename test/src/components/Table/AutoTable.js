import React, { useEffect, useState, useCallback, useRef, useImperativeHandle, forwardRef } from 'react';
import { Table } from 'antd';
import { connect } from 'dva';
import { findDOMNode } from 'react-dom';
import { exportXlsx } from '@/utils';

function AutoTable(props, ref) {
  const {
    action,
    columns,
    params,
    dispatch,
    loading,
    onChange,
    standby,
    noPage,
    refresh,
    interFace,
    ...restProps
  } = props;
  const initialPage = useRef({
    showSizeChanger: true,
    showQuickJumper: true,
    showTotal: total => `共 ${total} 条`,
    current: 1,
    pageSize: 10,
    total: 0,
    pageSizeOptions: ['10', '20', '30', '40', '100'],
    size: 'small',
  });
  const tableRef = useRef(null);
  const [tableHeight, settableHeight] = useState(0);
  const [pagination, setpagination] = useState(initialPage.current);
  const [dataSource, setdataSource] = useState([]);

  const getTableData = useCallback(
    (action, pagination) => {
      if (!standby) {
        if (!(action || interFace)) {
          console.error('action 或 interFace 不能为空');
          return;
        }
        const pageInfo = noPage ? {} : pagination;
        const primose = interFace
          ? interFace({ ...pageInfo, ...(params || {}) })
          : dispatch({ type: action, payload: { ...pageInfo, ...(params || {}) } });
        primose.then(res => {
          if(!res.result){
            setpagination({ ...initialPage.current });
            setdataSource([]);
            return;
          }

          if (res.code === 1001) {
            // 暂无数据
            setpagination({ ...initialPage.current });
            setdataSource([]);
            return;
          }
          const { pageNum: current, total, pageSize, list } = res.result;
          setpagination({ ...initialPage.current, current, total, pageSize });
          // selectedRows missing when there is childrenColumnName in Table  4.0.1 bug
          let dataSource = list || res.result;
          if (restProps.expandable && restProps.expandable.childrenColumnName) {
            (function changeColName(data, name) {
              for (let i = 0; i < data.length; i++) {
                data[i].children = data[i][name];
                changeColName(data[i].children || [], name);
              }
            })(dataSource, restProps.expandable.childrenColumnName);
          }
          setdataSource(dataSource);
        });
      }
    },
    // eslint-disable-next-line react-hooks/exhaustive-deps
    [standby, noPage, dispatch, params],
  );

  // 获取数据
  useEffect(() => {
    const { current, pageSize } = initialPage.current;
    getTableData(action, { page: current, size: pageSize });
  }, [action, getTableData, initialPage, refresh]);

  const tableOnChange = (pagination, filters, sorter, extra) => {
    if (pagination.current) {
      const { current, pageSize } = pagination;
      getTableData(action, { page: current, size: pageSize });
    }
    if (onChange) {
      onChange(pagination, filters, sorter, extra);
    }
  };

  // 计算 table 高度
  useEffect(() => {
    let taleRef = findDOMNode(tableRef.current);
    const tableTopHeight = taleRef.getBoundingClientRect();
    const WebHeight = document.documentElement.clientHeight || document.body.clientHeight;
    let canShowArea = WebHeight - (tableTopHeight.top + 142);
    if (canShowArea < 360) {
      canShowArea = -1;
    }
    console.log(taleRef.getElementsByClassName('ant-table-body')[0].style);
    settableHeight(canShowArea);
  }, [tableRef]);

  useEffect(() => {
    let taleRef = findDOMNode(tableRef.current);
    if (dataSource.length) {
      taleRef.getElementsByClassName('ant-table-body')[0].style.height = tableHeight > 0 ? tableHeight + 'px' : 'auto';
      if(tableHeight < 0){
        taleRef.getElementsByClassName('ant-table-body')[0].style.overflow = 'auto';
      }
    } else {
      taleRef.getElementsByClassName('ant-table-body')[0].style.height = 0;
      taleRef.getElementsByClassName('ant-table-placeholder')[0].style.height = tableHeight + 'px';
    }
  }, [tableHeight, dataSource]);

  useImperativeHandle(ref, () => ({
    exportExcel: ( title = '表单', col = columns, otherRender = {}, merges = []) =>
      exportXlsx(dataSource, col, title, otherRender, merges),
  }));

  return (
    <Table
      ref={tableRef}
      style={{ marginTop: '20px' }}
      columns={columns}
      dataSource={dataSource}
      loading={loading.effects[action]}
      pagination={noPage ? false : pagination}
      {...restProps}
      expandable={{
        ...(restProps.expandable || {}),
        childrenColumnName: 'children',
      }}
      onChange={tableOnChange}
      scroll={
        restProps.scroll
          ? { y: tableHeight, scrollToFirstRowOnChange: true, ...restProps.scroll }
          : { y: tableHeight, scrollToFirstRowOnChange: true }
      }
    />
  );
}
export default connect(({ loading }) => ({ loading }), null ,null ,  {forwardRef : true})(forwardRef(AutoTable));
