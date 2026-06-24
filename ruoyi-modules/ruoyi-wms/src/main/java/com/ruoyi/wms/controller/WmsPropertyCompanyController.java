package com.ruoyi.wms.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.wms.domain.WmsPropertyCompany;
import com.ruoyi.wms.service.IWmsPropertyCompanyService;
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
 * Property company (物业公司) controller.
 */
@Tag(name = "WmsPropertyCompanyController", description = "Property company management APIs")
@RestController
@RequestMapping("/property")
public class WmsPropertyCompanyController extends BaseController {

    @Autowired
    private IWmsPropertyCompanyService propertyCompanyService;

    @Operation(summary = "Get a property company by id")
    @GetMapping("/{companyId}")
    public R<WmsPropertyCompany> getInfo(@PathVariable("companyId") Long companyId) {
        return R.ok(propertyCompanyService.getById(companyId));
    }

    @Operation(summary = "List property companies")
    @GetMapping("/list")
    public R<List<WmsPropertyCompany>> list(WmsPropertyCompany query) {
        return R.ok(propertyCompanyService.list(query));
    }

    @Operation(summary = "Add a property company")
    @Log(title = "property company", businessType = "INSERT")
    @PostMapping
    public R<Integer> add(@RequestBody WmsPropertyCompany company) {
        return R.ok(propertyCompanyService.insert(company));
    }

    @Operation(summary = "Update a property company")
    @Log(title = "property company", businessType = "UPDATE")
    @PutMapping
    public R<Integer> edit(@RequestBody WmsPropertyCompany company) {
        return R.ok(propertyCompanyService.update(company));
    }

    @Operation(summary = "Remove a property company")
    @Log(title = "property company", businessType = "DELETE")
    @DeleteMapping("/{companyId}")
    public R<Integer> remove(@PathVariable("companyId") Long companyId) {
        return R.ok(propertyCompanyService.removeById(companyId));
    }
}
