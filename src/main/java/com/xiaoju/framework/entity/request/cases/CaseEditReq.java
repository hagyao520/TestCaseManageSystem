package com.xiaoju.framework.entity.request.cases;

import com.xiaoju.framework.constants.BizConstant;
import com.xiaoju.framework.constants.SystemConstant;
import com.xiaoju.framework.entity.request.ParamValidate;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * 用例 修改
 *
 * @author hcy
 * @date 2020/9/4
 */
@Data
public class CaseEditReq implements ParamValidate {

    /**
     * 必填 用例id
     */
    private Long id;

    /**
     * 必填 用例种类 默认给0
     */
    private Integer caseType;

    /**
     * 必填 用例标题
     */
    private String title;

    /**
     * 必填 修改人
     */
    private String modifier;

    /**
     * 必填 文件夹id列表 默认-1
     */
    private String bizId;

    /**
     * 必填 渠道 默认1
     */
    private Integer channel;

    /**
     * 非必填 需求id列表
     */
    private String requirementId;

    /**
     * 非必填 描述
     */
    private String description;

    @Override
    public void validate() {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("要修改的用例id为空或者非法");
        }
        if (StringUtils.isEmpty(modifier)) {
            throw new IllegalArgumentException("请传入修改人");
        }
        // oe需要关联文件夹
        if (StringUtils.isEmpty(bizId)) {
            throw new IllegalArgumentException("文件夹选择为空");
        } else {
            long count = Arrays.stream(bizId.split(SystemConstant.COMMA)).filter(BizConstant.ROOT_BIZ_ID::equals)
                    .count();
            if (count > 0) {
                throw new IllegalArgumentException("不可以在根文件夹下创建用例");
            }
        }
        if (StringUtils.isEmpty(title)) {
            throw new IllegalArgumentException("标题输入为空");
        }
        if (caseType == null) {
            throw new IllegalArgumentException("用例种类为空");
        }
        if (channel == null) {
            throw new IllegalArgumentException("渠道为空");
        }

        if (StringUtils.isEmpty(requirementId)) {
            requirementId = SystemConstant.EMPTY_STR;
        }
        if (description == null) {
            description = SystemConstant.EMPTY_STR;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
