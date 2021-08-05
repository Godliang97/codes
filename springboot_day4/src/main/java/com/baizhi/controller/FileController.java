package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${file.upload.dir}")
    private String realPath;

    /**
     * 第二种文件上传方式
     * 注意：这种方式适用于任何一种部署方式 推荐使用这种方式
     */
    @RequestMapping("uploadByJarDeploy")
    public String uploadByJarDeploy(MultipartFile file) throws IOException {
        //文件名
        String originalFilename = file.getOriginalFilename();
        log.debug("文件名：{}", file.getOriginalFilename());
        log.debug("文件大小：{}", file.getSize());
        log.debug("文件类型：{}", file.getContentType());

        //改名
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ext;

        //上传文件到哪
        file.transferTo(new File(realPath, newFilename));

        return "redirect:/upload.jsp";
    }

    /**
     * 用来测试文件上传  - 这种方式：不能用于jar包部署
     * 注意：这种方式局限性，不推荐使用这种方式进行文件上传
     */
    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException { //定义：接收文件对象 multipartFile file变量名要与form中input type="file" 标签name属性名一致

        //文件名
        String originalFilename = file.getOriginalFilename();
        log.debug("文件名：{}", file.getOriginalFilename());
        log.debug("文件大小：{}", file.getSize());
        log.debug("文件类型：{}", file.getContentType());

        //1.根据相对  上传"upload" 获取绝对路径(真实路径)
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        log.debug("获取绝对路径：{}", realPath);

        //2.上传文件  参数1：将文件写入到那个目录 aa.txt .md xxx.xx.md
        //修改文件名
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ext;
        file.transferTo(new File(realPath, newFilename));

        return "redirect:/upload.jsp";
    }
}
