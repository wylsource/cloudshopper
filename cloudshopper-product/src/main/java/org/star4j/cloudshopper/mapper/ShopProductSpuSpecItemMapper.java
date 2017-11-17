package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopProductSpuSpecItem;

public interface ShopProductSpuSpecItemMapper {
    int insert(ShopProductSpuSpecItem record);

    int insertSelective(ShopProductSpuSpecItem record);
}