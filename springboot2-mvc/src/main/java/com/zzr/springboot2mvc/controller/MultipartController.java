package com.zzr.springboot2mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * MultipartFile 处理文件上传
 */
@Controller
public class MultipartController {

    /**
     * 单个
     * @param name
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public String handleFormUpload(String name, MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            //拿到输入流
            InputStream inputStream = file.getInputStream();
            //拿到一个字节数组
            byte[] bytes = file.getBytes();

            //想远程传输到目标文件系统
            file.transferTo(null);
            //要做的操作
            return "success";
        }
        return "failure";
    }

    @RequestMapping("/uploads")
    public String handleFormUploads(String name, MultipartFile[] file) throws IOException {

        for (MultipartFile multipartFile : file){
            if (!multipartFile.isEmpty()){
                String fileName = multipartFile.getOriginalFilename();
                InputStream inputStream = multipartFile.getInputStream();

                //要做的操作
            }
        }
        return "success";
    }

    /**
     * 是否允许附件上传
     * spring.servlet.multipart.enabled=true
     * 如果文件上传超过一定该设定的长度就写到临时文件里，避免浪费内存
     * spring.servlet.multipart.file-size-threshold=0
     * 临时文件路径
     * spring.servlet.multipart.location=
     * 单个文件最大容量
     * spring.servlet.multipart.max-file-size=1MB
     * 一次请求长度为10MB
     * spring.servlet.multipart.max-request-size=10MB
     *
     * spring.servlet.multipart.resolve-lazily=false
     */
}
