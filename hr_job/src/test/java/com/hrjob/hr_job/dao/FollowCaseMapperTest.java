package com.hrjob.hr_job.dao;

import com.hrjob.hr_job.HrJobApplication;
import com.hrjob.hr_job.entity.FollowCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(classes = HrJobApplication.class)
@RunWith(SpringRunner.class)
public class FollowCaseMapperTest {

    @Autowired
    private FollowCaseMapper followCaseMapper;

    @Test
    public void test(){
        List<FollowCase> followCases = followCaseMapper.selectAll();
        for (FollowCase followCase : followCases) {
            System.out.println(followCase);
        }
    }

}