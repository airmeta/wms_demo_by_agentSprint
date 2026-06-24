package com.ruoyi.wms.service;

import com.ruoyi.wms.domain.WmsCommunity;

import java.util.List;

/**
 * Community (小区) service.
 */
public interface IWmsCommunityService {

    WmsCommunity getById(Long communityId);

    List<WmsCommunity> list(WmsCommunity query);

    int insert(WmsCommunity community);

    int update(WmsCommunity community);

    int removeById(Long communityId);
}
