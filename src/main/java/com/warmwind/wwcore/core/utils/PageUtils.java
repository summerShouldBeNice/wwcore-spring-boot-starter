package com.warmwind.wwcore.core.utils;

import com.github.pagehelper.PageHelper;
import com.warmwind.wwcore.core.domain.page.PageDomain;
import com.warmwind.wwcore.core.domain.page.TableSupport;
import com.warmwind.wwcore.core.sql.SqlUtils;

/**
 * @author warmwind
 * @createTime 2024-02-28 23:58
 */
public class PageUtils extends PageHelper {

    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = SqlUtils.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }
}
