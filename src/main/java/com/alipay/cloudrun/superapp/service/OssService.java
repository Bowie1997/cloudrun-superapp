/*
 * Ant Group
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.alipay.cloudrun.superapp.service;

import com.alipay.api.response.AlipayOpenMiniCloudFileDeleteResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileQueryResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFileUploadResponse;
import com.alipay.api.response.AlipayOpenMiniCloudFilelistQueryResponse;

import java.util.List;

/**
 * @author siwei
 * @version OssService.java, v 0.1 2023年04月04日 17:51 siwei
 */
public interface OssService {

    /**
     * 上传文件
     *
     * @param localFile 本地文件
     * @param fileName  OSS文件名称
     * @param filePath  OSS文件路径
     * @return {@link AlipayOpenMiniCloudFileUploadResponse}
     */
    AlipayOpenMiniCloudFileUploadResponse uploadFile(String localFile, String fileName, String filePath);

    /**
     * 上传文件
     *
     * @param bytes    文件字节码
     * @param fileName OSS文件名称
     * @param filePath OSS文件名称
     * @return {@link AlipayOpenMiniCloudFileUploadResponse}
     */
    AlipayOpenMiniCloudFileUploadResponse uploadFile(byte[] bytes, String fileName, String filePath);

    AlipayOpenMiniCloudFileUploadResponseModel uploadFileThree(byte[] bytes, String fileName, String filePath);

    AlipayOpenMiniCloudFileUploadResponseModel uploadFileThreeNoSing(byte[] bytes, String fileName, String filePath);

    /**
     * 上传文件
     *
     * @param bytes    文件字节码
     * @param fileName OSS文件名称
     * @param filePath OSS文件名称
     * @return {@link AlipayOpenMiniCloudFileUploadResponse}
     */
    AlipayOpenMiniCloudFileUploadResponse uploadFileNoSing(byte[] bytes, String fileName, String filePath);

    /**
     * Upload file gbk alipay open mini cloud file upload response.
     *
     * @param bytes    the bytes
     * @param fileName the file name
     * @param filePath the file path
     * @return the alipay open mini cloud file upload response
     */
    AlipayOpenMiniCloudFileUploadResponse uploadFileGbk(byte[] bytes, String fileName, String filePath);

    /**
     * 列举文件
     *
     * @param path      文件路径
     * @param nextToken 下一个令牌
     * @return {@link AlipayOpenMiniCloudFilelistQueryResponse}
     */
    AlipayOpenMiniCloudFilelistQueryResponse queryFileList(String path, String nextToken);

    AlipayOpenMiniCloudFilelistQueryResponseModel queryFileListThree(String path, String nextToken);

    AlipayOpenMiniCloudFilelistQueryResponseModel queryFileListThreeNoSing(String path, String nextToken);

    /**
     * Query file list gbk alipay open mini cloud filelist query response.
     *
     * @param path      the path
     * @param nextToken the next token
     * @return the alipay open mini cloud filelist query response
     */
    AlipayOpenMiniCloudFilelistQueryResponse queryFileListGbk(String path, String nextToken);

    /**
     * 列举文件
     *
     * @param path      文件路径
     * @param nextToken 下一个令牌
     * @return {@link AlipayOpenMiniCloudFilelistQueryResponse}
     */
    AlipayOpenMiniCloudFilelistQueryResponse queryFileListNoSing(String path, String nextToken);

    /**
     * 查询文件详细信息
     *
     * @param fileId 文件Id
     * @return {@link AlipayOpenMiniCloudFileQueryResponse}
     */
    AlipayOpenMiniCloudFileQueryResponse queryFileInfo(String fileId);

    /**
     * 删除文件
     *
     * @param path         文件路径
     * @param fileNameList 文件名称列表
     * @return {@link AlipayOpenMiniCloudFileDeleteResponse}
     */
    AlipayOpenMiniCloudFileDeleteResponse deleteFile(String path, List<String> fileNameList);

}