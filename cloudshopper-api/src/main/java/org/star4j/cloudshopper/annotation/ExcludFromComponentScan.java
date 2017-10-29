package org.star4j.cloudshopper.annotation;

/**
 * @Author: WuYL
 * @Description: 配置负载均衡的类不能放到启动的 APP 类包下，否则会覆盖其上下文，
 *               导致所有的微服务负载都会设置为当前配置。
 *               该注解实现去除此问题
 * @Date: Create in 2017/10/29 17:26
 * @Modified By:
 */
public @interface ExcludFromComponentScan {
}
