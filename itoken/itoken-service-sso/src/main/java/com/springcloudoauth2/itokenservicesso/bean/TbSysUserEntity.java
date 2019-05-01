package com.springcloudoauth2.itokenservicesso.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_sys_user", schema = "itoken-service-admin", catalog = "")
public class TbSysUserEntity {
    private String userCode;
    private String loginCode;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private String phone;
    private String sex;
    private String avatar;
    private String sign;
    private String wxOpenid;
    private String mobileImei;
    private String userType;
    private String refCode;
    private String refName;
    private String mgrType;
    private BigInteger pwdSecurityLevel;
    private Timestamp pwdUpdateDate;
    private String pwdUpdateRecord;
    private String pwdQuestion;
    private String pwdQuestionAnswer;
    private String pwdQuestion2;
    private String pwdQuestionAnswer2;
    private String pwdQuestion3;
    private String pwdQuestionAnswer3;
    private Timestamp pwdQuestUpdateDate;
    private String lastLoginIp;
    private Timestamp lastLoginDate;
    private Timestamp freezeDate;
    private String freezeCause;
    private Integer userWeight;
    private String status;
    private String createBy;
    private Timestamp createDate;
    private String updateBy;
    private Timestamp updateDate;
    private String remarks;
    private String corpCode;
    private String corpName;
    private String extendS1;
    private String extendS2;
    private String extendS3;
    private String extendS4;
    private String extendS5;
    private String extendS6;
    private String extendS7;
    private String extendS8;
    private Integer extendI1;
    private Integer extendI2;
    private Integer extendI3;
    private Integer extendI4;
    private BigDecimal extendF1;
    private BigDecimal extendF2;
    private BigDecimal extendF3;
    private BigDecimal extendF4;
    private Timestamp extendD1;
    private Timestamp extendD2;
    private Timestamp extendD3;
    private Timestamp extendD4;

    @Id
    @Column(name = "user_code")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Basic
    @Column(name = "login_code")
    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "sign")
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Basic
    @Column(name = "wx_openid")
    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    @Basic
    @Column(name = "mobile_imei")
    public String getMobileImei() {
        return mobileImei;
    }

    public void setMobileImei(String mobileImei) {
        this.mobileImei = mobileImei;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "ref_code")
    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    @Basic
    @Column(name = "ref_name")
    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    @Basic
    @Column(name = "mgr_type")
    public String getMgrType() {
        return mgrType;
    }

    public void setMgrType(String mgrType) {
        this.mgrType = mgrType;
    }

    @Basic
    @Column(name = "pwd_security_level")
    public BigInteger getPwdSecurityLevel() {
        return pwdSecurityLevel;
    }

    public void setPwdSecurityLevel(BigInteger pwdSecurityLevel) {
        this.pwdSecurityLevel = pwdSecurityLevel;
    }

    @Basic
    @Column(name = "pwd_update_date")
    public Timestamp getPwdUpdateDate() {
        return pwdUpdateDate;
    }

    public void setPwdUpdateDate(Timestamp pwdUpdateDate) {
        this.pwdUpdateDate = pwdUpdateDate;
    }

    @Basic
    @Column(name = "pwd_update_record")
    public String getPwdUpdateRecord() {
        return pwdUpdateRecord;
    }

    public void setPwdUpdateRecord(String pwdUpdateRecord) {
        this.pwdUpdateRecord = pwdUpdateRecord;
    }

    @Basic
    @Column(name = "pwd_question")
    public String getPwdQuestion() {
        return pwdQuestion;
    }

    public void setPwdQuestion(String pwdQuestion) {
        this.pwdQuestion = pwdQuestion;
    }

    @Basic
    @Column(name = "pwd_question_answer")
    public String getPwdQuestionAnswer() {
        return pwdQuestionAnswer;
    }

    public void setPwdQuestionAnswer(String pwdQuestionAnswer) {
        this.pwdQuestionAnswer = pwdQuestionAnswer;
    }

    @Basic
    @Column(name = "pwd_question_2")
    public String getPwdQuestion2() {
        return pwdQuestion2;
    }

    public void setPwdQuestion2(String pwdQuestion2) {
        this.pwdQuestion2 = pwdQuestion2;
    }

    @Basic
    @Column(name = "pwd_question_answer_2")
    public String getPwdQuestionAnswer2() {
        return pwdQuestionAnswer2;
    }

    public void setPwdQuestionAnswer2(String pwdQuestionAnswer2) {
        this.pwdQuestionAnswer2 = pwdQuestionAnswer2;
    }

    @Basic
    @Column(name = "pwd_question_3")
    public String getPwdQuestion3() {
        return pwdQuestion3;
    }

    public void setPwdQuestion3(String pwdQuestion3) {
        this.pwdQuestion3 = pwdQuestion3;
    }

    @Basic
    @Column(name = "pwd_question_answer_3")
    public String getPwdQuestionAnswer3() {
        return pwdQuestionAnswer3;
    }

    public void setPwdQuestionAnswer3(String pwdQuestionAnswer3) {
        this.pwdQuestionAnswer3 = pwdQuestionAnswer3;
    }

    @Basic
    @Column(name = "pwd_quest_update_date")
    public Timestamp getPwdQuestUpdateDate() {
        return pwdQuestUpdateDate;
    }

    public void setPwdQuestUpdateDate(Timestamp pwdQuestUpdateDate) {
        this.pwdQuestUpdateDate = pwdQuestUpdateDate;
    }

    @Basic
    @Column(name = "last_login_ip")
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Basic
    @Column(name = "last_login_date")
    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Basic
    @Column(name = "freeze_date")
    public Timestamp getFreezeDate() {
        return freezeDate;
    }

    public void setFreezeDate(Timestamp freezeDate) {
        this.freezeDate = freezeDate;
    }

    @Basic
    @Column(name = "freeze_cause")
    public String getFreezeCause() {
        return freezeCause;
    }

    public void setFreezeCause(String freezeCause) {
        this.freezeCause = freezeCause;
    }

    @Basic
    @Column(name = "user_weight")
    public Integer getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Integer userWeight) {
        this.userWeight = userWeight;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "corp_code")
    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    @Basic
    @Column(name = "corp_name")
    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    @Basic
    @Column(name = "extend_s1")
    public String getExtendS1() {
        return extendS1;
    }

    public void setExtendS1(String extendS1) {
        this.extendS1 = extendS1;
    }

    @Basic
    @Column(name = "extend_s2")
    public String getExtendS2() {
        return extendS2;
    }

    public void setExtendS2(String extendS2) {
        this.extendS2 = extendS2;
    }

    @Basic
    @Column(name = "extend_s3")
    public String getExtendS3() {
        return extendS3;
    }

    public void setExtendS3(String extendS3) {
        this.extendS3 = extendS3;
    }

    @Basic
    @Column(name = "extend_s4")
    public String getExtendS4() {
        return extendS4;
    }

    public void setExtendS4(String extendS4) {
        this.extendS4 = extendS4;
    }

    @Basic
    @Column(name = "extend_s5")
    public String getExtendS5() {
        return extendS5;
    }

    public void setExtendS5(String extendS5) {
        this.extendS5 = extendS5;
    }

    @Basic
    @Column(name = "extend_s6")
    public String getExtendS6() {
        return extendS6;
    }

    public void setExtendS6(String extendS6) {
        this.extendS6 = extendS6;
    }

    @Basic
    @Column(name = "extend_s7")
    public String getExtendS7() {
        return extendS7;
    }

    public void setExtendS7(String extendS7) {
        this.extendS7 = extendS7;
    }

    @Basic
    @Column(name = "extend_s8")
    public String getExtendS8() {
        return extendS8;
    }

    public void setExtendS8(String extendS8) {
        this.extendS8 = extendS8;
    }

    @Basic
    @Column(name = "extend_i1")
    public Integer getExtendI1() {
        return extendI1;
    }

    public void setExtendI1(Integer extendI1) {
        this.extendI1 = extendI1;
    }

    @Basic
    @Column(name = "extend_i2")
    public Integer getExtendI2() {
        return extendI2;
    }

    public void setExtendI2(Integer extendI2) {
        this.extendI2 = extendI2;
    }

    @Basic
    @Column(name = "extend_i3")
    public Integer getExtendI3() {
        return extendI3;
    }

    public void setExtendI3(Integer extendI3) {
        this.extendI3 = extendI3;
    }

    @Basic
    @Column(name = "extend_i4")
    public Integer getExtendI4() {
        return extendI4;
    }

    public void setExtendI4(Integer extendI4) {
        this.extendI4 = extendI4;
    }

    @Basic
    @Column(name = "extend_f1")
    public BigDecimal getExtendF1() {
        return extendF1;
    }

    public void setExtendF1(BigDecimal extendF1) {
        this.extendF1 = extendF1;
    }

    @Basic
    @Column(name = "extend_f2")
    public BigDecimal getExtendF2() {
        return extendF2;
    }

    public void setExtendF2(BigDecimal extendF2) {
        this.extendF2 = extendF2;
    }

    @Basic
    @Column(name = "extend_f3")
    public BigDecimal getExtendF3() {
        return extendF3;
    }

    public void setExtendF3(BigDecimal extendF3) {
        this.extendF3 = extendF3;
    }

    @Basic
    @Column(name = "extend_f4")
    public BigDecimal getExtendF4() {
        return extendF4;
    }

    public void setExtendF4(BigDecimal extendF4) {
        this.extendF4 = extendF4;
    }

    @Basic
    @Column(name = "extend_d1")
    public Timestamp getExtendD1() {
        return extendD1;
    }

    public void setExtendD1(Timestamp extendD1) {
        this.extendD1 = extendD1;
    }

    @Basic
    @Column(name = "extend_d2")
    public Timestamp getExtendD2() {
        return extendD2;
    }

    public void setExtendD2(Timestamp extendD2) {
        this.extendD2 = extendD2;
    }

    @Basic
    @Column(name = "extend_d3")
    public Timestamp getExtendD3() {
        return extendD3;
    }

    public void setExtendD3(Timestamp extendD3) {
        this.extendD3 = extendD3;
    }

    @Basic
    @Column(name = "extend_d4")
    public Timestamp getExtendD4() {
        return extendD4;
    }

    public void setExtendD4(Timestamp extendD4) {
        this.extendD4 = extendD4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSysUserEntity that = (TbSysUserEntity) o;
        return Objects.equals(userCode, that.userCode) &&
                Objects.equals(loginCode, that.loginCode) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(sign, that.sign) &&
                Objects.equals(wxOpenid, that.wxOpenid) &&
                Objects.equals(mobileImei, that.mobileImei) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(refCode, that.refCode) &&
                Objects.equals(refName, that.refName) &&
                Objects.equals(mgrType, that.mgrType) &&
                Objects.equals(pwdSecurityLevel, that.pwdSecurityLevel) &&
                Objects.equals(pwdUpdateDate, that.pwdUpdateDate) &&
                Objects.equals(pwdUpdateRecord, that.pwdUpdateRecord) &&
                Objects.equals(pwdQuestion, that.pwdQuestion) &&
                Objects.equals(pwdQuestionAnswer, that.pwdQuestionAnswer) &&
                Objects.equals(pwdQuestion2, that.pwdQuestion2) &&
                Objects.equals(pwdQuestionAnswer2, that.pwdQuestionAnswer2) &&
                Objects.equals(pwdQuestion3, that.pwdQuestion3) &&
                Objects.equals(pwdQuestionAnswer3, that.pwdQuestionAnswer3) &&
                Objects.equals(pwdQuestUpdateDate, that.pwdQuestUpdateDate) &&
                Objects.equals(lastLoginIp, that.lastLoginIp) &&
                Objects.equals(lastLoginDate, that.lastLoginDate) &&
                Objects.equals(freezeDate, that.freezeDate) &&
                Objects.equals(freezeCause, that.freezeCause) &&
                Objects.equals(userWeight, that.userWeight) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(corpCode, that.corpCode) &&
                Objects.equals(corpName, that.corpName) &&
                Objects.equals(extendS1, that.extendS1) &&
                Objects.equals(extendS2, that.extendS2) &&
                Objects.equals(extendS3, that.extendS3) &&
                Objects.equals(extendS4, that.extendS4) &&
                Objects.equals(extendS5, that.extendS5) &&
                Objects.equals(extendS6, that.extendS6) &&
                Objects.equals(extendS7, that.extendS7) &&
                Objects.equals(extendS8, that.extendS8) &&
                Objects.equals(extendI1, that.extendI1) &&
                Objects.equals(extendI2, that.extendI2) &&
                Objects.equals(extendI3, that.extendI3) &&
                Objects.equals(extendI4, that.extendI4) &&
                Objects.equals(extendF1, that.extendF1) &&
                Objects.equals(extendF2, that.extendF2) &&
                Objects.equals(extendF3, that.extendF3) &&
                Objects.equals(extendF4, that.extendF4) &&
                Objects.equals(extendD1, that.extendD1) &&
                Objects.equals(extendD2, that.extendD2) &&
                Objects.equals(extendD3, that.extendD3) &&
                Objects.equals(extendD4, that.extendD4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userCode, loginCode, userName, password, email, mobile, phone, sex, avatar, sign, wxOpenid, mobileImei, userType, refCode, refName, mgrType, pwdSecurityLevel, pwdUpdateDate, pwdUpdateRecord, pwdQuestion, pwdQuestionAnswer, pwdQuestion2, pwdQuestionAnswer2, pwdQuestion3, pwdQuestionAnswer3, pwdQuestUpdateDate, lastLoginIp, lastLoginDate, freezeDate, freezeCause, userWeight, status, createBy, createDate, updateBy, updateDate, remarks, corpCode, corpName, extendS1, extendS2, extendS3, extendS4, extendS5, extendS6, extendS7, extendS8, extendI1, extendI2, extendI3, extendI4, extendF1, extendF2, extendF3, extendF4, extendD1, extendD2, extendD3, extendD4);
    }
}
