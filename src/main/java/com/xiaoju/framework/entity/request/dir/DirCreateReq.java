package com.xiaoju.framework.entity.request.dir;

import com.xiaoju.framework.entity.request.ParamValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 文件夹 新增
 *
 * @author 刘智
 * @date 2020/9/11
 */
@Data
@AllArgsConstructor
public class DirCreateReq implements ParamValidate {

    /**
     * 如果要给A文件夹添加同级，则取A的父级id 如果要给A文件夹添加子级，则取A的当前id
     */
    private String parentId;

    private Long productLineId;

    private String text;

    private Integer channel;

    @Override
    public void validate() {
        if (StringUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("请选择正确的节点进行创建");
        }
        if (productLineId == null || productLineId <= 0) {
            throw new IllegalArgumentException("业务线id为空或者非法");
        }
        if (StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException("文件夹名称不能为空");
        }
        if (channel == null) {
            throw new IllegalArgumentException("渠道为空");
        }
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
