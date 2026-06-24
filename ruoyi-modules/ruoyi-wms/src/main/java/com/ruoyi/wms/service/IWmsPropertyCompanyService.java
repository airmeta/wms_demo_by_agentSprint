package com.ruoyi.wms.service;

import com.ruoyi.wms.domain.WmsPropertyCompany;

import java.util.List;

/**
 * Property company (物业公司) service.
 */
public interface IWmsPropertyCompanyService {

    WmsPropertyCompany getById(Long companyId);

    List<WmsPropertyCompany> list(WmsPropertyCompany query);

    int insert(WmsPropertyCompany company);

    int update(WmsPropertyCompany company);

    int removeById(Long companyId);
}
