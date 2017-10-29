package org.star4j.cloudshopper.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.star4j.cloudshopper.entity.Entity.ShopAdmin;
import org.star4j.cloudshopper.mapper.ShopAdminMapper;
import org.star4j.cloudshopper.service.ShopAdminService;

/**
 * @Author: WuYL
 * @Description: 管理员业务实现
 * @Date: Create in 2017/10/28 22:02
 * @Modified By:
 */
@Service
public class ShopAdminServiceImpl implements ShopAdminService {

    @Autowired
    private ShopAdminMapper shopAdminMapper;

    public int addAdmin(ShopAdmin shopAdmin){
        return shopAdminMapper.insert(shopAdmin);
    }

    @Override
    public Page<ShopAdmin> selectAllWithPage(ShopAdmin shopAdmin) {
        return shopAdminMapper.selectAllWithPage(shopAdmin);
    }
}
