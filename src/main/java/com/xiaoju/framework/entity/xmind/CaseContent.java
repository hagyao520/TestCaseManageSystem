package com.xiaoju.framework.entity.xmind;

import lombok.Data;

/**
 * 用例实际在websocket中传递的内容
 *
 * @author 刘智
 * @date 2020/8/13
 */
@Data
public class CaseContent {

    private String template;

    private RootData root;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public RootData getRoot() {
        return root;
    }

    public void setRoot(RootData root) {
        this.root = root;
    }

}
