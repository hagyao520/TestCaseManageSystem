package com.xiaoju.framework.entity.persistent;

import lombok.Data;

import java.util.Date;

/**
 * 执行记录
 *
 * @author 刘智
 * @date 2019/09/29
 */
@Data
public class ExecRecord {

    private Long id;

    private Long caseId;

    private String title;

    /**
     * 默认0,环境
     */
    @Deprecated
    private Integer env;

    /**
     * 执行任务的执行记录
     */
    private String caseContent;

    private Integer isDelete;

    /**
     * 用例执行数
     */
    private Integer passCount;

    /**
     * 用例总数
     */
    private Integer totalCount;

    private String creator;

    private String modifier;

    private Date gmtCreated;

    private Date gmtModified;

    /**
     * 用例通过数
     */
    private Integer successCount;

    /**
     * 用例忽略数 -- 不需要执行 -- 也不计算在内
     */
    private Integer ignoreCount;

    /**
     * 用例阻塞数
     */
    private Integer blockCount;

    /**
     * 用例失败数
     */
    private Integer failCount;

    /**
     * 执行人
     */
    private String executors;

    /**
     * 描述
     */
    private String description;

    /**
     * 圈选用例选项 {"priority":[1,2,3]} priority：0-所有用例，1-p0用例，2-p1用例，3-p2用例
     */
    private String chooseContent;

    /**
     * 计划开始时间
     */
    private Date expectStartTime;

    /**
     * 计划结束时间
     */
    private Date expectEndTime;

    /**
     * 实际开始时间
     */
    @Deprecated
    private Date actualStartTime;

    /**
     * 实际解决时间
     */
    @Deprecated
    private Date actualEndTime;

    /**
     * 负责人
     */
    private String owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEnv() {
        return env;
    }

    public void setEnv(Integer env) {
        this.env = env;
    }

    public String getCaseContent() {
        return caseContent;
    }

    public void setCaseContent(String caseContent) {
        this.caseContent = caseContent;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getPassCount() {
        return passCount;
    }

    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
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

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getIgnoreCount() {
        return ignoreCount;
    }

    public void setIgnoreCount(Integer ignoreCount) {
        this.ignoreCount = ignoreCount;
    }

    public Integer getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(Integer blockCount) {
        this.blockCount = blockCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public String getExecutors() {
        return executors;
    }

    public void setExecutors(String executors) {
        this.executors = executors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChooseContent() {
        return chooseContent;
    }

    public void setChooseContent(String chooseContent) {
        this.chooseContent = chooseContent;
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

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
