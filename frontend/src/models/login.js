import { router } from 'umi';
import { getPageQuery, setSessionStorage } from '@/utils';
import { stringify } from 'querystring';
import { accountLogin } from '@/services/login';
import Base64  from 'base-64';
 
export default {
  namespace: 'login',
  state: {},
  effects: {
    *login({ payload }, { call, put }) {
      const response = yield call(accountLogin, payload);
      if (response.code === 200) {
        let token = response.result;

        let start = token.indexOf('.');
        let end = token.lastIndexOf('.');
        let issuerString = token.slice(start + 1, end);
        let issuer = JSON.parse(JSON.parse(Base64.decode(issuerString)).iss);

        for (let key in issuer) {
          setSessionStorage(key, issuer[key]);
        }

        setSessionStorage('token', token);

        yield put({ type: 'menu/getAllMenuInfoListWithLoginManagerId' });

        const urlParams = new URL(window.location.href);
        const params = getPageQuery();
        let { redirect } = params;

        if (redirect) {
          const redirectUrlParams = new URL(redirect);

          if (redirectUrlParams.origin === urlParams.origin) {
            redirect = redirect.substr(urlParams.origin.length);

            if (redirect.match(/^\/.*#/)) {
              redirect = redirect.substr(redirect.indexOf('#') + 1);
            }
          } else {
            window.location.href = '/';
            return;
          }
        }
        router.replace(redirect || '/welcome');
      }
    },

    logout() {
      const { redirect } = getPageQuery(); // Note: There may be security issues, please note

      if (window.location.pathname !== '/login' && !redirect) {
        router.replace({
          pathname: '/login',
          search: stringify({
            redirect: window.location.href,
          }),
        });
      }
    },
  },
  reducers: {},
};
