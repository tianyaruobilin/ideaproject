package com.springioupload.controller;

import com.springioupload.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * GET /从中查找当前上传文件的列表StorageService并将其加载到Thymeleaf模板中。它使用计算实际资源的链接MvcUriComponentsBuilder
 *
 * GET /files/{filename}加载资源（如果存在），并将其发送到浏览器以使用"Content-Disposition"响应头进行下载
 *
 * POST /适用于处理多部分消息file并将其提供给StorageService保存
 */
@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * 根据方法生成uri MvcUriComponentsBuilder.fromMethodName(controllerType ,method,args);
     *从中查找当前上传文件的列表StorageService并将其加载到Thymeleaf模板中。它使用计算实际资源的链接MvcUriComponentsBuilder
     * @param model
     * @return
     * @throws IOException
     */
    @GetMapping("/")
    public String listUploadFiles(Model model) throws IOException {
        model.addAttribute("files",storageService.loadAll()
                .map(path-> MvcUriComponentsBuilder
                        .fromMethodName(FileUploadController.class, "serverFile", path.getFileName().toString())
                        .build().toString()).collect(Collectors.toList()));
        return "uploadForm";
    }

    /**
     * ResponseEntity.ok()这个方法被调用，返回ok状态，有参时返回参数和ok状态
     * 该函数作用，将service层的文件获取后，向响应体中写入
     * @param filename
     * @return
     */
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serverFile(@PathVariable String filename){
        Resource file=storageService.loadAsResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+file.getFilename()+"\"")
                .body(file);
    }


    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message","you successfully uploaded"+file.getOriginalFilename()+"!");
        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)//用来文件没有找到处理异常
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc){
        return ResponseEntity.notFound().build();
    }


}
