package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopSpec;

public interface ShopSpecMapper {
    int insert(ShopSpec record);

    int insertSelective(ShopSpec record);
}