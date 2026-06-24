package com.ruoyi.wms.service.impl;

import com.ruoyi.wms.domain.WmsPropertyCompany;
import com.ruoyi.wms.service.IWmsPropertyCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Demo implementation: the database is intentionally not configured for the
 * wms service, so the methods just log and return empty results. Wire up the
 * MyBatis-Plus mapper once the datasource is connected.
 */
@Service
public class WmsPropertyCompanyServiceImpl implements IWmsPropertyCompanyService {

    private static final Logger log = LoggerFactory.getLogger(WmsPropertyCompanyServiceImpl.class);

    @Override
    public WmsPropertyCompany getById(Long companyId) {
        log.info("get property company by id={}, database not configured in the demo backend", companyId);
        return null;
    }

    @Override
    public List<WmsPropertyCompany> list(WmsPropertyCompany query) {
        log.info("list property companies by {}, database not configured in the demo backend", query);
        return Collections.emptyList();
    }

    @Override
    public int insert(WmsPropertyCompany company) {
        log.info("insert property company {}, database not configured in the demo backend", company);
        return 0;
    }

    @Override
    public int update(WmsPropertyCompany company) {
        log.info("update property company {}, database not configured in the demo backend", company);
        return 0;
    }

    @Override
    public int removeById(Long companyId) {
        log.info("remove property company by id={}, database not configured in the demo backend", companyId);
        return 0;
    }
}
