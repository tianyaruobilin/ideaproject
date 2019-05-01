package com.hrjob.hr_job.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ResumeDealService {

    boolean upload(List<MultipartFile> files) throws IOException;   //是否上传成功
}
