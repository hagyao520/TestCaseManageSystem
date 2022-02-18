package com.xiaoju.framework.entity.dto;

import com.xiaoju.framework.service.impl.RecordServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 给getData专用的转换体
 *
 * @author hcy
 * @date 2020/10/28
 * @see RecordServiceImpl#getData(com.xiaoju.framework.entity.dto.MergeCaseDto)
 */
@Data
// @AllArgsConstructor
public class MergeCaseDto {

	private Long caseId;

	private String chooseContent;

	private String recordContent;

	private Integer env;

	private Long recordId;

	public MergeCaseDto(Long caseId, String chooseContent, String recordContent, Integer env, Long recordId) {
		this.caseId = caseId;
		this.chooseContent = chooseContent;
		this.recordContent = recordContent;
		this.env = env;
		this.recordId = recordId;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	public String getChooseContent() {
		return chooseContent;
	}

	public void setChooseContent(String chooseContent) {
		this.chooseContent = chooseContent;
	}

	public String getRecordContent() {
		return recordContent;
	}

	public void setRecordContent(String recordContent) {
		this.recordContent = recordContent;
	}

	public Integer getEnv() {
		return env;
	}

	public void setEnv(Integer env) {
		this.env = env;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
}
