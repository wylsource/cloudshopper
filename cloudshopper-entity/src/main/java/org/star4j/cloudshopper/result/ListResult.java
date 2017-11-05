package org.star4j.cloudshopper.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: WuYL
 * @Description: 集合结果集
 * @Date: Create in 2017/11/5 21:30
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListResult<T> implements Result{
    private Integer code;   //状态码
    private String msg;     //返回信息
    private T result;       //返回具体数据
    private Integer count;  //返回数据数量
}
