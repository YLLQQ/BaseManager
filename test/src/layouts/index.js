import { Layout, ConfigProvider } from 'antd';
import LeftMenu from './LeftMenu';
import Header from './Header';
import styles from './index.css';
import { useEffect } from 'react';
import { connect } from 'dva';
import { getSessionStorage } from '@/utils';

import zhCN from 'antd/es/locale/zh_CN';
import { router } from 'umi';

function BasicLayout(props) {
  const blankPath = ['/', '/login'];
  const {
    menu: { menuInfo, getMenuCount },
    dispatch,
  } = props;
  const isLogin = blankPath.includes(props.location.pathname);
  const hasLogin = getSessionStorage('token');

  useEffect(() => {
    if (!hasLogin) {
      router.replace('/');
    }
    if (menuInfo.length === 0 && !getMenuCount && !isLogin && hasLogin) {
      dispatch({ type: 'menu/getAllMenuInfoListWithLoginManagerId' });
    }
  }, [dispatch, getMenuCount, hasLogin, isLogin, menuInfo]);

  if (blankPath.includes(props.location.pathname)) {
    return <>{props.children}</>;
  }

  if (hasLogin) {
    return (
      <ConfigProvider locale={zhCN}>
        <Layout className={styles.container}>
          <LeftMenu />
          <Layout>
            <Header />
            <div className={styles['body-wrapper']}>{props.children}</div>
          </Layout>
        </Layout>
      </ConfigProvider>
    );
  }
  return null;
}

export default connect(({ menu }) => ({ menu }))(BasicLayout);
