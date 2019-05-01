package com.hrjob.hr_job.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "undertake")
public class Undertake {
    /**
     * 本人承诺编号
     */
    @Id
    @Column(name = "undertake_id")
    private Integer undertakeId;

    /**
     * 资源且确保信息真实
     */
    @Column(name = "ack_truth")
    private Boolean ackTruth;

    /**
     * 如果不能按时毕业，建行有权不予接收
     */
    @Column(name = "can_graduate_in_time_interpretation")
    private Boolean canGraduateInTimeInterpretation;

    /**
     * 简历id
     */
    @Column(name = "person_consume_id")
    private String personConsumeId;

    /**
     * 获取本人承诺编号
     *
     * @return undertake_id - 本人承诺编号
     */
    public Integer getUndertakeId() {
        return undertakeId;
    }

    /**
     * 设置本人承诺编号
     *
     * @param undertakeId 本人承诺编号
     */
    public void setUndertakeId(Integer undertakeId) {
        this.undertakeId = undertakeId;
    }

    /**
     * 获取资源且确保信息真实
     *
     * @return ack_truth - 资源且确保信息真实
     */
    public Boolean getAckTruth() {
        return ackTruth;
    }

    /**
     * 设置资源且确保信息真实
     *
     * @param ackTruth 资源且确保信息真实
     */
    public void setAckTruth(Boolean ackTruth) {
        this.ackTruth = ackTruth;
    }

    /**
     * 获取如果不能按时毕业，建行有权不予接收
     *
     * @return can_graduate_in_time_interpretation - 如果不能按时毕业，建行有权不予接收
     */
    public Boolean getCanGraduateInTimeInterpretation() {
        return canGraduateInTimeInterpretation;
    }

    /**
     * 设置如果不能按时毕业，建行有权不予接收
     *
     * @param canGraduateInTimeInterpretation 如果不能按时毕业，建行有权不予接收
     */
    public void setCanGraduateInTimeInterpretation(Boolean canGraduateInTimeInterpretation) {
        this.canGraduateInTimeInterpretation = canGraduateInTimeInterpretation;
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