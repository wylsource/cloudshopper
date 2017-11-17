package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopProductSku;

public interface ShopProductSkuMapper {
    int insert(ShopProductSku record);

    int insertSelective(ShopProductSku record);
}