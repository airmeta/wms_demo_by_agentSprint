package com.ruoyi.common.core.page;

import com.ruoyi.common.core.utils.StringUtils;

import java.io.Serializable;

/**
 * Pagination request parameters.
 */
public class PageDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageNum;
    private Integer pageSize;
    private String orderByColumn;
    private String isAsc;

    public Integer getPageNum() { return pageNum; }
    public void setPageNum(Integer pageNum) { this.pageNum = pageNum; }
    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
    public String getOrderByColumn() { return orderByColumn; }
    public void setOrderByColumn(String orderByColumn) { this.orderByColumn = orderByColumn; }
    public String getIsAsc() { return isAsc; }
    public void setIsAsc(String isAsc) { this.isAsc = isAsc; }

    public String getOrderBy() {
        if (StringUtils.isEmpty(orderByColumn)) {
            return "";
        }
        return StringUtils.toUnderScoreCase(orderByColumn) + " " + (StringUtils.isNotEmpty(isAsc) && "asc".equalsIgnoreCase(isAsc) ? "ASC" : "DESC");
    }
}
