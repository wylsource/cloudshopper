package org.star4j.cloudshopper.api.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.star4j.cloudshopper.entity.ShopAdmin;

import java.util.List;

/**
 * @Author: WuYL
 * @Description: 提供操作 ShopAdmin 的 api
 * @Date: Create in 2017/10/29 17:10
 * @Modified By:
 */
@FeignClient("cloudshopper-user")
public interface ShopAdminClient {

    /**
     * 分页查询管理员
     * @param id 管理员 ID
     * @return
     */
    @GetMapping("/user/shopadmin/selectWithPage/{id}")
    List<ShopAdmin> selectShopAdminWithPage(@PathVariable("id") Long id);
}
