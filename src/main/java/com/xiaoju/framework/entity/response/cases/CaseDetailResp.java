package com.xiaoju.framework.entity.response.cases;

import com.xiaoju.framework.entity.response.dir.BizListResp;
import lombok.Data;

import java.util.List;

/**
 * 用例详情
 *
 * @author hcy
 * @date 2020/9/7
 */
@Data
public class CaseDetailResp {

    private Integer caseType;

    private String description;

    private Long id;

    private String modifier;

    private String requirementId;

    private String title;

    private Long productLineId;

    private List<BizListResp> biz;

    private Long groupId;

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public List<BizListResp> getBiz() {
        return biz;
    }

    public void setBiz(List<BizListResp> biz) {
        this.biz = biz;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
