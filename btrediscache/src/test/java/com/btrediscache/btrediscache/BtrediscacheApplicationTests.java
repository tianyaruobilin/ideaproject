package com.btrediscache.btrediscache;

import com.btrediscache.btrediscache.test.ValueRedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BtrediscacheApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private ValueRedisDao valueRedisDao;

    @Test
    public void test() throws Exception {
        this.valueRedisDao.save("LiangGzone");
        System.out.println(this.valueRedisDao.getParam());
    }

}
