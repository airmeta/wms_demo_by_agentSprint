package com.ruoyi.wms.service.impl;

import com.ruoyi.wms.domain.WmsCommunity;
import com.ruoyi.wms.service.IWmsCommunityService;
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
public class WmsCommunityServiceImpl implements IWmsCommunityService {

    private static final Logger log = LoggerFactory.getLogger(WmsCommunityServiceImpl.class);

    @Override
    public WmsCommunity getById(Long communityId) {
        log.info("get community by id={}, database not configured in the demo backend", communityId);
        return null;
    }

    @Override
    public List<WmsCommunity> list(WmsCommunity query) {
        log.info("list communities by {}, database not configured in the demo backend", query);
        return Collections.emptyList();
    }

    @Override
    public int insert(WmsCommunity community) {
        log.info("insert community {}, database not configured in the demo backend", community);
        return 0;
    }

    @Override
    public int update(WmsCommunity community) {
        log.info("update community {}, database not configured in the demo backend", community);
        return 0;
    }

    @Override
    public int removeById(Long communityId) {
        log.info("remove community by id={}, database not configured in the demo backend", communityId);
        return 0;
    }
}
