package com.xiaoju.framework.entity.xmind;

import lombok.Data;

import java.util.List;

/**
 * 用例的json单元
 *
 * @author hcy
 * @date 2020/8/13
 */
@Data
public class RootData {

    private DataObj data;

    private List<RootData> children;

    public DataObj getData() {
        return data;
    }

    public void setData(DataObj data) {
        this.data = data;
    }

    public List<RootData> getChildren() {
        return children;
    }

    public void setChildren(List<RootData> children) {
        this.children = children;
    }

}
