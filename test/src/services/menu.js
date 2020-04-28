import request from '@/utils/request';

export async function getAllMenuInfoList(params) {
  return request('/menu/all', { params });
}


export async function addMenuInfo(data) {
  return request('/menu/add', {
    method: 'POST',
    data,
  });
}

export async function updateMenuInfo(data) {
  return request('/menu/update', {
    method: 'POST',
    data,
  });
}

export async function getAllMenuIdListByRoleId(id) {
  return request(`/relation/allMenuId/${id}`);
}

export async function getAllMenuInfoListWithLoginManagerId(params) {
  return request('/menu/all/role', {
    params,
  });
}

export async function updateRoleRelationMenu(data) {
  return request('/relation/menuRole/update', {
    method: 'POST',
    data,
  });
}
