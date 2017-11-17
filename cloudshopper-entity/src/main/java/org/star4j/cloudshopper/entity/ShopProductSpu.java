package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopProductSpu {
    private Long productSpuId;

    private Long cateId;

    private String productSpuTitle;

    private BigDecimal productSpuPrice;

    private String productSpuCover;

    private String isSale;

    private String isHot;

    private String isPush;

    private BigDecimal salePrice;

    private String isOn;

    private Date createTime;
}