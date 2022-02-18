package com.xiaoju.framework.entity.response.cases;

import lombok.Data;

/**
 * 脑图-查看用例上方的概览信息(不包括content)
 *
 * @author hcy
 * @date 2020/10/22
 */
@Data
public class CaseGeneralInfoResp {

    private Long id;

    private String title;

    private String requirementId;

    private Long productLineId;

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

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }
}
