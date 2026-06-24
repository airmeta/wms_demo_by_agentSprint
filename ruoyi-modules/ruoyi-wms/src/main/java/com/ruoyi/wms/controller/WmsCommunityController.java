package com.ruoyi.wms.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.wms.domain.WmsCommunity;
import com.ruoyi.wms.service.IWmsCommunityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Community (小区) controller.
 */
@Tag(name = "WmsCommunityController", description = "Community management APIs")
@RestController
@RequestMapping("/community")
public class WmsCommunityController extends BaseController {

    @Autowired
    private IWmsCommunityService communityService;

    @Operation(summary = "Get a community by id")
    @GetMapping("/{communityId}")
    public R<WmsCommunity> getInfo(@PathVariable("communityId") Long communityId) {
        return R.ok(communityService.getById(communityId));
    }

    @Operation(summary = "List communities")
    @GetMapping("/list")
    public R<List<WmsCommunity>> list(WmsCommunity query) {
        return R.ok(communityService.list(query));
    }

    @Operation(summary = "Add a community")
    @Log(title = "community", businessType = "INSERT")
    @PostMapping
    public R<Integer> add(@RequestBody WmsCommunity community) {
        return R.ok(communityService.insert(community));
    }

    @Operation(summary = "Update a community")
    @Log(title = "community", businessType = "UPDATE")
    @PutMapping
    public R<Integer> edit(@RequestBody WmsCommunity community) {
        return R.ok(communityService.update(community));
    }

    @Operation(summary = "Remove a community")
    @Log(title = "community", businessType = "DELETE")
    @DeleteMapping("/{communityId}")
    public R<Integer> remove(@PathVariable("communityId") Long communityId) {
        return R.ok(communityService.removeById(communityId));
    }
}
