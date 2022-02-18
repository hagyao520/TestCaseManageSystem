import React from 'react'
import './less/login.less'
import { Form, Input, Checkbox, Button, Icon, message } from 'antd'
import request from '@/utils/axios'
import utils from '@/utils'

class LogIn extends React.PureComponent {
  constructor(props) {
    super(props)
    this.state = {
      type: '1', // 当前为什么类型 1：登录 2： 注册 3： 忘记密码
      loading: false, // 点击注册登录
    }
  }

  typeChange = type => {
    this.setState({ type }, () => {
      this.props.form.resetFields()
    })
  }

  onOk = () => {
    this.props.form.validateFields((error, value) => {
      if (error) return
      this.setState({ loading: true })
      if (this.state.type === '1') {
        // 登录
        request(`/user/login`, {
          method: 'POST',
          body: { ...value },
        }).then(res => {
          if (res && res.code === 200) {
            message.success('登陆成功')
            window.location.href = `/case/caseList/1`
            // window.location.href = utils.getQueryString('jumpto')
          } else {
            message.error(res.msg)
          }
          this.setState({ loading: false })
        })
      } else if (this.state.type === '2') {
        // 注册
        request(`/user/register`, {
          method: 'POST',
          body: { ...value },
        }).then(res => {
          if (res && res.code === 200) {
            message.success('注册成功')
            window.location.href = `/case/caseList/1`
            // window.location.href = utils.getQueryString('jumpto')
          } else {
            message.error(res.msg)
          }
          this.setState({ loading: false })
        })
      } else if (this.state.type === '3') {
        // 忘记密码
        request(`/user/updatePassWord`, {
          method: 'POST',
          body: { ...value },
        }).then(res => {
          if (res && res.code === 200) {
            message.success('修改成功')
            this.typeChange('1')
          } else {
            message.error(res.msg)
          }
          this.setState({ loading: false })
        })
      }
    })
  }

  render() {
    const { getFieldDecorator } = this.props.form
    const { type, loading } = this.state
    return (
      <div className="login">
        <div className={type != '3' ? "card" : "card1"}>
          <div className="title">
            银户通<span>一套敏捷的测试用例管理平台</span>
          </div>
          {
            type != '3' ? <span
              className={type === '1' ? 'btn btn_active' : 'btn'}
              onClick={() => this.typeChange('1')}
            >
              登录
            </span> : null
          }
          {
            type != '3' ? <span
              className={type === '2' ? 'btn btn_active' : 'btn'}
              onClick={() => this.typeChange('2')}
            >
              注册
            </span> : null
          }
          {
            type === '3' ? <span
              className={type === '2' ? 'btn btn_active' : 'btn'}
              style={{ width: '400px' }}
              onClick={() => this.typeChange('1')}
            >
              修改密码
            </span> : null
          }
          <div className="input">
            <Form.Item label="">
              {
                getFieldDecorator('username', {
                  rules: [
                    {
                      required: true,
                      message: '请填写中文账号'
                    },
                    {
                      max: 10,
                      message: '请填写10位以内的中文账号'
                    },
                    {
                      // pattern: new RegExp('[\u4e00-\u9fa5]'),
                      pattern: new RegExp('^[\u4e00-\u9fa5]*[0-9]*$'),
                      message: '用户名必须为汉字或者数字'
                    }
                  ],
                  initialValue: undefined,
                })(
                  <Input placeholder="中文账号" maxlength="11" prefix={<Icon type="user" />} />
                )
              }
            </Form.Item>
            <Form.Item label="">
              {
                getFieldDecorator('password', {
                  rules: [{ required: true, message: type != '3' ? '请填写密码' : '请填写新密码' }],
                  initialValue: undefined,
                })(
                  <Input.Password placeholder={type != '3' ? "密码" : '新密码'} maxlength="30" prefix={<Icon type="lock" />
                  } />
                )
              }
            </Form.Item>
            {
              type === '3'
                ? <Form.Item label="">
                  {
                    getFieldDecorator('newpassword', {
                      rules: [{ required: true, message: '请填写确认新密码' }],
                      initialValue: undefined,
                    })(
                      <Input.Password placeholder="确认新密码" maxlength="30" prefix={<Icon type="lock" />
                      } />
                    )
                  }
                </Form.Item>
                : null
            }
            {/* {type === '1' && (
                <Form.Item label="">
                  {
                    getFieldDecorator('password', {
                      rules: [{ required: true, message: '请填写密码' }],
                      initialValue: undefined,
                    })(
                      <Input.Password placeholder="密码" prefix={<Icon type="lock" />
                      } />
                    )
                  }
                </Form.Item>
              )}
              {type === '2' && (
                <Form.Item label="">
                  {
                    getFieldDecorator('password', {
                      rules: [{ required: true, message: '请填写密码' }],
                      initialValue: undefined,
                    })(
                      <Input.Password placeholder="密码" prefix={<Icon type="lock" />} />
                    )
                  }
                </Form.Item>
              )} */}
            <Form.Item>
              {
                type != '3'
                  ? getFieldDecorator('isLogin', {
                    valuePropName: 'checked',
                    initialValue: true
                  })(
                    <Checkbox style={{ top: '-15px' }}>记住登录状态（默认1天）</Checkbox>
                  ) : null
              }
              {
                type != '3'
                  ? <a href="#" style={{ position: 'absolute', left: '345px', width: '60px', top: '-25px' }} onClick={() => this.typeChange('3')}>忘记密码</a>
                  : null
              }
            </Form.Item>
          </div>
          <Button type="primary" style={{ top: '-30px' }} className="onBtn" loading={loading} onClick={() => this.onOk()}>
            {type === '1' ? '登录' : type === '2' ? '注册并登录' : '确认修改'}
          </Button>
        </div>
      </div >
    )
  }
}

export default Form.create()(LogIn)
