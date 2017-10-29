package org.star4j.cloudshopper.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.star4j.cloudshopper.entity.Entity.ShopAdmin;

/**
 * @Author: WuYL
 * @Description: 测试管理员业务
 * @Date: Create in 2017/10/28 22:12
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopAdminServiceTest {

    @Autowired
    private ShopAdminService shopAdminService;

    @Test
    public void addAdmin() throws Exception {
        ShopAdmin shopAdmin = new ShopAdmin();
//        shopAdmin.setAdminId(2L);
        shopAdmin.setAdminName("张三");
        shopAdmin.setAdminPass("password123");
        shopAdmin.setAdminEmail("wyl@qq.com");
        shopAdmin.setLoginIp("192.168.1.1");
        for (int i = 0; i < 16; i++) {
            int j = shopAdminService.addAdmin(shopAdmin);
            Assert.assertEquals(j, 1);
        }
    }

    @Test
    public void selectAllWithPage() throws Exception {
        ShopAdmin shopAdmin = new ShopAdmin();
//        shopAdmin.setAdminId(2);
        PageHelper.startPage(2,6);
        Page<ShopAdmin> shopAdmins = shopAdminService.selectAllWithPage(shopAdmin);
        System.out.println("----------size: "+shopAdmins.getResult().size());
//        Assert.assertEquals(shopAdmins.size(), 1);
    }

}