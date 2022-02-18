package com.xiaoju.framework.entity.request.record;

import com.xiaoju.framework.entity.request.ParamValidate;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 任务 新增
 *
 * @author hcy
 * @date 2020/10/27
 */
@Data
public class RecordAddReq implements ParamValidate {

    private Long caseId;

    private String creator;

    private String title;

    private String chooseContent;

    private String description;

    private Long expectEndTime;

    private Long expectStartTime;

    private String owner;

    @Override
    public void validate() {
        if (caseId == null || caseId <= 0) {
            throw new IllegalArgumentException("用例id为空或者非法");
        }
        if (StringUtils.isEmpty(creator)) {
            throw new IllegalArgumentException("创建人为空");
        }
        if (StringUtils.isEmpty(title)) {
            throw new IllegalArgumentException("标题为空");
        }
        if (expectStartTime != null && expectEndTime == null || expectStartTime == null && expectEndTime != null) {
            throw new IllegalArgumentException("计划周期时间区域不完整");
        }
        if (StringUtils.isEmpty(chooseContent)) {
            throw new IllegalArgumentException("圈选用例为空");
        }
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChooseContent() {
        return chooseContent;
    }

    public void setChooseContent(String chooseContent) {
        this.chooseContent = chooseContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Long expectEndTime) {
        this.expectEndTime = expectEndTime;
    }

    public Long getExpectStartTime() {
        return expectStartTime;
    }

    public void setExpectStartTime(Long expectStartTime) {
        this.expectStartTime = expectStartTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
