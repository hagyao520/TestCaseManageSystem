package com.xiaoju.framework.entity.response.records;

import lombok.Data;

import java.util.Date;

/**
 * 脑图 - 执行任务上方的概览信息
 *
 * @author hcy
 * @date 2020/10/28
 */
@Data
public class RecordGeneralInfoResp {

    private Long id;

    private Long caseId;

    private String title;

    /**
     * 预计周期
     */
    private Date expectStartTime;

    private Date expectEndTime;

    /**
     * 需求id
     */
    private String requirementIds;

    /**
     * 用例执行数
     */
    private int passCount;

    /**
     * 用例总数
     */
    private int totalCount;

    /**
     * 用例通过数
     */
    private int successCount;

    /**
     * 用例失败数
     */
    private int bugNum;

    /**
     * 用例阻塞数
     */
    private int blockCount;

    /**
     * 忽略个数
     */
    private int ignoreCount;

    /**
     * 通过率
     */
    private double passRate;

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

    public String getRequirementIds() {
        return requirementIds;
    }

    public void setRequirementIds(String requirementIds) {
        this.requirementIds = requirementIds;
    }

    public int getPassCount() {
        return passCount;
    }

    public void setPassCount(int passCount) {
        this.passCount = passCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getBugNum() {
        return bugNum;
    }

    public void setBugNum(int bugNum) {
        this.bugNum = bugNum;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public int getIgnoreCount() {
        return ignoreCount;
    }

    public void setIgnoreCount(int ignoreCount) {
        this.ignoreCount = ignoreCount;
    }

    public double getPassRate() {
        return passRate;
    }

    public void setPassRate(double passRate) {
        this.passRate = passRate;
    }
}
