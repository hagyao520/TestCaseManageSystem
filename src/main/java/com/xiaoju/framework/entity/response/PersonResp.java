package com.xiaoju.framework.entity.response;

import lombok.Data;

/**
 * 返回的人员
 *
 * @author 刘智
 * @date 2020/11/24
 */
@Data
public class PersonResp {

    /**
     * 前缀
     */
    private String staffNamePY;

    /**
     * 中文名
     */
    private String staffNameCN;

    public String getStaffNamePY() {
        return staffNamePY;
    }

    public void setStaffNamePY(String staffNamePY) {
        this.staffNamePY = staffNamePY;
    }

    public String getStaffNameCN() {
        return staffNameCN;
    }

    public void setStaffNameCN(String staffNameCN) {
        this.staffNameCN = staffNameCN;
    }
}
