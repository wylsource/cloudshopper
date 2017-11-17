package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopCategory {
    private Long cateId;

    private String categoryTitle;

    private Long parentId;

    private Date createTime;

}