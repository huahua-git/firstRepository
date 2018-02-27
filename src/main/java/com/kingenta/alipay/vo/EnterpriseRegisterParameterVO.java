package com.kingenta.alipay.vo;

import java.util.Map;

public class EnterpriseRegisterParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.enterprise.register";
	
	private String uid;
	private String enterpriseName;
	private String memberName;
	private String legalPerson;
	private String legalPersonCertificateType;
	private String legalPersonCertificateNo;
	private String legalPersonPhone;
	private String website;
	private String address;
	private String licenseNo;
	private String licenseAddress;
	private String licenseExpireDate;
	private String businessScope;
	private String telephone;
	private String organizationNo;
	private String unifiedSocialCreditCode;
	private String summary;
	private String openAccountLicense;
	private String isVerify;
	private String loginName;
	private String isActive;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getLegalPersonCertificateType() {
		return legalPersonCertificateType;
	}
	public void setLegalPersonCertificateType(String legalPersonCertificateType) {
		this.legalPersonCertificateType = legalPersonCertificateType;
	}
	public String getLegalPersonCertificateNo() {
		return legalPersonCertificateNo;
	}
	public void setLegalPersonCertificateNo(String legalPersonCertificateNo) {
		this.legalPersonCertificateNo = legalPersonCertificateNo;
	}
	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}
	public void setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getLicenseAddress() {
		return licenseAddress;
	}
	public void setLicenseAddress(String licenseAddress) {
		this.licenseAddress = licenseAddress;
	}
	public String getLicenseExpireDate() {
		return licenseExpireDate;
	}
	public void setLicenseExpireDate(String licenseExpireDate) {
		this.licenseExpireDate = licenseExpireDate;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getOrganizationNo() {
		return organizationNo;
	}
	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}
	public String getUnifiedSocialCreditCode() {
		return unifiedSocialCreditCode;
	}
	public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
		this.unifiedSocialCreditCode = unifiedSocialCreditCode;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getOpenAccountLicense() {
		return openAccountLicense;
	}
	public void setOpenAccountLicense(String openAccountLicense) {
		this.openAccountLicense = openAccountLicense;
	}
	public String getIsVerify() {
		return isVerify;
	}
	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("uid", uid);
		parameterMap.put("enterprise_name", enterpriseName);
		parameterMap.put("member_name", memberName);
		parameterMap.put("legal_person", legalPerson);
		parameterMap.put("legal_person_certificate_type", legalPersonCertificateType);
		parameterMap.put("legal_person_certificate_no", legalPersonCertificateNo);
		parameterMap.put("legal_person_phone", legalPersonPhone);
		parameterMap.put("website", website);
		parameterMap.put("address", address);
		parameterMap.put("license_no", licenseNo);
		parameterMap.put("license_address", licenseAddress);
		parameterMap.put("license_expire_date", licenseExpireDate);
		parameterMap.put("business_scope", businessScope);
		parameterMap.put("telephone", telephone);
		parameterMap.put("organization_no", organizationNo);
		parameterMap.put("unified_social_credit_code", unifiedSocialCreditCode);
		parameterMap.put("summary", summary);
		parameterMap.put("open_account_license", openAccountLicense);
		parameterMap.put("is_verify", isVerify);
		parameterMap.put("login_name", loginName);
		parameterMap.put("is_active", isActive);

		return parameterMap;
	}
	
	@Override
	public AlipayCallRecord toRecord() {
		AlipayCallRecord record = new AlipayCallRecord();
		record.setCallService(SERVICE);
		record.setCallParam(toParameterMap().toString());
		record.setCallTime(getNowTime());
		return record;
	}
 	
}

