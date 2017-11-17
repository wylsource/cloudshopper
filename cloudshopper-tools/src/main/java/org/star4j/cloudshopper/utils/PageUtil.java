package org.star4j.cloudshopper.utils;

import com.github.pagehelper.Page;
import org.star4j.cloudshopper.vo.PageBean;

import java.util.List;

/**
 * @Author: WuYL
 * @Description: 分页工具类
 * @Date: Create in 2017/11/17 11:37
 * @Modified By:
 */
public class PageUtil {

    public static <T> PageBean<T> toPageBean(List<T> items, Integer totalNum, Integer pageSize, Integer currentPage, Integer startIndex) {

        Integer totalPage =  (totalNum % pageSize) == 0 ? (totalNum / pageSize) : (totalNum / pageSize) + 1;
        Boolean isMore =  (totalPage - currentPage) > 0 ? true : false;
        return new PageBean(currentPage, pageSize, totalNum, isMore, totalPage, 0, items);
    }


    public static <T> PageBean<T> PageToPageBean(Page<T> page) {
        return toPageBean(page.getResult(), new Long(page.getTotal()).intValue(), page.getPageSize(), page.getPageNum(), page.getStartRow());
    }
}
