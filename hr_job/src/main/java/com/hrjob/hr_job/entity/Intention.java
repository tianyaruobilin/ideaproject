package com.hrjob.hr_job.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "intention")
public class Intention {
    /**
     * 志愿id
     */
    @Id
    @Column(name = "intention_id")
    private Integer intentionId;

    /**
     * 志愿名
     */
    @Column(name = "intention_name")
    private String intentionName;

    /**
     * 志愿工作
     */
    private String job;

    /**
     * 报名系列号
     */
    @Column(name = "apply_serial_number")
    private String applySerialNumber;

    /**
     * 成绩管理分行
     */
    @Column(name = "results_management_branch")
    private String resultsManagementBranch;

    /**
     * 是否服从调剂
     */
    @Column(name = "willing_adjust")
    private Boolean willingAdjust;

    /**
     * 简历id
     */
    @Column(name = "person_consume_id")
    private String personConsumeId;

    /**
     * 获取志愿id
     *
     * @return intention_id - 志愿id
     */
    public Integer getIntentionId() {
        return intentionId;
    }

    /**
     * 设置志愿id
     *
     * @param intentionId 志愿id
     */
    public void setIntentionId(Integer intentionId) {
        this.intentionId = intentionId;
    }

    /**
     * 获取志愿名
     *
     * @return intention_name - 志愿名
     */
    public String getIntentionName() {
        return intentionName;
    }

    /**
     * 设置志愿名
     *
     * @param intentionName 志愿名
     */
    public void setIntentionName(String intentionName) {
        this.intentionName = intentionName;
    }

    /**
     * 获取志愿工作
     *
     * @return job - 志愿工作
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置志愿工作
     *
     * @param job 志愿工作
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取报名系列号
     *
     * @return apply_serial_number - 报名系列号
     */
    public String getApplySerialNumber() {
        return applySerialNumber;
    }

    /**
     * 设置报名系列号
     *
     * @param applySerialNumber 报名系列号
     */
    public void setApplySerialNumber(String applySerialNumber) {
        this.applySerialNumber = applySerialNumber;
    }

    /**
     * 获取成绩管理分行
     *
     * @return results_management_branch - 成绩管理分行
     */
    public String getResultsManagementBranch() {
        return resultsManagementBranch;
    }

    /**
     * 设置成绩管理分行
     *
     * @param resultsManagementBranch 成绩管理分行
     */
    public void setResultsManagementBranch(String resultsManagementBranch) {
        this.resultsManagementBranch = resultsManagementBranch;
    }

    /**
     * 获取是否服从调剂
     *
     * @return willing_adjust - 是否服从调剂
     */
    public Boolean getWillingAdjust() {
        return willingAdjust;
    }

    /**
     * 设置是否服从调剂
     *
     * @param willingAdjust 是否服从调剂
     */
    public void setWillingAdjust(Boolean willingAdjust) {
        this.willingAdjust = willingAdjust;
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
}