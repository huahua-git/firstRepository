package com.kingenta.alipay.vo;

import java.util.Map;

public class BalanceQueryParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.account.balance";
	
	private String uid;
	private String accountType;
	private String accountIdentity;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountIdentity() {
		return accountIdentity;
	}
	public void setAccountIdentity(String accountIdentity) {
		this.accountIdentity = accountIdentity;
	}
	
	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("uid", uid);
		parameterMap.put("account_type", accountType);
		parameterMap.put("account_identity", accountIdentity);
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

