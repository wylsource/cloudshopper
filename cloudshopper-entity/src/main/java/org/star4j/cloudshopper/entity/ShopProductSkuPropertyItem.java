package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductSkuPropertyItem {
    private Long productSkuPropertyItemId;

    private Long propertyId;

    private Long propertyItemId;

    private Long productSkuId;

}