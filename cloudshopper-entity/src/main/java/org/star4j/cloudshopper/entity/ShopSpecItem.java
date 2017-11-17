package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopSpecItem {
    private Long specItemId;

    private String specItemName;

    private Long specId;
}