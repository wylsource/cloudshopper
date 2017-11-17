package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopPropertyItem {
    private Long propertyItemId;

    private String propertyItemName;

    private Long propertyId;

}