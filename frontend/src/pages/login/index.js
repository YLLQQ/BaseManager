import { Button, Form, Input } from 'antd';
import { connect } from 'dva';
import CryptoJS from 'crypto-js';
import styles from './index.css';
import { UserOutlined, EyeOutlined } from '@ant-design/icons';

const FormItem = Form.Item;
const LoginPage = ({ dispatch, form }) => {
  const gotoLogin = e => {
    e.preventDefault();
    form.validateFields().then(({ managerRoleName, password }) => {
      dispatch({
        type: 'login/login',
        payload: { loginName: managerRoleName, password: CryptoJS.MD5(password).toString() },
      });
    });
  };

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <Form onSubmit={gotoLogin} className={styles['login-form']}>
          <h3>欢迎登录</h3>
          <FormItem>
            {form.getFieldDecorator('managerRoleName', {
              rules: [{ required: true, message: '请输入用户名' }],
            })(<Input placeholder="用户名" prefix={<UserOutlined />} size="large" />)}
          </FormItem>
          <FormItem>
            {form.getFieldDecorator('password', {
              rules: [{ required: true, message: '请输入用户名' }],
            })(<Input type="password" placeholder="密码" prefix={<EyeOutlined />} size="large" />)}
          </FormItem>
          <FormItem>
            <Button
              size="large"
              type="primary"
              htmlType="submit" 
              className={styles['login-form-button']}
            >
              登录
            </Button>
          </FormItem>
        </Form>
      </div>
      <div className={styles['footer']}>版权所有 © 有限公司 2020</div>
    </div>
  );
};

export default connect()(Form.create()(LoginPage));
