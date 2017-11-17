package org.star4j.cloudshopper.fallback.user;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.star4j.cloudshopper.api.user.ShopAdminClient;
import org.star4j.cloudshopper.entity.ShopAdmin;
import org.star4j.cloudshopper.enums.ResultState;
import org.star4j.cloudshopper.result.Result;
import org.star4j.cloudshopper.utils.ResultUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WuYL
 * @Description: 管理员使用 Hystrix 异常返回类
 * @Date: Create in 2017/10/30 16:36
 * @Modified By:
 */
@Component
public class ShopAdminHystrixClientFallbackFactory implements FallbackFactory<ShopAdminClient>{

    @Override
    public ShopAdminClient create(Throwable throwable) {
        return new ShopAdminClient() {
            @Override
            public Result selectShopAdminWithPage(Long id) {
                return ResultUtil.error(ResultState.RESULT_FALLBACKERROR.getCode(), throwable.getMessage());
            }
        };
    }
}
