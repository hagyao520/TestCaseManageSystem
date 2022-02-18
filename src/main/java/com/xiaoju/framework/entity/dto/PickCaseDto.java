package com.xiaoju.framework.entity.dto;

import com.xiaoju.framework.controller.CaseController;
import lombok.Data;

import java.util.List;

/**
 * 圈选用例所需要用到的结构体
 *
 * @author hcy
 * @date 2020/10/28
 * @see CaseController#getCountByCondition(java.lang.Long, java.lang.String[],
 *      java.lang.String[])
 */
@Data
public class PickCaseDto {

    /**
     * 优先级 ["0", "1", "2"....]
     */
    private List<String> priority;

    /**
     * 资源 ["用户自己", "在测试用例中", "定义的标签"]
     */
    private List<String> resource;

    public List<String> getPriority() {
        return priority;
    }

    public void setPriority(List<String> priority) {
        this.priority = priority;
    }

    public List<String> getResource() {
        return resource;
    }

    public void setResource(List<String> resource) {
        this.resource = resource;
    }
}
