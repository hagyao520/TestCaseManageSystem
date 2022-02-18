package com.xiaoju.framework.entity.dto;

import com.xiaoju.framework.service.impl.RecordServiceImpl;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 文件夹节点转换体
 *
 * @author 刘智
 * @date 2020/10/28
 * @see RecordServiceImpl#getData(com.xiaoju.framework.entity.dto.MergeCaseDto)
 */
@Data
public class DirNodeDto {

    private String id;
    private String text;
    private String parentId;
    private Set<String> caseIds = new HashSet<>();

    private List<DirNodeDto> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Set<String> getCaseIds() {
        return caseIds;
    }

    public void setCaseIds(Set<String> caseIds) {
        this.caseIds = caseIds;
    }

    public List<DirNodeDto> getChildren() {
        return children;
    }

    public void setChildren(List<DirNodeDto> children) {
        this.children = children;
    }
}
