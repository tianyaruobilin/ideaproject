package com.hrjob.hr_job.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "personconsume")
public class Personconsume {
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 照片
     */
    private byte[] photo;

    /**
     * 出生日期
     */
    private String borntime;

    /**
     * 生源地
     */
    @Column(name = "origin_of_student")
    private String originOfStudent;

    /**
     * 名族
     */
    private String nation;

    /**
     * 政治面貌
     */
    @Column(name = "politics_status")
    private String politicsStatus;

    /**
     * 婚姻状况
     */
    @Column(name = "marital_status")
    private String maritalStatus;

    /**
     * 健康状况
     */
    @Column(name = "health_status")
    private String healthStatus;

    /**
     * 身高
     */
    private String height;

    /**
     * 体重
     */
    private String weight;

    /**
     * 证件号码
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 英语水平
     */
    @Column(name = "english_level")
    private String englishLevel;

    /**
     * 英语考试分数
     */
    @Column(name = "english_test_score")
    private String englishTestScore;

    /**
     * 其它外语
     */
    @Column(name = "other_foreign_language")
    private String otherForeignLanguage;

    /**
     * 其它外语水平
     */
    @Column(name = "other_forengn_language_proficiency")
    private String otherForengnLanguageProficiency;

    /**
     * 毕业院校
     */
    @Column(name = "graduate_school")
    private String graduateSchool;

    /**
     * 家庭住址
     */
    @Column(name = "home_adress")
    private String homeAdress;

    /**
     * 最高学位
     */
    @Column(name = "highest_degree")
    private String highestDegree;

    /**
     * 最高学历
     */
    @Column(name = "official_academic_credentials")
    private String officialAcademicCredentials;

    /**
     * 专业
     */
    private String professional;

    /**
     * 是否学生干部
     */
    @Column(name = "is_student_cadres")
    private Boolean isStudentCadres;

    /**
     * 学校联系方式
     */
    @Column(name = "school_contact")
    private String schoolContact;

    /**
     * 家庭联系方式
     */
    @Column(name = "home_phone")
    private String homePhone;

    /**
     * 移动电话
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 电子邮箱
     */
    @Column(name = "e_mail")
    private String eMail;

    /**
     * 特长及曾获何种奖励
     */
    @Column(name = "special_skills_and_awards")
    private String specialSkillsAndAwards;

    /**
     * 在校职位
     */
    @Column(name = "school_position")
    private String schoolPosition;

    /**
     * 培训情况
     */
    @Column(name = "training_situation")
    private String trainingSituation;

    /**
     * 本人适合从事何种工作
     */
    @Column(name = "the_kind_of_work_suitable_for_me")
    private String theKindOfWorkSuitableForMe;

    /**
     * 教育背景
     */
    @Column(name = "education_background")
    private String educationBackground;

    /**
     * 家庭成员
     */
    @Column(name = "members_of_the_family")
    private String membersOfTheFamily;

    /**
     * 其它在建行的亲属
     */
    @Column(name = "other_relatives_of_CCB")
    private String otherRelativesOfCcb;

    /**
     * 工作经历
     */
    @Column(name = "work_experience")
    private String workExperience;

    /**
     * 备注信息
     */
    @Column(name = "note_information")
    private String noteInformation;

    /**
     * 结果判断（可删除，不可删除，是否有用)
     */
    @Column(name = "result_determine")
    private String resultDetermine;

    /**
     * 可扩展字段1
     */
    private String extension1;

    /**
     * 可扩展字段2
     */
    private String extension2;

    /**
     * 可扩展字段3
     */
    private String extension3;

    /**
     *  简历创建日期
     */
    @Column(name = "` create_date`")
    private String createDate;

    /**
     * 简历编号
     */
    @Column(name = "person_consume_id")
    private String personConsumeId;

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取照片
     *
     * @return photo - 照片
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * 设置照片
     *
     * @param photo 照片
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    /**
     * 获取出生日期
     *
     * @return borntime - 出生日期
     */
    public String getBorntime() {
        return borntime;
    }

    /**
     * 设置出生日期
     *
     * @param borntime 出生日期
     */
    public void setBorntime(String borntime) {
        this.borntime = borntime;
    }

    /**
     * 获取生源地
     *
     * @return origin_of_student - 生源地
     */
    public String getOriginOfStudent() {
        return originOfStudent;
    }

    /**
     * 设置生源地
     *
     * @param originOfStudent 生源地
     */
    public void setOriginOfStudent(String originOfStudent) {
        this.originOfStudent = originOfStudent;
    }

    /**
     * 获取名族
     *
     * @return nation - 名族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置名族
     *
     * @param nation 名族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取政治面貌
     *
     * @return politics_status - 政治面貌
     */
    public String getPoliticsStatus() {
        return politicsStatus;
    }

    /**
     * 设置政治面貌
     *
     * @param politicsStatus 政治面貌
     */
    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    /**
     * 获取婚姻状况
     *
     * @return marital_status - 婚姻状况
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 设置婚姻状况
     *
     * @param maritalStatus 婚姻状况
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * 获取健康状况
     *
     * @return health_status - 健康状况
     */
    public String getHealthStatus() {
        return healthStatus;
    }

    /**
     * 设置健康状况
     *
     * @param healthStatus 健康状况
     */
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    /**
     * 获取身高
     *
     * @return height - 身高
     */
    public String getHeight() {
        return height;
    }

    /**
     * 设置身高
     *
     * @param height 身高
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 获取体重
     *
     * @return weight - 体重
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 设置体重
     *
     * @param weight 体重
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * 获取证件号码
     *
     * @return id_number - 证件号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置证件号码
     *
     * @param idNumber 证件号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 获取英语水平
     *
     * @return english_level - 英语水平
     */
    public String getEnglishLevel() {
        return englishLevel;
    }

    /**
     * 设置英语水平
     *
     * @param englishLevel 英语水平
     */
    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    /**
     * 获取英语考试分数
     *
     * @return english_test_score - 英语考试分数
     */
    public String getEnglishTestScore() {
        return englishTestScore;
    }

    /**
     * 设置英语考试分数
     *
     * @param englishTestScore 英语考试分数
     */
    public void setEnglishTestScore(String englishTestScore) {
        this.englishTestScore = englishTestScore;
    }

    /**
     * 获取其它外语
     *
     * @return other_foreign_language - 其它外语
     */
    public String getOtherForeignLanguage() {
        return otherForeignLanguage;
    }

    /**
     * 设置其它外语
     *
     * @param otherForeignLanguage 其它外语
     */
    public void setOtherForeignLanguage(String otherForeignLanguage) {
        this.otherForeignLanguage = otherForeignLanguage;
    }

    /**
     * 获取其它外语水平
     *
     * @return other_forengn_language_proficiency - 其它外语水平
     */
    public String getOtherForengnLanguageProficiency() {
        return otherForengnLanguageProficiency;
    }

    /**
     * 设置其它外语水平
     *
     * @param otherForengnLanguageProficiency 其它外语水平
     */
    public void setOtherForengnLanguageProficiency(String otherForengnLanguageProficiency) {
        this.otherForengnLanguageProficiency = otherForengnLanguageProficiency;
    }

    /**
     * 获取毕业院校
     *
     * @return graduate_school - 毕业院校
     */
    public String getGraduateSchool() {
        return graduateSchool;
    }

    /**
     * 设置毕业院校
     *
     * @param graduateSchool 毕业院校
     */
    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    /**
     * 获取家庭住址
     *
     * @return home_adress - 家庭住址
     */
    public String getHomeAdress() {
        return homeAdress;
    }

    /**
     * 设置家庭住址
     *
     * @param homeAdress 家庭住址
     */
    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }

    /**
     * 获取最高学位
     *
     * @return highest_degree - 最高学位
     */
    public String getHighestDegree() {
        return highestDegree;
    }

    /**
     * 设置最高学位
     *
     * @param highestDegree 最高学位
     */
    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    /**
     * 获取最高学历
     *
     * @return official_academic_credentials - 最高学历
     */
    public String getOfficialAcademicCredentials() {
        return officialAcademicCredentials;
    }

    /**
     * 设置最高学历
     *
     * @param officialAcademicCredentials 最高学历
     */
    public void setOfficialAcademicCredentials(String officialAcademicCredentials) {
        this.officialAcademicCredentials = officialAcademicCredentials;
    }

    /**
     * 获取专业
     *
     * @return professional - 专业
     */
    public String getProfessional() {
        return professional;
    }

    /**
     * 设置专业
     *
     * @param professional 专业
     */
    public void setProfessional(String professional) {
        this.professional = professional;
    }

    /**
     * 获取是否学生干部
     *
     * @return is_student_cadres - 是否学生干部
     */
    public Boolean getIsStudentCadres() {
        return isStudentCadres;
    }

    /**
     * 设置是否学生干部
     *
     * @param isStudentCadres 是否学生干部
     */
    public void setIsStudentCadres(Boolean isStudentCadres) {
        this.isStudentCadres = isStudentCadres;
    }

    /**
     * 获取学校联系方式
     *
     * @return school_contact - 学校联系方式
     */
    public String getSchoolContact() {
        return schoolContact;
    }

    /**
     * 设置学校联系方式
     *
     * @param schoolContact 学校联系方式
     */
    public void setSchoolContact(String schoolContact) {
        this.schoolContact = schoolContact;
    }

    /**
     * 获取家庭联系方式
     *
     * @return home_phone - 家庭联系方式
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * 设置家庭联系方式
     *
     * @param homePhone 家庭联系方式
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * 获取移动电话
     *
     * @return mobile_phone - 移动电话
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置移动电话
     *
     * @param mobilePhone 移动电话
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取电子邮箱
     *
     * @return e_mail - 电子邮箱
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * 设置电子邮箱
     *
     * @param eMail 电子邮箱
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * 获取特长及曾获何种奖励
     *
     * @return special_skills_and_awards - 特长及曾获何种奖励
     */
    public String getSpecialSkillsAndAwards() {
        return specialSkillsAndAwards;
    }

    /**
     * 设置特长及曾获何种奖励
     *
     * @param specialSkillsAndAwards 特长及曾获何种奖励
     */
    public void setSpecialSkillsAndAwards(String specialSkillsAndAwards) {
        this.specialSkillsAndAwards = specialSkillsAndAwards;
    }

    /**
     * 获取在校职位
     *
     * @return school_position - 在校职位
     */
    public String getSchoolPosition() {
        return schoolPosition;
    }

    /**
     * 设置在校职位
     *
     * @param schoolPosition 在校职位
     */
    public void setSchoolPosition(String schoolPosition) {
        this.schoolPosition = schoolPosition;
    }

    /**
     * 获取培训情况
     *
     * @return training_situation - 培训情况
     */
    public String getTrainingSituation() {
        return trainingSituation;
    }

    /**
     * 设置培训情况
     *
     * @param trainingSituation 培训情况
     */
    public void setTrainingSituation(String trainingSituation) {
        this.trainingSituation = trainingSituation;
    }

    /**
     * 获取本人适合从事何种工作
     *
     * @return the_kind_of_work_suitable_for_me - 本人适合从事何种工作
     */
    public String getTheKindOfWorkSuitableForMe() {
        return theKindOfWorkSuitableForMe;
    }

    /**
     * 设置本人适合从事何种工作
     *
     * @param theKindOfWorkSuitableForMe 本人适合从事何种工作
     */
    public void setTheKindOfWorkSuitableForMe(String theKindOfWorkSuitableForMe) {
        this.theKindOfWorkSuitableForMe = theKindOfWorkSuitableForMe;
    }

    /**
     * 获取教育背景
     *
     * @return education_background - 教育背景
     */
    public String getEducationBackground() {
        return educationBackground;
    }

    /**
     * 设置教育背景
     *
     * @param educationBackground 教育背景
     */
    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    /**
     * 获取家庭成员
     *
     * @return members_of_the_family - 家庭成员
     */
    public String getMembersOfTheFamily() {
        return membersOfTheFamily;
    }

    /**
     * 设置家庭成员
     *
     * @param membersOfTheFamily 家庭成员
     */
    public void setMembersOfTheFamily(String membersOfTheFamily) {
        this.membersOfTheFamily = membersOfTheFamily;
    }

    /**
     * 获取其它在建行的亲属
     *
     * @return other_relatives_of_CCB - 其它在建行的亲属
     */
    public String getOtherRelativesOfCcb() {
        return otherRelativesOfCcb;
    }

    /**
     * 设置其它在建行的亲属
     *
     * @param otherRelativesOfCcb 其它在建行的亲属
     */
    public void setOtherRelativesOfCcb(String otherRelativesOfCcb) {
        this.otherRelativesOfCcb = otherRelativesOfCcb;
    }

    /**
     * 获取工作经历
     *
     * @return work_experience - 工作经历
     */
    public String getWorkExperience() {
        return workExperience;
    }

    /**
     * 设置工作经历
     *
     * @param workExperience 工作经历
     */
    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    /**
     * 获取备注信息
     *
     * @return note_information - 备注信息
     */
    public String getNoteInformation() {
        return noteInformation;
    }

    /**
     * 设置备注信息
     *
     * @param noteInformation 备注信息
     */
    public void setNoteInformation(String noteInformation) {
        this.noteInformation = noteInformation;
    }

    /**
     * 获取结果判断（可删除，不可删除，是否有用)
     *
     * @return result_determine - 结果判断（可删除，不可删除，是否有用)
     */
    public String getResultDetermine() {
        return resultDetermine;
    }

    /**
     * 设置结果判断（可删除，不可删除，是否有用)
     *
     * @param resultDetermine 结果判断（可删除，不可删除，是否有用)
     */
    public void setResultDetermine(String resultDetermine) {
        this.resultDetermine = resultDetermine;
    }

    /**
     * 获取可扩展字段1
     *
     * @return extension1 - 可扩展字段1
     */
    public String getExtension1() {
        return extension1;
    }

    /**
     * 设置可扩展字段1
     *
     * @param extension1 可扩展字段1
     */
    public void setExtension1(String extension1) {
        this.extension1 = extension1;
    }

    /**
     * 获取可扩展字段2
     *
     * @return extension2 - 可扩展字段2
     */
    public String getExtension2() {
        return extension2;
    }

    /**
     * 设置可扩展字段2
     *
     * @param extension2 可扩展字段2
     */
    public void setExtension2(String extension2) {
        this.extension2 = extension2;
    }

    /**
     * 获取可扩展字段3
     *
     * @return extension3 - 可扩展字段3
     */
    public String getExtension3() {
        return extension3;
    }

    /**
     * 设置可扩展字段3
     *
     * @param extension3 可扩展字段3
     */
    public void setExtension3(String extension3) {
        this.extension3 = extension3;
    }

    /**
     * 获取 简历创建日期
     *
     * @return  create_date -  简历创建日期
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 设置 简历创建日期
     *
     * @param createDate  简历创建日期
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取简历编号
     *
     * @return person_consume_id - 简历编号
     */
    public String getPersonConsumeId() {
        return personConsumeId;
    }

    /**
     * 设置简历编号
     *
     * @param personConsumeId 简历编号
     */
    public void setPersonConsumeId(String personConsumeId) {
        this.personConsumeId = personConsumeId;
    }
}