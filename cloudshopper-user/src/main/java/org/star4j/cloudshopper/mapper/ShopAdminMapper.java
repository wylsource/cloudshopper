package org.star4j.cloudshopper.mapper;


import com.github.pagehelper.Page;
import org.star4j.cloudshopper.entity.ShopAdmin;

public interface ShopAdminMapper {

    int insert(ShopAdmin record);

    int insertSelective(ShopAdmin record);

    Page<ShopAdmin> selectAllWithPage(ShopAdmin shopAdmin);
}