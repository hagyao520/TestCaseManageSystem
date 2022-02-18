package com.xiaoju.framework.entity.persistent;

import lombok.Data;

import java.util.Date;

/**
 * 文件夹
 *
 * 一个业务线有一条自己的文件夹数据，这里采用json去存储
 *
 * @author 刘智
 * @date 2020/09/09
 */
@Data
public class Biz {

    /**
     * id
     */
    private Long id;

    /**
     * 业务线id
     */
    private Long productLineId;

    /**
     * channel 当前默认1
     */
    private Integer channel;

    private Integer isDelete;

    private Date gmtModified;

    private Date gmtCreated;

    /**
     * 存储的内容
     */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
