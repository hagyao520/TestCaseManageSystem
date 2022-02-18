package com.xiaoju.framework.entity.dto;

import lombok.Data;

/**
 * 执行任务数量转换体
 *
 * @author 刘智
 * @date 2020/6/9
 */
@Data
public class RecordNumDto {

    /**
     * 所属用例id
     */
    Long caseId;

    /**
     * 任务数量
     */
    Integer recordNum;

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Integer getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(Integer recordNum) {
        this.recordNum = recordNum;
    }
}
