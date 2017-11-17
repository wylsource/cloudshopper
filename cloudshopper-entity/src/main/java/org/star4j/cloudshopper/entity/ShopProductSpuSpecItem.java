package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductSpuSpecItem {
    private Long productSpuSpecItemId;

    private Long productSpuId;

    private Long specItemId;

    private Long specId;

    private Long specGroupId;

}