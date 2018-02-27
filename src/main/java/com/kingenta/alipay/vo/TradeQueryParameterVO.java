package com.kingenta.alipay.vo;

import java.util.Map;

public class TradeQueryParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.trade.query";
	
	private String startTime;
	private String endTime;
	private String isWebAccess;
	private String productCode;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getIsWebAccess() {
		return isWebAccess;
	}

	public void setIsWebAccess(String isWebAccess) {
		this.isWebAccess = isWebAccess;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("start_time", startTime);
		parameterMap.put("end_time", endTime);
		parameterMap.put("is_web_access", isWebAccess);
		parameterMap.put("product_code", productCode);
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

