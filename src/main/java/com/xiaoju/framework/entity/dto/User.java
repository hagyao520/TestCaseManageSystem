package com.xiaoju.framework.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by 刘智 on 2021/4/22.
 */
@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private String salt;

    private String authorityName;

    private Integer isDelete;

    private Integer channel;

    private Long productLineId;

    private Date gmtCreated;

    private Date gmtUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    /**
     * 获取用户的三要素字符串
     * 
     * @param user
     * @return
     */
    public static String buildUserKey(User user) {
        StringBuilder builder = new StringBuilder();
        builder.append(user.getUsername()).append(",").append(user.getChannel()).append(",")
                .append(user.getProductLineId());
        return builder.toString();
    }
}
