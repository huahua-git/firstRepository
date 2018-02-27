package com.kingenta.alipay.vo;

import java.util.Map;

public class BankcardBindParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.bankcard.bind";
	
	private String uid;
	private String bankName;
	private String bankBranch;
	private String branchNo;
	private String bankAccountNo;
	private String accountName;
	private String cardType;
	private String cardAttribute;
	private String verifyType;
	private String certificateType;
	private String certificateNo;
	private String province;
	private String city;
	private String reservedMobile;
	private String payAttribute;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBranchNo() {
		return branchNo;
	}
	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardAttribute() {
		return cardAttribute;
	}
	public void setCardAttribute(String cardAttribute) {
		this.cardAttribute = cardAttribute;
	}
	public String getVerifyType() {
		return verifyType;
	}
	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getReservedMobile() {
		return reservedMobile;
	}
	public void setReservedMobile(String reservedMobile) {
		this.reservedMobile = reservedMobile;
	}
	public String getPayAttribute() {
		return payAttribute;
	}
	public void setPayAttribute(String payAttribute) {
		this.payAttribute = payAttribute;
	}
	
	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("uid", uid);
		parameterMap.put("bank_name", bankName);
		parameterMap.put("bank_branch", bankBranch);
		parameterMap.put("branch_no", branchNo);
		parameterMap.put("bank_account_no", bankAccountNo);
		parameterMap.put("account_name", accountName);
		parameterMap.put("card_type", cardType);
		parameterMap.put("card_attribute", cardAttribute);
		parameterMap.put("verify_type", verifyType);
		parameterMap.put("certificate_type", certificateType);
		parameterMap.put("certificate_no", certificateNo);
		parameterMap.put("province", province);
		parameterMap.put("city", city);
		parameterMap.put("reserved_mobile", reservedMobile);
		parameterMap.put("pay_attribute", payAttribute);
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

