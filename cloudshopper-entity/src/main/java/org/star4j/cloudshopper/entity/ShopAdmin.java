package org.star4j.cloudshopper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: WuYL
 * @Description: 商城管理员
 * @Date: Create in 2017/10/28 11:43
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopAdmin implements Serializable{

    private Long adminId; //主键 ID

    private String adminName; //管理员账号(唯一)

    private String adminPass; //管理员密码

    private String adminEmail; //管理员电子邮箱(唯一)

    private Date loginTime; //登录时间

    private String loginIp; //登录 IP

    private Date createTime; //创建时间

}
