package com.ruoyi.wms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Property company (物业公司) DTO.
 */
public class WmsPropertyCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long companyId;
    private String companyName;
    private String companyCode;
    private String shortName;
    private String legalPerson;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String address;
    private String businessLicense;
    private String registeredCapital;
    private Date establishedDate;
    private String serviceScope;
    private String bankName;
    private String bankAccount;
    private String status;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getCompanyCode() { return companyCode; }
    public void setCompanyCode(String companyCode) { this.companyCode = companyCode; }
    public String getShortName() { return shortName; }
    public void setShortName(String shortName) { this.shortName = shortName; }
    public String getLegalPerson() { return legalPerson; }
    public void setLegalPerson(String legalPerson) { this.legalPerson = legalPerson; }
    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }
    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }
    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getBusinessLicense() { return businessLicense; }
    public void setBusinessLicense(String businessLicense) { this.businessLicense = businessLicense; }
    public String getRegisteredCapital() { return registeredCapital; }
    public void setRegisteredCapital(String registeredCapital) { this.registeredCapital = registeredCapital; }
    public Date getEstablishedDate() { return establishedDate; }
    public void setEstablishedDate(Date establishedDate) { this.establishedDate = establishedDate; }
    public String getServiceScope() { return serviceScope; }
    public void setServiceScope(String serviceScope) { this.serviceScope = serviceScope; }
    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    public String getBankAccount() { return bankAccount; }
    public void setBankAccount(String bankAccount) { this.bankAccount = bankAccount; }
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
