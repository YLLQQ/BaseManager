import React from 'react';
import { Upload, Modal, Icon } from 'antd';
import { getFileURL } from '@/utils';

class JNUpload extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      previewVisible: false,
      previewImage: null,
    };
  }

  beforeUpload = file => {
    const { beforeUpload } = this.props;
    if (typeof beforeUpload === 'function') {
      return beforeUpload(file);
    }
    return true;
  };

  updateImgList = ({ file, onSuccess, onError }) => {
    const { onUploadSuccess, dispatch, model, ossPathType } = this.props;
    if (model === 'oss') {
      const form = new FormData();
      form.append('file', file);
      form.append('ossPathType', ossPathType);
      dispatch({ type: 'global/uploadFileToOss', payload: form }).then(res => {
        if (res.code !== '0') {
          onError(new Error(res.chDesc));
          return false;
        }
        onSuccess(res.data, file);
        if (typeof onUploadSuccess === 'function') {
          onUploadSuccess(res);
        }
      });
    } else {
      onSuccess(file, file);
    }
  };

  onPreview = file => {
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    });
  };

  handleCanceModel = () => this.setState({ previewVisible: false });
  previewFile = () => {
    const { fileList, type } = this.props;
    const laestImg = fileList[0].url || (fileList[0].file && getFileURL(fileList[0].file));
    const title = fileList[0] && fileList[0].title;
    if (type === 'file') {
      return <span style={{ width: '104px', display: 'block' }}>{title}</span>;
    }
    return <img style={{ width: '100%', maxHeight: '104px' }} src={laestImg} alt={title} />;
  };
  render() {
    const { single, fileList = [], maxlength = Infinity, ...otherProps } = this.props;
    const { previewVisible, previewImage } = this.state;
    return (
      <div>
        <Upload
          showUploadList={!single}
          fileList={fileList}
          {...otherProps}
          beforeUpload={this.beforeUpload}
          customRequest={this.updateImgList}
          onPreview={this.onPreview}
        >
          {single && fileList.length
            ? this.previewFile()
            : fileList.length < maxlength && (
                <div>
                  <Icon type="plus" />
                  <div className="ant-upload-text">上传</div>
                </div>
              )}
        </Upload>
        <Modal visible={previewVisible} footer={null} onCancel={this.handleCanceModel}>
          <img alt="example" style={{ width: '100%' }} src={previewImage} />
        </Modal>
      </div>
    );
  }
}

export default JNUpload;
