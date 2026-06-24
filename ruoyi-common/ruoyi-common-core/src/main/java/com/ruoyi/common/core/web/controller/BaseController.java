package com.ruoyi.common.core.web.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.PageResult;
import com.ruoyi.common.core.utils.ServletUtils;
import com.ruoyi.common.core.web.page.PageDomainHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * Base controller for the web layer.
 */
public class BaseController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Wrap a PageInfo into our PageResult.
     */
    protected <T> PageResult<T> toPageResult(List<T> list) {
        PageInfo<T> info = new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(), info.getPageSize(), info.getTotal(), info.getList());
    }

    /**
     * Standard ok response.
     */
    protected R<Void> ok() {
        return R.ok();
    }

    /**
     * Standard ok response with data.
     */
    protected <T> R<T> ok(T data) {
        return R.ok(data);
    }

    /**
     * Build a PageDomain from the current request parameters.
     */
    protected PageDomain buildPageDomain() {
        return PageDomainHelper.build();
    }

    /**
     * Allow date binding in web requests.
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(new Date(Long.parseLong(text)));
            }
        });
    }
}
