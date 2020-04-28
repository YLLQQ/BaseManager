import { getAllMenuInfoList, addMenuInfo, updateMenuInfo } from '@/services/menu';

const initialState = {
  dataSource: [],
  params: {},
};

export default {
  namespace: 'menuManger',
  state: initialState,
  effects: {
    *getList({ payload }, { put, call, select }) {
      const {
        menuManger: { params },
      } = yield select();
      const response = yield call(getAllMenuInfoList, { ...payload, ...params });
      return response;
    },
    *addMenuInfo({ payload }, { put, call, select }) {
      const response = yield call(addMenuInfo, payload);
      return response;
    },
    *updateMenuInfo({ payload }, { put, call, select }) {
      const response = yield call(updateMenuInfo, payload);
      return response;
    },
  },
  reducers: {
    setParams(state, { payload }) {
      return {
        ...state,
        params: {
          ...state.params,
          ...payload,
        },
      };
    },
    setDataSource(state, { payload }) {
      return {
        ...state,
        dataSource: payload,
      };
    },
    resetState() {
      return initialState;
    },
  },
};
