package com.xiaoju.framework.entity.request.record;

import com.xiaoju.framework.entity.request.ParamValidate;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 任务 编辑
 *
 * @author hcy
 * @date 2020/10/29
 */
@Data
public class RecordUpdateReq implements ParamValidate {

    private Long id;

    private String modifier;

    private String owner;

    private String title;

    private String chooseContent;

    private String description;

    private Long expectEndTime;

    private Long expectStartTime;

    @Override
    public void validate() {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("任务id为空或不正确");
        }
        if (StringUtils.isEmpty(modifier)) {
            throw new IllegalArgumentException("修改人为空");
        }
        if (StringUtils.isEmpty(title)) {
            throw new IllegalArgumentException("任务标题为空");
        }
        if (expectStartTime != null && expectEndTime == null || expectStartTime == null && expectEndTime != null) {
            throw new IllegalArgumentException("计划周期时间区域不完整");
        }
        if (StringUtils.isEmpty(chooseContent)) {
            throw new IllegalArgumentException("圈选用例为空");
        }
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
}
