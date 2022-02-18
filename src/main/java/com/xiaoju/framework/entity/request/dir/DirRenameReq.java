package com.xiaoju.framework.entity.request.dir;

import com.xiaoju.framework.entity.request.ParamValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

import static com.xiaoju.framework.constants.BizConstant.UNSORTED_BIZ_ID;

/**
 * 文件夹 重命名
 *
 * @author 刘智
 * @date 2020/9/11
 */
@Data
@AllArgsConstructor
public class DirRenameReq implements ParamValidate {

    private String id;

    private Long productLineId;

    private String text;

    private Integer channel;

    @Override
    public void validate() {
        if (UNSORTED_BIZ_ID.equals(id) || StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("请选择正确的节点进行重命名");
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
