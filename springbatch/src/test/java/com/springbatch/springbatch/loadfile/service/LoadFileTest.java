package com.springbatch.springbatch.loadfile.service;

import com.springbatch.springbatch.SpringbatchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes =SpringbatchApplication.class)
@RunWith(SpringRunner.class)
public class LoadFileTest {

    @Autowired
    LoadFile loadFile;

    @Test
    public void loadFile() {
        loadFile.loadFile("E:\\aaa\\JI\\");
    }
}