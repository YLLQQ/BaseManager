import request from '@/utils/request';

export async function addManager(params) {
  return request('/manager/add', {
    method: 'POST',
    data: params,
  });
}

export async function updateManager(params) {
  return request('/manager/update', {
    method: 'POST',
    data: params,
  });
}

export async function accountLogin(params) {
  return request('/manager/login', {
    method: 'POST',
    data: params,
  });
}

export async function getManagerById(id) {
  return request(`/manager/${id}`);
}

export async function allManagerWithPage(params) {
  return request('/manager/all', { params });
}

