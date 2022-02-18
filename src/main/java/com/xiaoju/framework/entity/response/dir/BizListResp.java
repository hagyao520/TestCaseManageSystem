package com.xiaoju.framework.entity.response.dir;

import lombok.Data;

/**
 * 返回给前端的所有文件夹的列表
 *
 * @author hcy
 * @date 2020/9/16
 */
@Data
public class BizListResp {

    private String bizId;

    private String text;

    private boolean select;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
