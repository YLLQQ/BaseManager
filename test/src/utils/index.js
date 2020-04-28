import { parse } from 'querystring';
import moment from 'moment';
import { message } from 'antd';
import XLSX from 'xlsx';

export const getPageQuery = () => parse(window.location.href.split('?')[1]);

export const getSessionStorage = name => {
  if (!name) {
    return null;
  }
  const storageInfo = window.sessionStorage.getItem(name);
  if (!storageInfo || typeof storageInfo !== 'string') {
    return storageInfo;
  }
  try {
    return JSON.parse(storageInfo);
  } catch (error) {
    return storageInfo;
  }
};

export const setSessionStorage = (name, content) => {
  if (!name) return;
  if (typeof content !== 'string') {
    content = JSON.stringify(content);
  }
  window.sessionStorage.setItem(name, content);
};

export const removeSessionStorage = name => {
  if (!name) return;
  window.sessionStorage.removeItem(name);
};

export const getFileURL = function(file) {
  let getUrl = null;
  if (window.createObjectURL !== undefined) {
    // basic
    getUrl = window.createObjectURL(file);
  } else if (window.URL !== undefined) {
    // mozilla(firefox)
    getUrl = window.URL.createObjectURL(file);
  } else if (window.webkitURL !== undefined) {
    // webkit or chrome
    getUrl = window.webkitURL.createObjectURL(file);
  }
  return getUrl;
};

export const momentFormat = (time, format = 'YYYY-MM-DD HH:mm:ss') => {
  return moment(time).format(format);
};

export const exportXlsx = (sourceData, columns, title = '表单', otherRender = {}, merges = []) => {
  if (!sourceData || sourceData.length === 0) {
    message.warning('暂无数据导出');
    return;
  }
  const method = {
    // 类型转换
    anyToText(reactDOM, col, record) {
      let result = '';

      if (reactDOM === undefined || reactDOM === null) return result;

      if (typeof reactDOM === 'string' || typeof reactDOM == 'number') {
        result = reactDOM;
      }

      if (Array.isArray(reactDOM)) {
        result += reactDOM.map(item => {
          return `${this.anyToText(item)}`;
        });
      }

      if (reactDOM.type === 'img') {
        result += `${reactDOM.props.src},`;
      }

      if (reactDOM.props) {
        if (Array.isArray(reactDOM.props.children)) {
          result += reactDOM.props.children.map(item => {
            if (typeof item !== 'number' && typeof item !== 'string') {
              return `${this.anyToText(item)}/--/`;
            }
            return item;
          });
          return result;
        } else if (typeof reactDOM.props.children == 'object') {
          const value = typeof record[col.dataIndex] === 'undefined' ? '' : record[col.dataIndex];
          const children = reactDOM.props.children.props.children;
          const result = this.anyToText(children);
          if (result) {
            return result;
          }
          if (otherRender[col['dataIndex']]) {
            const r = otherRender[col['dataIndex']](value, record);
            return typeof r === 'undefined' ? '' : r;
          }
          return result;
        }
        return typeof reactDOM.props.children === 'undefined' ? result : reactDOM.props.children;
      }

      return result;
    },
    // 导出xlsx
    exportXLSX() {
      const header = [];
      const data = sourceData.map((item, idx) => {
        const result = {};
        columns.forEach(col => {
          const Key = col.title;
          const value = typeof item[col.dataIndex] === 'undefined' ? '' : item[col.dataIndex];
          if (!idx && col.export !== false) {
            header.push(Key);
          }

          let renderValue;
          if (item[col.dataIndex] === 'Bypassed') {
            renderValue = '';
          } else if (otherRender[col.dataIndex]) {
            renderValue = otherRender[col.dataIndex](value, item, idx);
            renderValue = typeof renderValue === 'undefined' ? '' : renderValue;
          } else {
            renderValue = col.render
              ? this.anyToText(col.render(value, item, idx), col, item)
              : value;
          }

          const dealVal = renderValue
            .toString()
            .split(',')
            .join('')
            .split('/--/')
            .join(',');

          if (col.export !== false) {
            result[Key] = dealVal.endsWith(',') ? dealVal.slice(0, dealVal.length - 1) : dealVal;
          }
        });
        return result;
      });

      var wb = XLSX.utils.book_new();
      /* make worksheet */
      var ws = XLSX.utils.json_to_sheet(data, { header });
      ws['!merges'] = merges;
      /* Add the worksheet to the workbook */
      XLSX.utils.book_append_sheet(wb, ws);
      XLSX.writeFile(wb, `${title}.xlsx`, { compression: true });
    },
  };
  method.exportXLSX();
};

export default {};
