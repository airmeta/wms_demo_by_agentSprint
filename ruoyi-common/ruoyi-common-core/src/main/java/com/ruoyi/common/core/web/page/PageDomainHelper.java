package com.ruoyi.common.core.web.page;

import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.utils.ServletUtils;
import com.ruoyi.common.core.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Build a PageDomain from the current request.
 */
public final class PageDomainHelper {

    private PageDomainHelper() {}

    public static PageDomain build() {
        return build(ServletUtils.getRequest());
    }

    public static PageDomain build(HttpServletRequest request) {
        PageDomain pd = new PageDomain();
        if (request == null) {
            return pd;
        }
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        String orderByColumn = request.getParameter("orderByColumn");
        String isAsc = request.getParameter("isAsc");
        if (StringUtils.isNotEmpty(pageNum)) {
            pd.setPageNum(Integer.parseInt(pageNum));
        }
        if (StringUtils.isNotEmpty(pageSize)) {
            pd.setPageSize(Integer.parseInt(pageSize));
        }
        if (StringUtils.isNotEmpty(orderByColumn)) {
            pd.setOrderByColumn(orderByColumn);
        }
        if (StringUtils.isNotEmpty(isAsc)) {
            pd.setIsAsc(isAsc);
        }
        return pd;
    }
}
