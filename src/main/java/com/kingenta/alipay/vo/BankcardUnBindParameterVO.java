package com.kingenta.alipay.vo;

import java.util.Map;

public class BankcardUnBindParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.bankcard.unbind";
	
	private String uid;
	private String bankId;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	
	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("uid", uid);
		parameterMap.put("bank_id", bankId);
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

