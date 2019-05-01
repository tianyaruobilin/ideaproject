package com.hrjob.hr_job.utils;

import com.hrjob.hr_job.HrJobApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

@SpringBootTest(classes = HrJobApplication.class)
@RunWith(SpringRunner.class)
public class Excel2HTMLTest {

    @Test
    public void test() throws FileNotFoundException {
        String s = Excel2HTML.readExcelToHtml(new FileInputStream(new File("C:\\Users\\vm510l\\Desktop\\HR  JOB\\建信金融标准简历\\蔡洁_应聘人员基本信息表95afba02.xls")), "C:\\Users\\vm510l\\Desktop\\xxx.html", true);
        System.out.println("s = " + s);
    }
}