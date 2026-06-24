package com.ruoyi.wms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Community (小区) DTO.
 */
public class WmsCommunity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long communityId;
    private String communityCode;
    private String communityName;
    private String aliasName;
    private Long companyId;
    private String province;
    private String city;
    private String district;
    private String address;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private BigDecimal areaCovered;
    private Integer buildingCount;
    private Integer householdCount;
    private Integer parkingCount;
    private BigDecimal propertyFee;
    private String developer;
    private Date completedDate;
    private String managerName;
    private String managerPhone;
    private String status;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;

    public Long getCommunityId() { return communityId; }
    public void setCommunityId(Long communityId) { this.communityId = communityId; }
    public String getCommunityCode() { return communityCode; }
    public void setCommunityCode(String communityCode) { this.communityCode = communityCode; }
    public String getCommunityName() { return communityName; }
    public void setCommunityName(String communityName) { this.communityName = communityName; }
    public String getAliasName() { return aliasName; }
    public void setAliasName(String aliasName) { this.aliasName = aliasName; }
    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public BigDecimal getLongitude() { return longitude; }
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }
    public BigDecimal getLatitude() { return latitude; }
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }
    public BigDecimal getAreaCovered() { return areaCovered; }
    public void setAreaCovered(BigDecimal areaCovered) { this.areaCovered = areaCovered; }
    public Integer getBuildingCount() { return buildingCount; }
    public void setBuildingCount(Integer buildingCount) { this.buildingCount = buildingCount; }
    public Integer getHouseholdCount() { return householdCount; }
    public void setHouseholdCount(Integer householdCount) { this.householdCount = householdCount; }
    public Integer getParkingCount() { return parkingCount; }
    public void setParkingCount(Integer parkingCount) { this.parkingCount = parkingCount; }
    public BigDecimal getPropertyFee() { return propertyFee; }
    public void setPropertyFee(BigDecimal propertyFee) { this.propertyFee = propertyFee; }
    public String getDeveloper() { return developer; }
    public void setDeveloper(String developer) { this.developer = developer; }
    public Date getCompletedDate() { return completedDate; }
    public void setCompletedDate(Date completedDate) { this.completedDate = completedDate; }
    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public String getManagerPhone() { return managerPhone; }
    public void setManagerPhone(String managerPhone) { this.managerPhone = managerPhone; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
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
}
