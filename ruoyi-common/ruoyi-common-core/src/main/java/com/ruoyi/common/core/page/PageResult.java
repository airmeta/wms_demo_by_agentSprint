package com.ruoyi.common.core.page;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Paged result payload.
 */
@Schema(description = "Paged result wrapper")
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Total record count")
    private long total;

    @Schema(description = "Records on the current page")
    private List<T> rows;

    @Schema(description = "Current page number")
    private long pageNum;

    @Schema(description = "Page size")
    private long pageSize;

    public PageResult() {
        this.rows = Collections.emptyList();
    }

    public PageResult(List<T> rows, long total) {
        this.rows = rows == null ? Collections.emptyList() : rows;
        this.total = total;
    }

    public PageResult(long pageNum, long pageSize, long total, List<T> rows) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.rows = rows == null ? Collections.emptyList() : rows;
    }

    public long getTotal() { return total; }
    public void setTotal(long total) { this.total = total; }
    public List<T> getRows() { return rows; }
    public void setRows(List<T> rows) { this.rows = rows; }
    public long getPageNum() { return pageNum; }
    public void setPageNum(long pageNum) { this.pageNum = pageNum; }
    public long getPageSize() { return pageSize; }
    public void setPageSize(long pageSize) { this.pageSize = pageSize; }
}
