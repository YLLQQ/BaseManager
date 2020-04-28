import request from '@/utils/request';

export async function accountLogin(params) {
  return request('/manager/info', {
    method: 'POST',
    data: params,
  });
}
