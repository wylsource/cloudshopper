package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopProperty;

public interface ShopPropertyMapper {
    int insert(ShopProperty record);

    int insertSelective(ShopProperty record);
}