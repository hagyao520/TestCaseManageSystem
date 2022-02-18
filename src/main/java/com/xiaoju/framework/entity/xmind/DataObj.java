package com.xiaoju.framework.entity.xmind;

import lombok.Data;

/**
 * 任务的json单元
 *
 * @author 刘智
 * @date 2020/8/13
 */
@Data
public class DataObj {

    /**
     * 用例行为 阻塞、失败、成功、不执行
     */
    private Integer progress;

    /**
     * 用例标题
     */
    private String text;

    /**
     * 节点id
     */
    private String id;

    /**
     * 备注
     */
    private String note;

    /**
     * 超链接
     */
    private String hyperLink;

    /**
     * 超链接文本提示
     */
    private String hyperLinkTitle;

    public String getProgressStr() {
        return String.valueOf(progress);
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public void setHyperLink(String hyperLink) {
        this.hyperLink = hyperLink;
    }

    public String getHyperLinkTitle() {
        return hyperLinkTitle;
    }

    public void setHyperLinkTitle(String hyperLinkTitle) {
        this.hyperLinkTitle = hyperLinkTitle;
    }
}
