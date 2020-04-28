import 'react';
import { MenuUnfoldOutlined, MenuFoldOutlined } from '@ant-design/icons';
import { connect } from 'dva';
import router from 'umi/router';
import styles from './index.less';
import { removeSessionStorage } from '@/utils';

function Header(props) {
  const {
    menu: { collapsed },
    dispatch,
  } = props;
  const toggleMenu = () => {
    dispatch({ type: 'menu/toggleMenu' });
  };
  const loginOut = () => {
    removeSessionStorage("token");
    router.push('/');
  };
  return (
    <div className={styles.container}>
      <span className={styles.trigger} onClick={toggleMenu}>
        {collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
      </span>
      <span onClick={loginOut}>退出</span>
    </div>
  );
}

export default connect(({ menu }) => ({ menu }))(Header);
