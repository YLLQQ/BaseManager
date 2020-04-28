import request from '@/utils/request';

export async function roleManagerList(params) {
  return request('/role/all', { params });
}

export async function addRoleManagerWithCheck(data) {
  return request('/role/add', {
    method: 'POST',
    data,
  });
}
