import React, { useState } from 'react';
import { Button } from 'antd';
import EditForm from './editForm';
import Table from '@/components/Table/AutoTable';
import { allManagerWithPage } from '@/services/account';

function Index(props) {

    const [visible, setVisible] = useState(false);
    const [editItem, setEditItem] = useState(null);
    const [refresh, setRefresh] = useState(false);

    function openModal(editItem = null) {
        setVisible(true);
        setEditItem(editItem);
    }

    function closeModal() {
        setRefresh(!refresh);
        setVisible(false);
        setEditItem(null);
    }

    const columns = [
        {
            title: '登录账号',
            dataIndex: 'loginName',
        },
        {
            title: '角色',
            dataIndex: 'roleName',
        },
        {
            title: '操作',
            dataIndex: 'options',
            export: false,
            render: (text, record) => {
                return (
                    <div className="btn-wrapper">
                        <Button
                            className="f-12"
                            type="link"
                            size="small"
                            onClick={openModal.bind(null, { record, type: 'edit' })}
                        >
                            修改
                        </Button>
                    </div>
                );
            },
        },
    ];

    return (
        <div>
            <Button type="primary" onClick={openModal.bind(null, 'add')}>
                新增
            </Button>
            <Table
                interFace={allManagerWithPage}
                columns={columns}
                rowKey="id"
                refresh={refresh}
            />
            <EditForm editItem={editItem} visible={visible} onClose={closeModal} />
        </div>
    );

}

export default Index;