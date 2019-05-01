package com.hrjob.hr_job.service.serviceimpl;

import com.hrjob.hr_job.dao.FollowCaseMapper;
import com.hrjob.hr_job.dao.IntentionMapper;
import com.hrjob.hr_job.dao.PersonconsumeMapper;
import com.hrjob.hr_job.dao.UndertakeMapper;
import com.hrjob.hr_job.entity.FollowCase;
import com.hrjob.hr_job.entity.Intention;
import com.hrjob.hr_job.entity.Personconsume;
import com.hrjob.hr_job.entity.Undertake;
import com.hrjob.hr_job.service.ResumeDealService;
import com.hrjob.hr_job.utils.Excel2HTML;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Transactional(readOnly = true)
@Service
public class ResumeDealServiceImpl implements ResumeDealService {

    @Autowired
    private PersonconsumeMapper personconsumeMapper;
    @Autowired
    private UndertakeMapper undertakeMapper;
    @Autowired
    private IntentionMapper intentionMapper;
    @Autowired
    private FollowCaseMapper followCaseMapper;

    @Value("${temp.output.html.path}")
    String outputDir;

    @Transactional(readOnly = false)
    @Override
    public boolean upload(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {
            /*String name = file.getOriginalFilename();
            assert name != null;
            //如果是以xls 和xlsx 结尾的文件，则可以通过，其它的扔掉
            InputStream inputStream = file.getResource().getInputStream();
            if (name.endsWith("xls")) {
                chongfuyewu(new HSSFWorkbook(inputStream));
            }
            if (name.endsWith("xlsx")) {
                chongfuyewu(new XSSFWorkbook(inputStream));
            }else{
                System.out.println("不支持的后缀名");
            }*/
            InputStream inputStream = file.getResource().getInputStream();
            String split = file.getOriginalFilename();
            String[] split1 = split.split("\\.");

            String outputHtml=outputDir.concat(split1[0]).concat(".html");
//            outputHtml = outputDir.concat(s);
            System.out.println(outputHtml);
            Excel2HTML.readExcelToHtml(inputStream, outputHtml, true);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = false)
    public void deal(Personconsume personConsume, List<Intention> intentions, FollowCase followingCase, Undertake underTake) {
        personconsumeMapper.insert(personConsume);
        for (int i = 0; i < intentions.size(); i++) {
            intentionMapper.insert(intentions.get(i));
        }
        followCaseMapper.insert(followingCase);
        undertakeMapper.insert(underTake);
    }

    private void chongfuyewu(Workbook workbook) throws IOException {
        List<? extends PictureData> allPictures = workbook.getAllPictures();//获取所有图片，但是简历中因该是只有一张才对啊
        PictureData pictureData = allPictures.get(0);//获取照片
        System.out.println("mime类型"+pictureData.getMimeType());
        System.out.println("图片类型为"+pictureData.getPictureType());
        byte[] data = pictureData.getData();

        int recycle=0;
            //2、获取Excel工作簿对象
            //3、得到Excel工作表对象
        Sheet sheetAt = workbook.getSheetAt(0);
        Personconsume personConsume=new Personconsume();
            FollowCase followingCase=new FollowCase();
            Undertake underTake=new Undertake();
            List<Intention> intentions=new LinkedList<>();
            personConsume.setPhoto(data);
            //4、循环读取表格数据
            for (Row row : sheetAt) {
                recycle =row.getRowNum();
                if (recycle>30) break;
                switch (recycle){
                    case 0:break;
                    case 1: //读取制表日期
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        String tempdata=row.getCell(5).getStringCellValue();
                        String tempdata1=row.getCell(6).getStringCellValue();
                        personConsume.setCreateDate(tempdata+tempdata1);
                        break;
                    case 2://读取姓名，性别，出生日期
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setName(row.getCell(1).getStringCellValue());
                        personConsume.setSex(row.getCell(3).getStringCellValue());
                        personConsume.setBorntime(String.valueOf(row.getCell(5).getStringCellValue()));
                        break;
                    case 3://读取生源地，名族，政治面貌
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setOriginOfStudent(row.getCell(1).getStringCellValue());
                        personConsume.setNation(row.getCell(3).getStringCellValue());
                        personConsume.setPoliticsStatus(row.getCell(5).getStringCellValue());
                        break;
                    case 4://读取婚姻状况，健康状况，身高
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setMaritalStatus(row.getCell(1).getStringCellValue());
                        personConsume.setHealthStatus(row.getCell(3).getStringCellValue());
                        personConsume.setHeight(row.getCell(5).getStringCellValue());
                        break;
                    case 5: //读取体重，证件号码，英语水平
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setWeight(row.getCell(1).getStringCellValue());
                        personConsume.setIdNumber(row.getCell(3).getStringCellValue());
                        personConsume.setEnglishLevel(row.getCell(5).getStringCellValue());
                        break;
                    case 6: //读取英语考试分数，其它外语，其它外语水平
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setEnglishTestScore(row.getCell(1).getStringCellValue());
                        personConsume.setOtherForeignLanguage(row.getCell(3).getStringCellValue());
                        personConsume.setOtherForengnLanguageProficiency(row.getCell(5).getStringCellValue());
                        break;
                    case 7: //读取毕业院校，家庭住址
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setGraduateSchool(row.getCell(1).getStringCellValue());
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 3; i < 7; i++) {
                            stringBuilder.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setHomeAdress(stringBuilder.toString());
                        break;
                    case 8://读取最高学位，最高学历，专业
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setHighestDegree(row.getCell(1).getStringCellValue());
                        personConsume.setOfficialAcademicCredentials(row.getCell(3).getStringCellValue());
                        String tempProfessional=row.getCell(5).getStringCellValue();
                        String tempProfessional1=row.getCell(6).getStringCellValue();
                        personConsume.setProfessional(tempProfessional+tempProfessional1);
                        break;
                    case 9://是否学生干部，学校联系电话，家庭联系电话
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setIsStudentCadres(row.getCell(1).getStringCellValue().trim().equals("是"));
                        personConsume.setSchoolContact(row.getCell(3).getStringCellValue());
                        String tempHomeContactAdress=row.getCell(5).getStringCellValue();
                        String tempHomeContactAdress1=row.getCell(6).getStringCellValue();
                        personConsume.setHomePhone(tempHomeContactAdress+tempHomeContactAdress1);
                        break;
                    case 10://读取移动电话，电子邮箱
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        personConsume.setMobilePhone(row.getCell(1).getStringCellValue());
                        StringBuilder stringBuilder1 = new StringBuilder();
                        for (int i = 3; i < 7; i++) {
                            stringBuilder1.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.seteMail(stringBuilder1.toString());
                        break;
                    case 11://特长及曾获何种奖励
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder2.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setSpecialSkillsAndAwards(stringBuilder2.toString());
                        break;
                    case 12://在校曾任何职
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder3 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder3.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setSchoolPosition(stringBuilder3.toString());
                        break;
                    case 13://培训情况
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder4.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setTrainingSituation(stringBuilder4.toString());
                        break;
                    case 14://本人适合从事何种工作
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder5 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder5.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setTheKindOfWorkSuitableForMe(stringBuilder5.toString());
                        break;
                    case 15://教育背景
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder6 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder6.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setEducationBackground(stringBuilder6.toString());
                        break;
                    case 16://家庭成员
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder7 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder7.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setMembersOfTheFamily(stringBuilder7.toString());
                        break;
                    case 17://其它在建行的亲属
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder8 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder8.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setOtherRelativesOfCcb(stringBuilder8.toString());
                        break;
                    case 18://工作经历
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder9 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder9.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setWorkExperience(stringBuilder9.toString());
                        break;
                    case 19://备注信息  //同时使用uuid作为主键
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        StringBuilder stringBuilder10 = new StringBuilder();
                        for (int i = 1; i < 7; i++) {
                            stringBuilder10.append(row.getCell(i).getStringCellValue());
                        }
                        personConsume.setNoteInformation(stringBuilder10.toString());
                        personConsume.setPersonConsumeId(UUID.randomUUID().toString().substring(0, 32));
                        break;
                    case 20://已经与其它单位签有工作合同或协议，或在其它单位工作且尚未办清离职手续
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        followingCase.setSignedOrUndeparture(row.getCell(6).getStringCellValue().equals("是"));
                        break;
                    case 21://是否被解雇、辞退、惩戒
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        followingCase.setFiredOrRetribution(row.getCell(6).getStringCellValue().equals("是"));
                        break;
                    case 22://有违法、违纪或其它不良行为
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        followingCase.setIllegalDisciplineBadrecord(row.getCell(6).getStringCellValue().equals("是"));
                        break;
                    case 23://是否有病  //设置简历id
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        followingCase.setIsDisease(row.getCell(6).getStringCellValue());
                        followingCase.setPersonConsumeId(personConsume.getPersonConsumeId());
                        break;
                    case 24://我自愿申请到中国建设银行工作，以上所填内容全部属实，如与事实不符导致最终未被录用，我将承担全部责任。
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        underTake.setAckTruth(row.getCell(6).getStringCellValue().equals("是"));
                        break;
                    case 25://在建设银行规定报到期限内，如未按时取得毕业证、学位证、就业报到证，建设银行有权不予接收。  //同时设置简历id
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        underTake.setCanGraduateInTimeInterpretation(row.getCell(6).getStringCellValue().equals("是"));
                        underTake.setPersonConsumeId(personConsume.getPersonConsumeId());
                        break;
                    case 26:
                        break;
                    case 27:    //创建意向 //同时设置简历id
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        if(!row.getCell(2).getStringCellValue().trim().isEmpty()
                                ||!row.getCell(3).getStringCellValue().trim().isEmpty()
                                ||!row.getCell(4).getStringCellValue().trim().isEmpty()){
                        Intention intention1=new Intention();
                        intention1.setIntentionName(row.getCell(2).getStringCellValue());
                        intention1.setJob(row.getCell(3).getStringCellValue());
                        intention1.setApplySerialNumber(row.getCell(4).getStringCellValue());
                        intention1.setResultsManagementBranch(row.getCell(5).getStringCellValue());
                        intention1.setWillingAdjust(row.getCell(6).getStringCellValue().equals("是"));
                        intention1.setPersonConsumeId(personConsume.getPersonConsumeId());
                        intentions.add(intention1);}
                        break;
                    case 28: //创建意向 //同时设置简历id
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        if(!row.getCell(2).getStringCellValue().trim().isEmpty()
                                ||!row.getCell(3).getStringCellValue().trim().isEmpty()
                                ||!row.getCell(4).getStringCellValue().trim().isEmpty()){
                        Intention intention2=new Intention();
                        intention2.setIntentionName(row.getCell(2).getStringCellValue());
                        intention2.setJob(row.getCell(3).getStringCellValue());
                        intention2.setApplySerialNumber(row.getCell(4).getStringCellValue());
                        intention2.setResultsManagementBranch(row.getCell(5).getStringCellValue());
                        intention2.setWillingAdjust(row.getCell(6).getStringCellValue().equals("是"));
                        intention2.setPersonConsumeId(personConsume.getPersonConsumeId());
                        intentions.add(intention2);}
                        break;
                    case 29: //创建意向 //同时设置简历id
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        if(!row.getCell(2).getStringCellValue().trim().isEmpty()
                                ||!row.getCell(3).getStringCellValue().trim().isEmpty()
                                ||!row.getCell(4).getStringCellValue().trim().isEmpty()){
                        Intention intention3=new Intention();
                        intention3.setIntentionName(row.getCell(2).getStringCellValue());
                        intention3.setJob(row.getCell(3).getStringCellValue());
                        intention3.setApplySerialNumber(row.getCell(4).getStringCellValue());
                        intention3.setResultsManagementBranch(row.getCell(5).getStringCellValue());
                        intention3.setWillingAdjust(row.getCell(6).getStringCellValue().equals("是"));
                        intention3.setPersonConsumeId(personConsume.getPersonConsumeId());
                        intentions.add(intention3);}
                        break;
                    case 30: //创建意向 //同时设置简历id
                        for(int j=0;j<7;j++){
                            row.getCell(j).setCellType(CellType.STRING);
                        }
                        if(!row.getCell(2).getStringCellValue().trim().isEmpty()
                                ||!row.getCell(3).getStringCellValue().trim().isEmpty()
                                ||!row.getCell(4).getStringCellValue().trim().isEmpty()){
                        Intention intention4=new Intention();
                        intention4.setIntentionName(row.getCell(2).getStringCellValue());
                        intention4.setJob(row.getCell(3).getStringCellValue());
                        intention4.setApplySerialNumber(row.getCell(4).getStringCellValue());
                        intention4.setResultsManagementBranch(row.getCell(5).getStringCellValue());
                        intention4.setWillingAdjust(row.getCell(6).getStringCellValue().equals("是"));
                        intention4.setPersonConsumeId(personConsume.getPersonConsumeId());
                        intentions.add(intention4);}
                        break;
                    default:break;
                }
            }
            //5、关闭流
            workbook.close();
            //向数据库写入数据
            deal(personConsume, intentions, followingCase, underTake);
        }

}
