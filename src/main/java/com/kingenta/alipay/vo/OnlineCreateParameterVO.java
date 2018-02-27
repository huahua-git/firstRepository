package com.kingenta.alipay.vo;

import java.util.Map;

public class OnlineCreateParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.online.create";
	
	private String uid;
	private String targetInstCode;
	private String name;
	private String aliasName;
	private String servicePhone;
	private String mcc;
	private String businessLicense;
	private String businessLicenseType;
	private String contactInfo;
	private String addressInfo;
	private String bankcardInfo;
	private String siteInfo;
	private String payCodeInfo;
	private String logonId;
	private String signBankTime;
	private String extension;
	private String memo;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTargetInstCode() {
		return targetInstCode;
	}
	public void setTargetInstCode(String targetInstCode) {
		this.targetInstCode = targetInstCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getServicePhone() {
		return servicePhone;
	}
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getBusinessLicenseType() {
		return businessLicenseType;
	}
	public void setBusinessLicenseType(String businessLicenseType) {
		this.businessLicenseType = businessLicenseType;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}
	public String getBankcardInfo() {
		return bankcardInfo;
	}
	public void setBankcardInfo(String bankcardInfo) {
		this.bankcardInfo = bankcardInfo;
	}
	public String getSiteInfo() {
		return siteInfo;
	}
	public void setSiteInfo(String siteInfo) {
		this.siteInfo = siteInfo;
	}
	public String getPayCodeInfo() {
		return payCodeInfo;
	}
	public void setPayCodeInfo(String payCodeInfo) {
		this.payCodeInfo = payCodeInfo;
	}
	public String getLogonId() {
		return logonId;
	}
	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}
	public String getSignBankTime() {
		return signBankTime;
	}
	public void setSignBankTime(String signBankTime) {
		this.signBankTime = signBankTime;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("uid", uid);
		parameterMap.put("target_inst_code", targetInstCode);
		parameterMap.put("name", name);
		parameterMap.put("alias_name", aliasName);
		parameterMap.put("service_phone", servicePhone);
		parameterMap.put("mcc", mcc);
		parameterMap.put("business_license", businessLicense);
		parameterMap.put("business_license_type", businessLicenseType);
		parameterMap.put("contact_info", contactInfo);
		parameterMap.put("address_info", addressInfo);
		parameterMap.put("bankcard_info", bankcardInfo);
		parameterMap.put("site_info", siteInfo);
		parameterMap.put("pay_code_info", payCodeInfo);
		parameterMap.put("logon_id", logonId);
		parameterMap.put("sign_bank_time", signBankTime);
		parameterMap.put("extension", extension);
		parameterMap.put("memo", memo);
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

