import { Tree, Input } from 'antd';
import { useState, useEffect } from 'react';
import { connect } from 'dva';
import { getAllMenuInfoList } from '@/services/menu';
import styles from './AuthTreeSelect.less';

const TreeNode = Tree.TreeNode;
const { Search } = Input;

// 修改字段名 为适应treeData
function dealDataForKey(data, key, title) {
  data.forEach(item => {
    item.key = item[key];
    item.title = item[title];
    item.children && dealDataForKey(item.children, key, title);
  });
  return data;
}

let allExpandKey = [];
function getAllExpandKey(data) {
  data.forEach(item => {
    allExpandKey.push(item.key);
    item.children && getAllExpandKey(item.children || []);
  });
}

function SearchTree(props) {
  const [expandedKeys, setexpandedKeys] = useState([]);
  const [searchValue, setsearchValue] = useState('');
  const [selectedKeys, setselectedKeys] = useState([]);
  const [data, setdata] = useState([]);
  useEffect(() => {
    setselectedKeys(props.selectedKeys)
    console.log(props.selectedKeys);

  }, [props.selectedKeys])
  useEffect(() => {
    getAllMenuInfoList().then(res => {
      console.log(res);
      const dataSource = dealDataForKey(res.result, 'id', 'menuName');
      setdata(dataSource);
      getAllExpandKey(dataSource);
      setexpandedKeys(allExpandKey);
    });
  }, []);

  function onChange(e) {
    const { value } = e.target;
    setsearchValue(value);
    const expandedKeys = data
      .map(item => {
        if (item.title.indexOf(value) > -1) {
          return item.key;
        }
        return null;
      })
      .filter((item, i, self) => item && self.indexOf(item) === i);
    console.log(expandedKeys);
    setexpandedKeys(expandedKeys);
  }

  function onExpand(expandedKeys) {
    setexpandedKeys(expandedKeys);
  }

  function loop(data) {
    return data.map(item => {
      const index = item.title.indexOf(searchValue);
      const beforeStr = item.title.substr(0, index);
      const afterStr = item.title.substr(index + searchValue.length);
      const title =
        index > -1 ? (
          <span>
            {beforeStr}
            <span style={{ color: '#f50' }}>{searchValue}</span>
            {afterStr}
          </span>
        ) : (
          <span>{item.title}</span>
        );

      if (item.children) {
        return (
          <TreeNode key={item.key} title={title}>
            {loop(item.children)}
          </TreeNode>
        );
      }
      return <TreeNode key={item.key} title={title} />;
    });
  }

  function onSelect(selectedKeys) {
    setselectedKeys(selectedKeys);
    props.onChange(selectedKeys);
  }

  return (
    <div>
      <Search style={{ marginBottom: 8 }} placeholder="请输入菜单名称" onChange={onChange} />
      <div className={styles['tree-content']}>
        {data.length ? (
          <Tree
            onExpand={onExpand}
            autoExpandParent
            defaultExpandAll
            checkable
            onCheck={onSelect}
            checkedKeys={selectedKeys}
            expandedKeys={expandedKeys}
          >
            {loop(data)}
          </Tree>
        ) : null}
      </div>
    </div>
  );
}

export default connect()(SearchTree);
