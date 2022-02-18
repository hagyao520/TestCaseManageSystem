/** 历史版本对比结果 */
import React from 'react'
import AgileTCEditor from 'react-agiletc-editor'
import { Button, message, Spin, Card, Tag } from 'antd'
import moment from 'moment'
moment.locale('zh-cn')
import request from '@/utils/axios'
import Headers from '../../layouts/headers'
import './index.scss'

class SeeResult extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      loading: false,
      info: [],
    }
  }
  componentDidMount() {
    this.setState({ loading: true })
    request(`/backup/getCaseDiff`, {
      method: 'GET',
      params: {
        caseId1: this.props.match.params.caseId1,
        caseId2: this.props.match.params.caseId2,
      },
    }).then(res => {
      this.setState({ loading: false })
      if (res.code === 200) {
        this.editorNode.setEditerData(res.data.content.root)
        this.setState({ info: res.data.backupinfo })
      } else {
        message.error(res.msg)
      }
    })
  }
  //返回列表
  returnCaseList = () => {
    window.history.back();
  }
  render() {
    return (
      <React.Fragment>
        <Headers />
        <Spin tip="Loading..." spinning={this.state.loading}>
          <div className="historyBox">
            <div className="box_title">
              <Card bordered={false} title="版本比较" className="title_history">
                <div style={{ display: 'flex' }}>
                  {this.state.info &&
                    this.state.info.map((item, i) => (
                      <Card style={{ marginRight: 20 }} key={i}>
                        <span>
                          创建人: {item.user}
                          <br />
                          创建时间: {moment(item.time).format('YYYY-MM-DD HH:mm:ss')}
                        </span>
                      </Card>
                    ))}
                </div>
              </Card>
              <Card bordered={false} title="颜色标识" className="title_color">
                <Tag color="#ddfade">该节点被添加</Tag>
                <Tag color="#ffe7e7">该节点被删除</Tag>
                <Tag color="#d6f0ff">内容已变更</Tag>
              </Card>
            </div>
            <div
              style={{
                display: 'inline-block',
                position: 'fixed',
                bottom: '30px',
                right: '20px',
                zIndex: 999,
              }}
            >
              <Button type="primary" onClick={this.returnCaseList}>
                返回
              </Button>
              <span> &nbsp; &nbsp;</span>
            </div>
            <AgileTCEditor
              ref={editorNode => (this.editorNode = editorNode)}
              tags={['前置条件', '执行步骤', '预期结果']}
              progressShow={false}
              readOnly={true}
              mediaShow={true}
              editorStyle={{ height: 'calc(100vh - 240px)' }}
              toolbar={{
                image: true,
                theme: [
                  'classic',             //脑图经典
                  'classic-compact',     //紧凑经典
                  'snow',                //温柔冷光
                  'snow-compact',        //紧凑冷光
                  'fish',                //鱼骨图
                  'wire',                //线框
                  'fresh-red',           //清新红
                  'fresh-soil',          //泥土黄
                  'fresh-green',         //文艺绿
                  'fresh-blue',          //天空蓝
                  'fresh-purple',        //浪漫紫
                  'fresh-pink',          //脑残粉
                  'fresh-red-compat',    //紧凑红
                  'fresh-soil-compat',   //紧凑黄
                  'fresh-green-compat',  //紧凑绿
                  'fresh-blue-compat',   //紧凑蓝
                  'fresh-purple-compat', //紧凑紫
                  'fresh-pink-compat',   //紧凑粉
                  'tianpan',             //经典天盘
                  'tianpan-compact',     //紧凑天盘
                ],
                template: [
                  'default',   //思维导图
                  'right',     //逻辑结构图
                  'fish-bone', //鱼骨头图
                  'tianpan',   //天盘图
                  'structure', //组织结构图
                  'filetree',  //目录组织图
                ],
                noteTemplate: '# test',
              }}
              uploadUrl="/api/file/uploadAttachment"
              // wsUrl="ws://localhost:8094/api/case/9999/1/0/刘智"
              wsUrl={`ws://${window.location.host}/api/case/9999/1/0/刘智`}
              // wsUrl={`ws://${window.location.host}/api/case/${caseId}/${itemid}/${iscore}/${user}`}
              type="compare"
            />
          </div>
        </Spin>
      </React.Fragment>
    )
  }
}
export default SeeResult
