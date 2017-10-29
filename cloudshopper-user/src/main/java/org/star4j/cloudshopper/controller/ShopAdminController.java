package org.star4j.cloudshopper.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.star4j.cloudshopper.entity.ShopAdmin;
import org.star4j.cloudshopper.service.ShopAdminService;

import java.util.List;

/**
 * @Author: WuYL
 * @Description: 管理员控制器
 * @Date: Create in 2017/10/28 22:03
 * @Modified By:
 */
@RestController
@RequestMapping("/user/shopadmin")
public class ShopAdminController {

    @Autowired
    private ShopAdminService shopAdminService;

    @PostMapping("/add")
    public ShopAdmin addAdmin(ShopAdmin shopAdmin){
        int i = shopAdminService.addAdmin(shopAdmin);
        return shopAdmin;
    }

    @GetMapping("/selectWithPage/{id}")
    public List<ShopAdmin> selectShopAdminWithPage(@PathVariable("id") Long id){
        System.out.println("---------id: "+id);
        ShopAdmin shopAdmin = new ShopAdmin();
        PageHelper.startPage(1, 6);
        Page<ShopAdmin> shopAdmins = shopAdminService.selectAllWithPage(shopAdmin);
        return shopAdmins.getResult();
    }
}
