package com.manage.controller;

import cn.hutool.core.io.FileUtil;
import com.manage.common.Result;
import com.manage.exception.CustomException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project：springboot_vue
 * @since：2025/6/25 14:50
 * @author：wzx
 */
@RestController
@RequestMapping("/files")
public class FileController {
    // 文件上传的目录路径
    private static final String filePath = System.getProperty("user.dir") + "/files/";

    /**
     * 文件上传的方法
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) {
        // 文件流的形式接收前端发送过来的文件
        String originalFilename = file.getOriginalFilename();
        // 如果目录不存在，需要先创建目录
        if (!FileUtil.isDirectory(filePath)) {
            // 创建一个 files 目录
            FileUtil.mkdir(filePath);
        }
        // 提供文件存储的完整的路径，给文件名加一个唯一的标识
        String fileName = System.currentTimeMillis() + "_" + originalFilename;
        // 完整的文件路径
        String realPath = filePath + fileName;
        // 存储文件
        try {
            FileUtil.writeBytes(file.getBytes(),realPath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("500","文件上传失败！");
        }
        String url = "http://localhost:9090/files/download/" + fileName;
        return Result.success(url);
    }

    /**
     * 文件下载的方法
     * @param fileName
     * @param response
     */
    @GetMapping("/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse response) {
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
            response.setContentType("application/octet-stream");
            OutputStream os = response.getOutputStream();
            // 完整文件路径
            String realPath = filePath + fileName;
            // 读取文件
            byte[] bytes = FileUtil.readBytes(realPath);
            os.write(bytes);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("500", "文件下载失败！");
        }
    }

    @PostMapping("/wang/upload")
    public Map<String,Object> wangEditorUpload(MultipartFile file) {
        // 文件流的形式接收前端发送过来的文件
        String originalFilename = file.getOriginalFilename();
        // 如果目录不存在，需要先创建目录
        if (!FileUtil.isDirectory(filePath)) {
            // 创建一个 files 目录
            FileUtil.mkdir(filePath);
        }
        // 提供文件存储的完整的路径，给文件名加一个唯一的标识
        String fileName = System.currentTimeMillis() + "_" + originalFilename;
        // 完整的文件路径
        String realPath = filePath + fileName;
        // 存储文件
        try {
            FileUtil.writeBytes(file.getBytes(),realPath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException("500","文件上传失败！");
        }
        String url = "http://localhost:9090/files/download/" + fileName;
        // wangEditor 上床图片成功后，需要返回的参数
        Map<String, Object> resMap = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> urlMap = new HashMap<>();
        urlMap.put("url", url);
        list.add(urlMap);
        resMap.put("errno", 0);
        resMap.put("data", list);
        return resMap;
    }
}
