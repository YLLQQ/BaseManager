import {
  getAllMenuInfoList,
  updateMenuInfo,
  getAllMenuIdListByRoleId,
  getAllMenuInfoListWithLoginManagerId,
} from '@/services/menu';

const initialState = {
  menuInfo: [],
  getMenuCount: 0,
  collapsed: false,
};
export default {
  state: initialState,
  reducers: {
    toggleMenu(state) {
      return {
        ...state,
        collapsed: !state.collapsed,
      };
    },
    setMenuInfo(state, { payload }) {
      return {
        ...state,
        getMenuCount: 1,
        menuInfo: payload,
      };
    },
  },
  effects: {
    *getAllMenuInfoList({ payload }, { put, call }) {
      return yield call(getAllMenuInfoList, payload);
    },
    *updateMenuInfo({ payload }, { put, call }) {
      return yield call(updateMenuInfo, payload);
    },
    *getAllMenuIdListByRoleId({ payload }, { put, call }) {
      return yield call(getAllMenuIdListByRoleId, payload);
      // if (res.result) {
      //   yield put({ type: 'setMenuInfo', payload: res.result });
      // }
    },
    *getAllMenuInfoListWithLoginManagerId({ payload }, { put, call }) {
      const res = yield call(getAllMenuInfoListWithLoginManagerId, payload);
      if (res.result) {
        yield put({ type: 'setMenuInfo', payload: res.result });
      }
    },
  },
};
