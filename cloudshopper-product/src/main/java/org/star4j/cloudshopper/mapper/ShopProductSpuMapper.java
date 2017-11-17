package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopProductSpu;

public interface ShopProductSpuMapper {
    int insert(ShopProductSpu record);

    int insertSelective(ShopProductSpu record);
}