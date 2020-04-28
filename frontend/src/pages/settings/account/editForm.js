import { Form, Input, Modal, Select } from 'antd';
import { connect } from 'dva';
import React, { useState, useLayoutEffect, useEffect } from 'react';
import { formItemLayout } from '@/utils/const';
import CryptoJS from 'crypto-js';
import { updateManagerPassword, getManagerById, addManager } from '@/services/account';
import { roleManagerList } from "@/services/role";

const typeMap = new Map([
  ['watch', '查看'],
  ['edit', '编辑'],
  ['add', '新增'],
]);

function EditForm(props, ref) {
  const {
    visible,
    onClose,
    editItem,
    form: {
      getFieldDecorator,
      validateFieldsAndScroll,
      setFieldsValue,
      resetFields,
      getFieldValue,
      validateFields,
    },
  } = props;
  const { record, type = 'add' } = editItem || {};

  const [disabled, setdisabled] = useState(false);
  const [roleList, setRoleList] = useState([]);

  useEffect(() => {
    roleManagerList().then(res => {
      setRoleList(res.result)
    })
  }, []);

  useLayoutEffect(() => {
    if (!record) {
      return;
    }
    getManagerById(record.id).then(res => {
      const {
        id,
        loginName,
        roleName,
        roleId
      } = res.result || {};
      const formData = {
        id,
        loginName,
        roleName,
        roleId
      };
      switch (type) {
        case 'edit':
          setFieldsValue(formData);
          setdisabled(false);
          break;
        case 'watch':
          setFieldsValue(formData);
          setdisabled(true);
          break;
        default:
          resetFields();
          setdisabled(false);
          break;
      }
    });
  }, [type, setFieldsValue, record, resetFields]);

  function onOk() {
    if (type === 'watch') {
      onClose();
      return;
    }
    validateFieldsAndScroll((err, values) => {
      if (!!err) {
        return false;
      }

      let pormise = addManager;

      if (type === 'edit') {
        pormise = updateManagerPassword;
      }

      pormise({
        ...values,
        password:
          values.password !== '' && values.password
            ? CryptoJS.MD5(values.password).toString()
            : null,
      }).then(res => {
        onClose();
      });
    });
  }

  function compareToFirstPassword(rule, value, callback) {
    if (value && value !== getFieldValue('password')) {
      callback('两次密码不相同，请确认密码');
    } else {
      callback();
    }
  }

  function validateToNextPassword(rule, value, callback) {
    console.log(getFieldValue('confirm'));
    if (value) {
      validateFields(['confirm'], { force: true });
    }
    callback();
  }
  return (
    <Modal
      title={typeMap.get(type)}
      visible={visible}
      onCancel={onClose}
      onOk={onOk}
      style={{ height: '80%' }}
      width="800px"
      wrapClassName="modal-wrapper"
      className="modal-inner"
      destroyOnClose
    >
      <Form {...formItemLayout}>
        {type === 'edit' && (
          <Form.Item label="账户编号">
            {getFieldDecorator('id', {
              rules: [{ required: true, message: '必填' }],
            })(<span>{getFieldValue('id')}</span>)}
          </Form.Item>
        )}
        <Form.Item label="登录账户">
          {getFieldDecorator('loginName', { rules: [{ required: true, message: '必填' }], })(<Input />)}
        </Form.Item>
        <Form.Item label="角色">
          {getFieldDecorator('roleId', { rules: [{ required: true, message: '必填' }], })(
            <Select style={{ width: 200 }} disabled={!roleList}>
              {
                roleList.map(item => <Select.Option key={item.id} value={item.id}>{item.roleName}</Select.Option>)
              }
            </Select>
          )}
        </Form.Item>
        <Form.Item label="登录密码">
          {getFieldDecorator('password', {
            rules: [
              {
                validator: validateToNextPassword,
              },
            ],
          })(<Input type="password" disabled={disabled} />)}
        </Form.Item>
        <Form.Item label="再次输入密码">
          {getFieldDecorator('confirm', {
            rules: [
              {
                message: '请再次输入密码',
              },
              {
                validator: compareToFirstPassword,
              },
            ],
          })(<Input type="password" disabled={disabled} />)}
        </Form.Item>
      </Form>
    </Modal>
  );
}

export default connect(({ global }) => ({ global }))(Form.create()(EditForm));
