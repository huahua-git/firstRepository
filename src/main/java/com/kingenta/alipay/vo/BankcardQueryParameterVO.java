package com.kingenta.alipay.vo;

import java.util.Map;

public class BankcardQueryParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.bankcard.query";
	
	private String uid;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("uid", uid);
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

