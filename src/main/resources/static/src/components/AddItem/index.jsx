import React, {forwardRef, useState} from 'react';
import { Modal, Form, Input, Radio, Button, message } from 'antd';
import axios from 'axios';

const AddItem = () => {
    const [form] = Form.useForm();
    const [visible, setVisible] = useState(false);
    const [submitting, setSubmitting] = useState(false);

    const showModal = () => {
        setVisible(true);
    };

    const handleOk = () => {
        form.submit();
    };

    const handleCancel = () => {
        setVisible(false);
    };

    const handleSubmit = async (values) => {
        try {
            setSubmitting(true);
            await axios.post('http://localhost:8080/employee', values);
            setVisible(false);
            message.success('Employee added successfully');
        } catch (error) {
            console.error(error);
            message.error('Failed to add employee');
        } finally {
            setSubmitting(false);
        }
    };

    return (
        <div>
            <Button type="primary" onClick={showModal}>
               添加
            </Button>
            <Modal
                title="Add Employee"
                visible={visible}
                onOk={handleOk}
                onCancel={handleCancel}
                confirmLoading={submitting}
            >
                <Form form={form} onFinish={handleSubmit}>
                    <Form.Item
                        label="Name"
                        name="name"
                        rules={[{ required: true, message: 'Please enter name' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label="Account"
                        name="account"
                        rules={[{ required: true, message: 'Please enter account' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label="Phone"
                        name="phone"
                        rules={[{ required: true, message: 'Please enter phone' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label="Basic Salary"
                        name="basicSalary"
                        rules={[{ required: true, message: 'Please enter basic salary' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label="Title"
                        name="titleId"
                        rules={[{ required: true, message: 'Please enter your title' }]}

                    >
                        <Radio.Group>
                            <Radio value={1}>SE</Radio>
                            <Radio value={2}>PG</Radio>
                        </Radio.Group>
                    </Form.Item>
                    <Form.Item
                        label="Sex"
                        name="sex"
                        rules={[{ required: true, message: 'Please select sex' }]}
                    >
                        <Radio.Group>
                            <Radio value={1}>Male</Radio>
                            <Radio value={2}>Female</Radio>
                        </Radio.Group>
                    </Form.Item>
                </Form>
            </Modal>
        </div>
    );
};

export default AddItem;
