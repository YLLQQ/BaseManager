import Table from '@/components/Table/AutoTable';
import { Button, Modal, Form, Input, message } from 'antd';
import { connect } from 'dva';
import { useState } from 'react';
import { formItemLayout } from '@/utils/const';
import AuthTreeSelect from './components/AuthTreeSelect';
import { getAllMenuIdListByRoleId, updateRoleRelationMenu } from '@/services/menu';
import { addRoleManagerWithCheck } from '@/services/role';

function Role({ dispatch, form }) {
  const [visible, setvisible] = useState({ visible: false, type: 'add', record: {} });
  const [selectedKeys, setselectedKeys] = useState([]);
  const [refresh, setrefresh] = useState(false);
  let selectAllKeys = [];

  const columns = [
    {
      title: '角色ID',
      dataIndex: 'id',
    },
    {
      title: '角色名称',
      dataIndex: 'roleName',
    },
    {
      title: '操作',
      dataIndex: 'options',
      render: (text, record, idx) => {
        return (
          <Button type="primary" size="small" onClick={editMenu.bind(null, 'edit', record)}>
            权限设置
          </Button>
        );
      },
    },
  ];
  // 新增编辑
  function editMenu(type, record) {
    if (type === 'edit') {
      getAllMenuIdListByRoleId(record.id).then(res => {
        console.log(res.result);
        setselectedKeys(res.result||[]);
      });
    }
    setvisible({ ...visible, visible: true, type, record });
  }
  // 保存
  function saveEdit() {
    if (visible.type === 'edit') {
      const changeKeys = selectAllKeys
        .filter(item => !selectedKeys.includes(parseInt(item)))
        .map(item => parseInt(item));
      const changeKeys2 = selectedKeys
        .filter(item => !selectAllKeys.includes(item.toString()))
        .map(item => parseInt(item));
      if (changeKeys.length + changeKeys2.length) {
        updateRoleRelationMenu({ id: visible.record.id, menuIdList: [...changeKeys, ...changeKeys2] }).then(res => {
          message.success('操作成功');
          setrefresh(!refresh);
        });
      }
    } else {
      form.validateFields().then(value => {
        addRoleManagerWithCheck(value).then(res => {
          message.success('操作成功');
          setrefresh(!refresh);
        })
      });
    }
    resetForm();
  }
  // 取消
  function resetForm() {
    form.resetFields();
    setvisible({ ...visible, visible: false });
  }

  function changeSelect(changeKeys) {
    selectAllKeys = changeKeys;
  }

  return (
    <>
      <Button type="primary" onClick={editMenu.bind(null, 'add')}>
        新增
      </Button>
      <Table action="roleManger/getList" columns={columns} rowKey="id" refresh={refresh} noPage />
      <Modal
        title="新增/修改"
        width={700}
        visible={visible.visible}
        onOk={saveEdit}
        onCancel={resetForm}
        okText="确认"
        cancelText="取消"
      >
        {visible.type === 'add' ? (
          <Form {...formItemLayout}>
            <Form.Item name="roleName" label="角色名称">
              {form.getFieldDecorator('roleName', {
                rules: [{ required: true, message: '请输入角色名称' }],
              })(<Input placeholder="请输入角色名称" />)}
            </Form.Item>
          </Form>
        ) : (
            <AuthTreeSelect onChange={changeSelect} selectedKeys={selectedKeys} />
          )}
      </Modal>
    </>
  );
}

export default connect()(Form.create()(Role));
