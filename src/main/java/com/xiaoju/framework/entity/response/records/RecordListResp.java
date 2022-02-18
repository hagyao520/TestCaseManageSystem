package com.xiaoju.framework.entity.response.records;

import lombok.Data;

import java.util.Date;

/**
 * 任务列表查询体
 *
 * @author 刘智
 * @date 2020/10/27
 */
@Data
public class RecordListResp {

    private Long id;

    private String title;

    private String creator;

    /**
     * 任务id，该字段做保留
     */
    private Long recordId;

    /**
     * 用例id
     */
    private Long caseId;

    /**
     * 责任人
     */
    private String owner;

    /**
     * 执行人列表 以逗号分隔
     */
    private String executors;

    /**
     * 失败数
     */
    private Integer bugNum;

    /**
     * 阻塞数
     */
    private Integer blockNum;

    /**
     * 成功数
     */
    private Integer successNum;

    /**
     * 执行总数=失败+阻塞+成功
     */
    private Integer executeNum;

    /**
     * 用例总数，progress=4不会计入
     */
    private Integer totalNum;

    /**
     * 圈选用例内容
     */
    private String chooseContent;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 计划周期-开始时间
     */
    private Date expectStartTime;

    /**
     * 计划周期-结束时间
     */
    private Date expectEndTime;

    /**
     * 用例描述
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getExecutors() {
        return executors;
    }

    public void setExecutors(String executors) {
        this.executors = executors;
    }

    public Integer getBugNum() {
        return bugNum;
    }

    public void setBugNum(Integer bugNum) {
        this.bugNum = bugNum;
    }

    public Integer getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(Integer blockNum) {
        this.blockNum = blockNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public Integer getExecuteNum() {
        return executeNum;
    }

    public void setExecuteNum(Integer executeNum) {
        this.executeNum = executeNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getChooseContent() {
        return chooseContent;
    }

    public void setChooseContent(String chooseContent) {
        this.chooseContent = chooseContent;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Date getExpectStartTime() {
        return expectStartTime;
    }

    public void setExpectStartTime(Date expectStartTime) {
        this.expectStartTime = expectStartTime;
    }

    public Date getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
