/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.web;

import com.alipay.api.response.AlipayOpenMiniCloudFileDeleteResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileQueryResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileUploadResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFilelistQueryResponse;
import com.alipay.cloudrun.superapp.aop.annotation.ControllerPointCut;
import com.alipay.cloudrun.superapp.service.OssService;
import com.alipay.cloudrun.superapp.web.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author siwei
 * @version OssTestController.java, v 0.1 2023年04月04日 17:26 siwei
 */
@Log4j2
@RestController
@RequestMapping("/api/oss")
public class OssTestController {

    @Autowired
    OssService ossService;

    /**
     * 上传文件
     *
     * @param file 文件
     * @param path 上传路径
     * @return {@link Result}<{@link AlipayOpenMiniCloudFileUploadResponse}>
     *     v2 普通鉴权 utf-8格式加签
     */
    @PostMapping("/upload")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFileUploadResponse> uploadFile(@RequestParam("file") MultipartFile file,
                                                                    @RequestParam(name = "path", required = false) String path) throws IOException {
        log.info("/api/oss/upload POST request, fileName = {}, path = {}", file.getOriginalFilename(), path);
        if (path.trim().isEmpty()) {
            path = "/temp/";
        }
        String fileName = file.getOriginalFilename();
        //生成带时间戳的文件名 防止文件名重复时上传失败
        String randomFileName = System.currentTimeMillis() + "_"+ fileName;
        AlipayOpenMiniCloudFileUploadResponse response = ossService.uploadFile(file.getBytes(), randomFileName, path);
        return Result.success(response);

    }

    /**
     * Upload file three result.
     *
     * @param file the file
     * @param path the path
     * @return the result
     * @throws IOException the io exception
     * v3 普通鉴权
     */
    @PostMapping("/upload/v3")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFileUploadResponseModel> uploadFileThree(@RequestParam("file") MultipartFile file,
                                                                    @RequestParam(name = "path", required = false) String path) throws IOException {
        log.info("/api/oss/upload POST request, fileName = {}, path = {}", file.getOriginalFilename(), path);
        if (path.trim().isEmpty()) {
            path = "/temp/";
        }
        String fileName = file.getOriginalFilename();
        //生成带时间戳的文件名 防止文件名重复时上传失败
        String randomFileName = System.currentTimeMillis() + "_"+ fileName;
        AlipayOpenMiniCloudFileUploadResponseModel response = ossService.uploadFileThree(file.getBytes(), randomFileName, path);
        return Result.success(response);

    }

    /**
     * Upload file three no sing result.
     *
     * @param file the file
     * @param path the path
     * @return the result
     * @throws IOException the io exception
     * v3 免鉴权
     */
    @PostMapping("/upload/v3/nosing")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFileUploadResponseModel> uploadFileThreeNoSing(@RequestParam("file") MultipartFile file,
                                                                         @RequestParam(name = "path", required = false) String path) throws IOException {
        log.info("/api/oss/upload POST request, fileName = {}, path = {}", file.getOriginalFilename(), path);
        if (path.trim().isEmpty()) {
            path = "/temp/";
        }
        String fileName = file.getOriginalFilename();
        //生成带时间戳的文件名 防止文件名重复时上传失败
        String randomFileName = System.currentTimeMillis() + "_"+ fileName;
        AlipayOpenMiniCloudFileUploadResponseModel response = ossService.uploadFileThreeNoSing(file.getBytes(), randomFileName, path);
        return Result.success(response);

    }

    /**
     * Upload file no sing result.
     *
     * @param file the file
     * @param path the path
     * @return the result
     * @throws IOException the io exception
     * sdk v2 test 免鉴权
     */
    @PostMapping("/upload/nosing")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFileUploadResponse> uploadFileNoSing(@RequestParam("file") MultipartFile file,
                                                                    @RequestParam(name = "path", required = false) String path) throws IOException {
        log.info("/api/oss/upload POST request, fileName = {}, path = {}", file.getOriginalFilename(), path);
        if (path.trim().isEmpty()) {
            path = "/temp/";
        }
        String fileName = file.getOriginalFilename();
        //生成带时间戳的文件名 防止文件名重复时上传失败
        String randomFileName = System.currentTimeMillis() + "_"+ fileName;
        AlipayOpenMiniCloudFileUploadResponse response = ossService.uploadFileNoSing(file.getBytes(), randomFileName, path);
        return Result.success(response);

    }

    /**
     * Upload file gbk result.
     *
     * @param file the file
     * @param path the path
     * @return the result
     * @throws IOException the io exception
     *  v2调用 gbk格式加签
     */
    @PostMapping("/upload/gbk")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFileUploadResponse> uploadFileGbk(@RequestParam("file") MultipartFile file,
                                                                          @RequestParam(name = "path", required = false) String path) throws IOException {
        log.info("/api/oss/upload POST request, fileName = {}, path = {}", file.getOriginalFilename(), path);
        if (path.trim().isEmpty()) {
            path = "/temp/";
        }
        String fileName = file.getOriginalFilename();
        //生成带时间戳的文件名 防止文件名重复时上传失败
        String randomFileName = System.currentTimeMillis() + "_"+ fileName;
        AlipayOpenMiniCloudFileUploadResponse response = ossService.uploadFileGbk(file.getBytes(), randomFileName, path);
        return Result.success(response);

    }

    /**
     * 列举文件
     *
     * @param path    文件路径
     * @param nextToken 文件列表游标索引
     * @return {@link Result}<{@link AlipayOpenMiniCloudFilelistQueryResponse}>
     *     v2 普通鉴权 utf-8加签
     */
    @GetMapping("/list")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFilelistQueryResponse> queryFileList(@RequestParam(name = "path", required = false) String path,
                                                                          @RequestParam(name = "nextToken",required = false) String nextToken) {
        log.info("/api/oss/list GET request, path = {}, nextToken = {}", path, nextToken);
        if (path == null || path.trim().isEmpty()) {
            path = "/";
        }
        return Result.success(ossService.queryFileList(path, nextToken));
    }

    /**
     * Query file list three result.
     *
     * @param path      the path
     * @param nextToken the next token
     * @return the result
     * v3 普通鉴权
     */
    @GetMapping("/list/v3")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFilelistQueryResponse> queryFileListThree(@RequestParam(name = "path", required = false) String path,
                                                                          @RequestParam(name = "nextToken",required = false) String nextToken) {
        log.info("/api/oss/list GET request, path = {}, nextToken = {}", path, nextToken);
        if (path == null || path.trim().isEmpty()) {
            path = "/";
        }
        return Result.success(ossService.queryFileListThree(path, nextToken));
    }

    /**
     * Query file list three no sing result.
     *
     * @param path      the path
     * @param nextToken the next token
     * @return the result
     * v3 免鉴权
     */
    @GetMapping("/list/v3/nosing")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFilelistQueryResponse> queryFileListThreeNoSing(@RequestParam(name = "path", required = false) String path,
                                                                               @RequestParam(name = "nextToken",required = false) String nextToken) {
        log.info("/api/oss/list GET request, path = {}, nextToken = {}", path, nextToken);
        if (path == null || path.trim().isEmpty()) {
            path = "/";
        }
        return Result.success(ossService.queryFileListThreeNoSing(path, nextToken));
    }

    /**
     * Query file list no sing result.
     *
     * @param path      the path
     * @param nextToken the next token
     * @return the result
     * //v2 免鉴权
     */

    @GetMapping("/list/nosing")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFilelistQueryResponse> queryFileListNoSing(@RequestParam(name = "path", required = false) String path,
                                                                          @RequestParam(name = "nextToken",required = false) String nextToken) {
        log.info("/api/oss/list GET request, path = {}, nextToken = {}", path, nextToken);
        if (path == null || path.trim().isEmpty()) {
            path = "/";
        }
        return Result.success(ossService.queryFileListNoSing(path, nextToken));
    }

    /**
     * Query file list no sing gbk result.
     *
     * @param path      the path
     * @param nextToken the next token
     * @return the result
     * //v2 gbk 加签方式
     */

    @GetMapping("/list/gbk")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFilelistQueryResponse> queryFileListNoSingGbk(@RequestParam(name = "path", required = false) String path,
                                                                                @RequestParam(name = "nextToken",required = false) String nextToken) {
        log.info("/api/oss/list GET request, path = {}, nextToken = {}", path, nextToken);
        if (path == null || path.trim().isEmpty()) {
            path = "/";
        }
        return Result.success(ossService.queryFileListGbk(path, nextToken));
    }

    /**
     * 查询文件详细信息
     *
     * @param fileId 文件Id
     * @return {@link Result}<{@link AlipayOpenMiniCloudFileQueryResponse}>
     */
    @GetMapping("/get")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFileQueryResponse> queryFileInfo(@RequestParam("fileId") String fileId) {

        log.info("/api/oss/get GET request, fileId = {}", fileId);
        return Result.success(ossService.queryFileInfo(fileId));

    }

    /**
     * 删除文件
     *
     * @param path         文件路径
     * @param fileName     需要删除的文件，多个文件以英文逗号相隔
     * @return {@link Result}<{@link AlipayOpenMiniCloudFileDeleteResponse}>
     */
    @DeleteMapping("/delete")
    @ControllerPointCut
    public Result<AlipayOpenMiniCloudFileDeleteResponse> deleteFile(@RequestParam("path") String path, @RequestParam("fileName") String fileName) {

        log.info("/api/oss/delete DELETE request, path = {}, fileName = {}", path, fileName);
        List<String> fileNameList = Arrays.asList(fileName.split(","));
        return Result.success(ossService.deleteFile(path, fileNameList));

    }

}