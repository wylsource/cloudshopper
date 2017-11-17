package org.star4j.cloudshopper.mapper;


import org.star4j.cloudshopper.entity.ShopCategory;

public interface ShopCategoryMapper {
    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);
}