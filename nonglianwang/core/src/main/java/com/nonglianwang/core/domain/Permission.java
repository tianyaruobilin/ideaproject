package com.nonglianwang.core.domain;

import javax.persistence.*;

@Table(name = "tb_perms")
public class Permission {
    @Column(name = "perms_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permsId;

    @Column(name = "perms_name")
    private String permsName;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "resource_path")
    private String resourcePath;

    private Boolean available;

    /**
     * @return perms_id
     */
    public Integer getPermsId() {
        return permsId;
    }

    /**
     * @param permsId
     */
    public void setPermsId(Integer permsId) {
        this.permsId = permsId;
    }

    /**
     * @return perms_name
     */
    public String getPermsName() {
        return permsName;
    }

    /**
     * @param permsName
     */
    public void setPermsName(String permsName) {
        this.permsName = permsName == null ? null : permsName.trim();
    }

    /**
     * @return resource_type
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * @param resourceType
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    /**
     * @return resource_path
     */
    public String getResourcePath() {
        return resourcePath;
    }

    /**
     * @param resourcePath
     */
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath == null ? null : resourcePath.trim();
    }

    /**
     * @return available
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}