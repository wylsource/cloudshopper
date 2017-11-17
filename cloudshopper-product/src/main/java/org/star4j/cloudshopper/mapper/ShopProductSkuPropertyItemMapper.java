package org.star4j.cloudshopper.mapper;

import org.star4j.cloudshopper.entity.ShopProductSkuPropertyItem;

public interface ShopProductSkuPropertyItemMapper {
    int insert(ShopProductSkuPropertyItem record);

    int insertSelective(ShopProductSkuPropertyItem record);
}