package org.star4j.cloudshopper.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: WuYL
 * @Description: 分页实体
 * @Date: Create in 2017/11/17 11:34
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean <T>{

    // 当前页
    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 10;
    // 总条数
    private Integer totalNum;
    // 是否有下一页
    private Boolean isMore;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> items;
}
