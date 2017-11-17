package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductSku {
    private Long productSkuId;

    private Long productSpuId;

    private Long supplierId;

    private Integer storeNum;

    private BigDecimal productSkuPrice;

    private Date createTime;

    private String productSkuPics;

}