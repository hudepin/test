package com.deep.test.easyexcel;

import java.util.List;

/**
 * @author hudepin
 * @Description
 * @ClassName PermissionTreeResDTO
 * @create_date 2020.06.22 18:52
 * @since 1.2.0
 */
public class PermissionTreeResDTO {
    private Long id;

    private String name;

    private String href;

    private String permission;

    private String icon;

    private String ifShow;

    private Long sort;

    private String type;

    private Long parentId;

    private Integer depth;


    private String topLevel;
    private List<PermissionTreeResDTO> childs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIfShow() {
        return ifShow;
    }

    public void setIfShow(String ifShow) {
        this.ifShow = ifShow;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getTopLevel() {
        return topLevel;
    }

    public void setTopLevel(String topLevel) {
        this.topLevel = topLevel;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<PermissionTreeResDTO> getChilds() {
        return childs;
    }

    public void setChilds(List<PermissionTreeResDTO> childs) {
        this.childs = childs;
    }


}
