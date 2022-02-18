package com.xiaoju.framework.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * 任务的一个简单转换体
 *
 * @author hcy
 * @date 2020/10/29
 */
@Data
public class RecordWsDto {

    private Date updateTime;

    private String executors;

    private Integer env;

    private String caseContent;

    private String chooseContent;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getExecutors() {
        return executors;
    }

    public void setExecutors(String executors) {
        this.executors = executors;
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

    public String getChooseContent() {
        return chooseContent;
    }

    public void setChooseContent(String chooseContent) {
        this.chooseContent = chooseContent;
    }
}
