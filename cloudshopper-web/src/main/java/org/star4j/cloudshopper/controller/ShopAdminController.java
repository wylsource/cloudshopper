package org.star4j.cloudshopper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.star4j.cloudshopper.entity.ShopAdmin;
import org.star4j.cloudshopper.service.ShopAdminService;

/**
 * @Author: WuYL
 * @Description: 管理员控制器
 * @Date: Create in 2017/10/28 22:03
 * @Modified By:
 */
@RestController
public class ShopAdminController {

    @Autowired
    private ShopAdminService shopAdminService;

    public ShopAdmin addAdmin(ShopAdmin shopAdmin){
        int i = shopAdminService.addAdmin(shopAdmin);
        return shopAdmin;
    }
}
