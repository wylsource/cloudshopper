package org.star4j.cloudshopper.service;

import com.github.pagehelper.Page;
import org.star4j.cloudshopper.entity.ShopAdmin;

/**
 * @Author: WuYL
 * @Description: 管理员业务接口
 * @Date: Create in 2017/10/28 22:01
 * @Modified By:
 */
public interface ShopAdminService {

    int addAdmin(ShopAdmin shopAdmin);

    Page<ShopAdmin> selectAllWithPage(ShopAdmin shopAdmin);
}
