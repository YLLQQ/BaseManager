import request from '@/utils/request';

export async function updateManagerPassword(params) {
  return request('/manager/password/update', {
    method: 'POST',
    data: params,
  });
}

export async function getManagerById(id) {
  return request(`/manager/info/${id}`);
}

export async function allManagerWithPage(params) {
  return request('/manager/info/all', { params });
}
