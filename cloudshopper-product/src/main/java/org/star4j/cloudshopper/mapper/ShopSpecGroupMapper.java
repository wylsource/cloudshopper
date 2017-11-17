package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopSpecGroup;

public interface ShopSpecGroupMapper {
    int insert(ShopSpecGroup record);

    int insertSelective(ShopSpecGroup record);
}