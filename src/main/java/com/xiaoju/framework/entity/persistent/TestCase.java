package com.xiaoju.framework.entity.persistent;

import lombok.Data;

import java.util.Date;

/**
 * 用例
 *
 * @author 刘智
 * @date 2019/7/12
 */
@Data
public class TestCase {
    private Long id;

    private Long groupId;

    private String title;

    private String description;

    private Integer isDelete;

    private String creator;

    private String modifier;

    private Date gmtCreated;

    private Date gmtModified;

    private String extra;

    private Long productLineId;

    private Integer caseType;

    /**
     * 模块id 已经废弃
     */
    @Deprecated
    private Long moduleNodeId;

    private String requirementId;

    /**
     * 冒烟用例id，目前冒烟用例已经集成到执行任务中，废弃
     */
    @Deprecated
    private Long smkCaseId;

    private String caseContent;

    private Integer channel;

    private String bizId;

    // public Long getId() {
    // return id;
    // }

    // public void setId(Long id) {
    // this.id = id;
    // }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public Long getModuleNodeId() {
        return moduleNodeId;
    }

    public void setModuleNodeId(Long moduleNodeId) {
        this.moduleNodeId = moduleNodeId;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public Long getSmkCaseId() {
        return smkCaseId;
    }

    public void setSmkCaseId(Long smkCaseId) {
        this.smkCaseId = smkCaseId;
    }

    public String getCaseContent() {
        return caseContent;
    }

    public void setCaseContent(String caseContent) {
        this.caseContent = caseContent;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}