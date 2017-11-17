package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopSpecGroup {
    private Long specGroupId;

    private String specGroupName;

    private Long cateId;
}