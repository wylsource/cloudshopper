package org.star4j.cloudshopper.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.star4j.cloudshopper.entity.ShopAdmin;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WuYL
 * @Description: 访问首页的控制器
 * @Date: Create in 2017/10/27 22:37
 * @Modified By:
 */
@RestController
public class MainController {

    @RequestMapping("/main/{id}")
    public List<ShopAdmin> main(@PathVariable("id") Integer id){
        ShopAdmin shopAdmin = new ShopAdmin();
        shopAdmin.setAdminId(id);
        shopAdmin.setAdminName("张三");
        shopAdmin.setAdminPass("wuyulong");
        shopAdmin.setAdminEmail("qqq@qq.com");
        List<ShopAdmin> shopAdmins = new ArrayList<>();
        for (int i = 0; i< 4; i++){
            shopAdmins.add(shopAdmin);
        }
        return shopAdmins;
    }
}
