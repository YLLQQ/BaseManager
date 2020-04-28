import { connect } from 'dva';
import { Layout, Menu, Icon } from 'antd';
import { useEffect, useState } from 'react';
import classnames from 'classnames';
import Link from 'umi/link';
import styles from './index.less';

function LeftMenu(props) {
  const {
    menu: { menuInfo, collapsed },
  } = props;
  const [menu, setMenu] = useState(null);
  useEffect(() => {
    function renderSubMenu(item) {
      return (
        <Menu.SubMenu
          key={item.id}
          title={
            <span>
              {item.menuIconPath && <Icon type={item.menuIconPath} />}
              <span className="nav-text">{item.menuName}</span>
            </span>
          }
        >
          {item.children ? getMenuList(item.children) : item.renderMenuItem(item)}
        </Menu.SubMenu>
      );
    }

    function renderMenuItem(item, isFirstLayer) {
      return (
        <Menu.Item key={item.id}>
          <Link to={item.menuLinkPath || '/welcome'}>
            {isFirstLayer && item.iconName && <Icon type={item.iconName} />}
            <span>{item.menuName}</span>
          </Link>
        </Menu.Item>
      );
    }

    function getMenuList(menuInfo) {
      return (
        menuInfo &&
        menuInfo.map(item => (item.children ? renderSubMenu(item) : renderMenuItem(item, true)))
      );
    }
    setMenu(getMenuList(menuInfo));
  }, [menuInfo]);

  const layout = classnames(styles.container, { [styles.collapsed]: collapsed });
  return (
    <Layout className={layout}>
      <div className={styles.iconName}></div>
      <Menu
        theme="dark"
        mode="inline"
        inlineCollapsed={collapsed}
        defaultSelectedKeys={window.location.pathname}
        defaultOpenKeys={[window.location.pathname.split('/')[1]]}
      >
        {menu}
      </Menu>
    </Layout>
  );
}

export default connect(({ menu }) => ({ menu }))(LeftMenu);
