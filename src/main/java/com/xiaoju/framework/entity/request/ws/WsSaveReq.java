package com.xiaoju.framework.entity.request.ws;

import com.xiaoju.framework.entity.request.ParamValidate;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 脑图页面保存用例/任务的请求体
 *
 * @author 刘智
 * @date 2020/11/25
 */
@Data
public class WsSaveReq implements ParamValidate {

    /**
     * 传进来的是当前脑图的caseContent 可能是record的也可能是testcase的
     */
    private String caseContent;

    private Long id;

    private String modifier;

    /**
     * 如果是用例页面 则传进来是null 如果是任务页面 则传进来具体的任务id
     */
    private Long recordId;

    @Override
    public void validate() {
        if (StringUtils.isEmpty(caseContent)) {
            throw new IllegalArgumentException("保存的内容为空");
        }
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("用例id为空");
        }
        if (StringUtils.isEmpty(modifier)) {
            throw new IllegalArgumentException("修改人为空");
        }
    }

    public String getCaseContent() {
        return caseContent;
    }

    public void setCaseContent(String caseContent) {
        this.caseContent = caseContent;
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

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
}
