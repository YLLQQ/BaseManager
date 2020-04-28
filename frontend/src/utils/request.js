/**
 * request 网络请求工具
 * 更详细的 api 文档: https://github.com/umijs/umi-request
 */
import { extend } from 'umi-request';
import { notification, message, Modal } from 'antd';
import { getSessionStorage } from './index';
import { router } from 'umi';
import { stringify } from 'querystring';

const { confirm } = Modal;

const codeMessage = {
  400: '发出的请求有错误，服务器没有进行新建或修改数据的操作。',
  401: '用户没有权限（令牌、用户名、密码错误）。',
  403: '用户得到授权，但是访问是被禁止的。',
  404: '发出的请求针对的是不存在的记录，服务器没有进行操作。',
  406: '请求的格式不可得。',
  410: '请求的资源被永久删除，且不会再得到的。',
  422: '当创建一个对象时，发生一个验证错误。',
  500: '服务器发生错误，请检查服务器。',
  502: '网关错误。',
  503: '服务不可用，服务器暂时过载或维护。',
  504: '网关超时。',
};

const tokenErrCode = [9001, 9002, 9003, 9004, 9005];

let hasConfirm = false;
/**
 * 异常处理程序
 */

const errorHandler = error => {
  const { response } = error;
  const errorText = codeMessage[response.status];
  const { status, path } = response;
  if (response && response.status && errorText) {
    notification.error({
      message: `请求错误 ${status}: ${path}`,
      description: errorText,
    });
    return null;
  } else if (!response) {
    notification.error({
      description: '您的网络发生异常，无法连接服务器',
      message: '网络异常',
    });
    return null;
  }

  return response;
};

/**
 * 配置request请求时的默认参数
 */
const request = extend({
  // prefix: process.env.NODE_ENV === 'development' ? 'http://192.168.1.10:9999' : 'http://112.13.200.63:8088/api',
  prefix: process.env.NODE_ENV === 'development' ? 'http://127.0.0.1:9999' : 'http://112.13.200.63:8088/api',
  // prefix: process.env.NODE_ENV === 'development' ? '' : '',
});

request.interceptors.request.use((url, options) => {
  const token = getSessionStorage('token');
  if (!token) {
    return {
      url,
      options: {
        ...options,
        headers: {
          ...options.headers,
          'Content-Type': 'application/json;charset=UTF-8',
        },
      },
    };
  }
  return {
    url,
    options: {
      ...options,
      headers: {
        ...options.headers,
        Authorization: token,
        'Content-Type': 'application/json;charset=UTF-8',
      },
    },
  };
});

request.interceptors.response.use(async (response, options) => {
  if (!response.json) {
    return Promise.reject('响应体转换无法转换成json');
  }
  if (hasConfirm) {
    return Promise.reject({ err: 'token err' });
  }
  const data = await response.json();
  const errInfo = errorHandler({ response });

  return new Promise((resolve, reject) => {
    if (data.code === 200 || data.code === 1001) {
      resolve(data);
      return data;
    }
    if (tokenErrCode.includes(data.code) && !hasConfirm) {
      hasConfirm = true;
      const queryString = stringify({
        redirect: window.location.href,
      });
      console.log(111);
      confirm({
        title: '温馨提示',
        content: '登录超时请重新登录',
        onOk() {
          router.push(`/login?${queryString}`);
          hasConfirm = false;
        },
        onCancel() {
          router.push(`/login?${queryString}`);
          hasConfirm = false;
        },
      });
      return;
    }
    if (errInfo && !hasConfirm) {
      message.error(data.message);
    }
    reject(data);
  });
});

export default request;
