import { roleManagerList } from '@/services/role';

const initialState = {
  dataSource: [],
  params: {},
};

export default {
  namespace: 'roleManger',
  state: initialState,
  effects: {
    *getList({ payload }, { put, call, select }) {
      const {
        roleManger: { params },
      } = yield select();
      const response = yield call(roleManagerList, { ...payload, ...params });
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