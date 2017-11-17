package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopSpecItem;

public interface ShopSpecItemMapper {
    int insert(ShopSpecItem record);

    int insertSelective(ShopSpecItem record);
}