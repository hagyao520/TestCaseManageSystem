package com.xiaoju.framework.entity.response.dir;

import lombok.Data;

import java.util.List;

/**
 * 目录结构
 *
 * @author hcy
 * @date 2020/9/4
 */
@Data
public class BizNodeResp {

    /**
     * 文件夹id
     */
    private Long bizId;

    /**
     * 文件夹名称
     */
    private String bizName;

    /**
     * 树编号 如果传出-1 表示是<未分类的用例>
     */
    private Integer treeNo;

    /**
     * 业务线id
     */
    private Long lineId;

    /**
     * 子列表
     */
    private List<BizNodeResp> childs;

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public Integer getTreeNo() {
        return treeNo;
    }

    public void setTreeNo(Integer treeNo) {
        this.treeNo = treeNo;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public List<BizNodeResp> getChilds() {
        return childs;
    }

    public void setChilds(List<BizNodeResp> childs) {
        this.childs = childs;
    }
}
