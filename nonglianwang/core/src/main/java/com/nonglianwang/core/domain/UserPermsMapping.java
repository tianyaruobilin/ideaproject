package com.nonglianwang.core.domain;

import javax.persistence.*;

@Table(name = "user_perms_mapping")
public class UserPermsMapping {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "perms_id")
    private Integer permsId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
}