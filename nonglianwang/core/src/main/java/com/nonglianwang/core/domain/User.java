package com.nonglianwang.core.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Table(name = "tb_user")
public class User {
    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_nick")
    @Length(min = 3,max = 10,message = "昵称必须在3-10个字符串长度之间")
    private String userNick;

    @Column(name = "user_code")
    private String userCode;

    @Length(min = 3,max = 10,message = "密码在3-10个字符串长度之间")
    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Pattern(regexp = "^[150[0-9]+]{11}", message = "输入正确的手机号码")
    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_created_time")
    private Date userCreatedTime;

    @Column(name = "user_updated_time")
    private Date userUpdatedTime;

    @Column(name = "user_last_login_time")
    private Date userLastLoginTime;

    @Column(name = "user_status")
    private String userStatus;

    @Column(name = "user_others_status_comment")
    private String userOthersStatusComment;

    @Column(name = "user_other_extends")
    private String userOtherExtends;

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
     * @return user_nick
     */
    public String getUserNick() {
        return userNick;
    }

    /**
     * @param userNick
     */
    public void setUserNick(String userNick) {
        this.userNick = userNick == null ? null : userNick.trim();
    }

    /**
     * @return user_code
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * @param userCode
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
     * @return user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * @return user_created_time
     */
    public Date getUserCreatedTime() {
        return userCreatedTime;
    }

    /**
     * @param userCreatedTime
     */
    public void setUserCreatedTime(Date userCreatedTime) {
        this.userCreatedTime = userCreatedTime;
    }

    /**
     * @return user_updated_time
     */
    public Date getUserUpdatedTime() {
        return userUpdatedTime;
    }

    /**
     * @param userUpdatedTime
     */
    public void setUserUpdatedTime(Date userUpdatedTime) {
        this.userUpdatedTime = userUpdatedTime;
    }

    /**
     * @return user_last_login_time
     */
    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    /**
     * @param userLastLoginTime
     */
    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    /**
     * @return user_status
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    /**
     * @return user_others_status_comment
     */
    public String getUserOthersStatusComment() {
        return userOthersStatusComment;
    }

    /**
     * @param userOthersStatusComment
     */
    public void setUserOthersStatusComment(String userOthersStatusComment) {
        this.userOthersStatusComment = userOthersStatusComment == null ? null : userOthersStatusComment.trim();
    }

    /**
     * @return user_other_extends
     */
    public String getUserOtherExtends() {
        return userOtherExtends;
    }

    /**
     * @param userOtherExtends
     */
    public void setUserOtherExtends(String userOtherExtends) {
        this.userOtherExtends = userOtherExtends == null ? null : userOtherExtends.trim();
    }
}