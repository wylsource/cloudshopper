package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProperty {
    private Long propertyId;

    private String propertyName;

    private Long cateId;

}