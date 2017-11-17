package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopPropertyItem;

public interface ShopPropertyItemMapper {
    int insert(ShopPropertyItem record);

    int insertSelective(ShopPropertyItem record);
}