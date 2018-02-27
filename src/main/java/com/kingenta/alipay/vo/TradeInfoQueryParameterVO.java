package com.kingenta.alipay.vo;

import java.util.Map;

public class TradeInfoQueryParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.trade.info.query";
	
	private String outerTradeNo;
	
	public String getOuterTradeNo() {
		return outerTradeNo;
	}
	public void setOuterTradeNo(String outerTradeNo) {
		this.outerTradeNo = outerTradeNo;
	}

	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("outer_trade_no", outerTradeNo);
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

