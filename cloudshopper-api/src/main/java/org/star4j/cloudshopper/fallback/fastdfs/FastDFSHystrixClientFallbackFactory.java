package org.star4j.cloudshopper.fallback.fastdfs;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.star4j.cloudshopper.api.fastdfs.FastDFSClient;
import org.star4j.cloudshopper.enums.ResultState;
import org.star4j.cloudshopper.result.Result;
import org.star4j.cloudshopper.utils.ResultUtil;

/**
 * @Author: WuYL
 * @Description:
 * @Date: Create in 2017/11/16 18:42
 * @Modified By:
 */
@Component
public class FastDFSHystrixClientFallbackFactory implements FallbackFactory<FastDFSClient>{


    @Override
    public FastDFSClient create(Throwable throwable) {
        return new FastDFSClient() {
            @Override
            public Result uploadFile(MultipartFile file) {
                return ResultUtil.error(ResultState.RESULT_FALLBACKERROR.getCode(), throwable.getMessage());
            }

            @Override
            public Result downloadFile(String fileId, String downloadPath) {
                return ResultUtil.error(ResultState.RESULT_FALLBACKERROR.getCode(), throwable.getMessage());
            }

            @Override
            public Result deleteFile(String fileId) {
                return ResultUtil.error(ResultState.RESULT_FALLBACKERROR.getCode(), throwable.getMessage());
            }

            @Override
            public Result uploadImageAndCrtThumbImage(MultipartFile file) {
                return ResultUtil.error(ResultState.RESULT_FALLBACKERROR.getCode(), throwable.getMessage());
            }
        };
    }
}
