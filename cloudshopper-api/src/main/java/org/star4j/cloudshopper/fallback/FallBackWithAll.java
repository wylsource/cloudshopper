package org.star4j.cloudshopper.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.star4j.cloudshopper.enums.ResultState;
import org.star4j.cloudshopper.result.Result;
import org.star4j.cloudshopper.utils.ResultUtil;

/**
 * @Author: WuYL
 * @Description:
 * @Date: Create in 2017/11/17 10:18
 * @Modified By:
 */
@Component
public class FallBackWithAll implements FallbackFactory<Result> {

    @Override
    public Result create(Throwable throwable) {
        return ResultUtil.error(ResultState.RESULT_FALLBACKERROR.getCode(), throwable.getMessage());
    }
}
