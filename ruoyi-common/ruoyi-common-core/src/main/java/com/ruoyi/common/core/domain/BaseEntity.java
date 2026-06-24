package com.ruoyi.common.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Base entity with audit fields and parameter bag.
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Search value, transient")
    @TableField(exist = false)
    private String searchValue;

    @Schema(description = "Creator")
    @TableField(exist = false)
    private String createBy;

    @Schema(description = "Create time")
    @TableField(exist = false)
    private Date createTime;

    @Schema(description = "Updater")
    @TableField(exist = false)
    private String updateBy;

    @Schema(description = "Update time")
    @TableField(exist = false)
    private Date updateTime;

    @Schema(description = "Remark")
    @TableField(exist = false)
    private String remark;

    @Schema(description = "Request params")
    @TableField(exist = false)
    private Map<String, Object> params;

    public String getSearchValue() { return searchValue; }
    public void setSearchValue(String searchValue) { this.searchValue = searchValue; }
    public String getCreateBy() { return createBy; }
    public void setCreateBy(String createBy) { this.createBy = createBy; }
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }
    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
    public Date getUpdateTime() { return updateTime; }
    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }
    public void setParams(Map<String, Object> params) { this.params = params; }
}
