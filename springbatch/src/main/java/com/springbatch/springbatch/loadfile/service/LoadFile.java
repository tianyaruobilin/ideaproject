package com.springbatch.springbatch.loadfile.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class LoadFile {

    public void loadFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            //是个文件夹
            File[] files = file.listFiles();
            for (File file1 : files) {

            }
        }
    }
}
