import Table from '@/components/Table/AutoTable';
import { Button, Modal, Form, Input } from 'antd';
import { connect } from 'dva';
import { useState } from 'react';
import { formItemLayout } from '@/utils/const';
// hhhhh
function Menu({ dispatch, form }) {
  const [selectedRowKeys, setselectedRowKeys] = useState([]);
  const [visible, setvisible] = useState({ visible: false, type: 'add', record: {} });
  const [refresh, setrefresh] = useState(false);
  const columns = [
    {
      title: '标题',
      dataIndex: 'menuName',
    },
    {
      title: '图标',
      dataIndex: 'menuIconPath',
    },
    {
      title: '路由',
      dataIndex: 'menuLinkPath',
    },
    {
      title: '操作',
      dataIndex: 'options',
      render: (text, record, idx) => {
        return (
          <Button type="primary" size="small" onClick={editMenu.bind(null, 'edit', record)}>
            编辑
          </Button>
        );
      },
    },
  ];
  // 勾选change事件
  function onChange(selectedRowKeys) {
    setselectedRowKeys(selectedRowKeys);
  }
  // 新增编辑
  function editMenu(type, record) {
    if (selectedRowKeys.length > 1) {
      console.log('请选择一个需要新增的菜单');
      return false;
    }
    if (type === 'edit') {
      const { menuName, menuIconPath, menuLinkPath } = record;
      form.setFieldsValue({ menuName, menuIconPath, menuLinkPath });
    }
    setvisible({ ...visible, visible: true, type, record });
  }
  // 保存
  function saveEdit() {
    form.validateFields().then(value => {
      if (visible.type === 'edit') {
        dispatch({
          type: 'menuManger/updateMenuInfo',
          payload: { ...value, id: visible.record.id },
        }).then(res => {
          setrefresh(!refresh);
        });
      } else {
        dispatch({
          type: 'menuManger/addMenuInfo',
          payload: { ...value, parentMenuId: selectedRowKeys[0] || 0 },
        }).then(res => {
          setrefresh(!refresh);
        });
      }
      setselectedRowKeys([]);
      resetForm();
    });
  }
  // 取消
  function resetForm() {
    form.resetFields();
    setvisible({ ...visible, visible: false });
  }

  return (
    <>
      <Button type="primary" onClick={editMenu.bind(null, 'add')}>
        新增
      </Button>
      <Table
        action="menuManger/getList"
        columns={columns}
        rowKey="id"
        expandable={{
          expandIconColumnIndex: 2,
        }}
        rowSelection={{
          selectedRowKeys,
          onChange,
        }}
        refresh={refresh}
        noPage
      />
      <Modal
        title="新增/修改"
        width={700}
        visible={visible.visible}
        onOk={saveEdit}
        onCancel={resetForm}
        okText="确认"
        cancelText="取消"
      >
        <Form {...formItemLayout}>
          <Form.Item name="menuName" label="标题">
            {form.getFieldDecorator('menuName', {
              rules: [{ required: true, message: '请输入标题' }],
            })(<Input placeholder="请输入菜单标题" />)}
          </Form.Item>
          <Form.Item name="menuIconPath" label="图标">
            {form.getFieldDecorator('menuIconPath')(<Input placeholder="请输入菜单图标" />)}
          </Form.Item>
          <Form.Item name="menuLinkPath" label="路由">
            {form.getFieldDecorator('menuLinkPath')(<Input placeholder="请输入菜单路由" />)}
          </Form.Item>
        </Form>
      </Modal>
    </>
  );
}

export default connect()(Form.create()(Menu));
