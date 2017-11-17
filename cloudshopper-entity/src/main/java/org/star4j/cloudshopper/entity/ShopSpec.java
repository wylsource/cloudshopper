package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopSpec {
    private Long specId;

    private String specName;

    private Long specGroupId;

}