package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Value("${file.download.dir}")
    private String realPath;

    /**
     * 文件下载
     */
    @RequestMapping("download")
    public void download(String fileName, HttpServletResponse response) throws IOException {
        log.debug("当前下载文件名为：{}", fileName);
        log.debug("当前下载文件目录：{}", realPath);
        //1.去指定目录中读取文件
        File file = new File(realPath, fileName);
        //2.将文件读取为文件输入流
        FileInputStream is = new FileInputStream(file);
        //3获取响应流前 一定要设置以附件形式下载
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //4.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //5.输入流复制给输出流
        /*int len = 0;
        byte[] b = new byte[1024];
        while (true) {
            len = is.read(b);
            if (len == -1) break;
            os.write(b, 0, len);
        }*/

        FileCopyUtils.copy(is, os);

        //5.释放资源
        is.close();
    }
}
