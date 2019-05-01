package com.hrjob.hr_job.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "follow_case")
public class FollowCase {
    /**
     * 是否具有一下情况表主键
     */
    @Id
    @Column(name = "follow_case_id")
    private Integer followCaseId;

    /**
     * 是否已经签订劳动合同或者未离职
     */
    @Column(name = "signed_or_undeparture")
    private Boolean signedOrUndeparture;

    /**
     * 是否被解雇、辞退、惩戒
     */
    @Column(name = "fired_or_retribution")
    private Boolean firedOrRetribution;

    /**
     * 犯法、违纪、其它不良行为记录
     */
    @Column(name = "illegal_discipline_badRecord")
    private Boolean illegalDisciplineBadrecord;

    /**
     * 简历id
     */
    @Column(name = "person_consume_id")
    private String personConsumeId;

    /**
     *  是否有病
     */
    @Column(name = "is_disease")
    private String isDisease;

    /**
     * 获取是否具有一下情况表主键
     *
     * @return follow_case_id - 是否具有一下情况表主键
     */
    public Integer getFollowCaseId() {
        return followCaseId;
    }

    /**
     * 设置是否具有一下情况表主键
     *
     * @param followCaseId 是否具有一下情况表主键
     */
    public void setFollowCaseId(Integer followCaseId) {
        this.followCaseId = followCaseId;
    }

    /**
     * 获取是否已经签订劳动合同或者未离职
     *
     * @return signed_or_undeparture - 是否已经签订劳动合同或者未离职
     */
    public Boolean getSignedOrUndeparture() {
        return signedOrUndeparture;
    }

    /**
     * 设置是否已经签订劳动合同或者未离职
     *
     * @param signedOrUndeparture 是否已经签订劳动合同或者未离职
     */
    public void setSignedOrUndeparture(Boolean signedOrUndeparture) {
        this.signedOrUndeparture = signedOrUndeparture;
    }

    /**
     * 获取是否被解雇、辞退、惩戒
     *
     * @return fired_or_retribution - 是否被解雇、辞退、惩戒
     */
    public Boolean getFiredOrRetribution() {
        return firedOrRetribution;
    }

    /**
     * 设置是否被解雇、辞退、惩戒
     *
     * @param firedOrRetribution 是否被解雇、辞退、惩戒
     */
    public void setFiredOrRetribution(Boolean firedOrRetribution) {
        this.firedOrRetribution = firedOrRetribution;
    }

    /**
     * 获取犯法、违纪、其它不良行为记录
     *
     * @return illegal_discipline_badRecord - 犯法、违纪、其它不良行为记录
     */
    public Boolean getIllegalDisciplineBadrecord() {
        return illegalDisciplineBadrecord;
    }

    /**
     * 设置犯法、违纪、其它不良行为记录
     *
     * @param illegalDisciplineBadrecord 犯法、违纪、其它不良行为记录
     */
    public void setIllegalDisciplineBadrecord(Boolean illegalDisciplineBadrecord) {
        this.illegalDisciplineBadrecord = illegalDisciplineBadrecord;
    }

    /**
     * 获取简历id
     *
     * @return person_consume_id - 简历id
     */
    public String getPersonConsumeId() {
        return personConsumeId;
    }

    /**
     * 设置简历id
     *
     * @param personConsumeId 简历id
     */
    public void setPersonConsumeId(String personConsumeId) {
        this.personConsumeId = personConsumeId;
    }

    /**
     * 获取 是否有病
     *
     * @return is_disease -  是否有病
     */
    public String getIsDisease() {
        return isDisease;
    }

    /**
     * 设置 是否有病
     *
     * @param isDisease  是否有病
     */
    public void setIsDisease(String isDisease) {
        this.isDisease = isDisease;
    }
}