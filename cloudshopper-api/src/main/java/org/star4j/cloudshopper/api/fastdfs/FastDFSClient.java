package org.star4j.cloudshopper.api.fastdfs;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.star4j.cloudshopper.fallback.FallBackWithAll;
import org.star4j.cloudshopper.fallback.fastdfs.FastDFSHystrixClientFallbackFactory;
import org.star4j.cloudshopper.result.Result;

/**
 * @Author: WuYL
 * @Description: 提供操作 FastDFS 的 Api
 * @Date: Create in 2017/11/16 18:40
 * @Modified By:
 */
@FeignClient(name = "cloudshopper-fastdfs", fallbackFactory = FastDFSHystrixClientFallbackFactory.class)
public interface FastDFSClient {

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    Result uploadFile(MultipartFile file);

    /**
     * 下载文件
     * @param fileId 要下载的文件 ID
     * @param downloadPath 下载的目的路径
     * @return
     */
    @GetMapping("/downloadFile/{fileId}/{downloadPath}")
    Result downloadFile(@PathVariable("fileId") String fileId, @PathVariable("downloadPath") String downloadPath);

    /**
     * 删除文件
     * @param fileId 要删除的文件 ID
     * @return
     */
    @DeleteMapping("/deleteFile/{fileId}")
    Result deleteFile(@PathVariable("fileId") String fileId);

    /**
     * 上传文件（同时生成缩略图）
     * @param file
     * @return
     */
    @PostMapping("/uploadImageAndCrtThumbImage")
    Result uploadImageAndCrtThumbImage(MultipartFile file);


}
