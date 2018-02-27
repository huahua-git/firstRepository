package com.kingenta.alipay.vo;

import java.util.Map;

public class TradeRefundParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.trade.refund";
	
	private String outerTradeNo;
	private String origOuterTradeNo;
	private String outerInstOrderNo;
	private String refundAmount;
	private String royaltyParameters;
	private String notifyUrl;
	private String refundFeeInfo;
	private String refundInfo;
	private String refundEnsureAmount;
	private String operatorId;
	private String isWebAccess;
	
	public String getOuterTradeNo() {
		return outerTradeNo;
	}

	public void setOuterTradeNo(String outerTradeNo) {
		this.outerTradeNo = outerTradeNo;
	}

	public String getOrigOuterTradeNo() {
		return origOuterTradeNo;
	}

	public void setOrigOuterTradeNo(String origOuterTradeNo) {
		this.origOuterTradeNo = origOuterTradeNo;
	}

	public String getOuterInstOrderNo() {
		return outerInstOrderNo;
	}

	public void setOuterInstOrderNo(String outerInstOrderNo) {
		this.outerInstOrderNo = outerInstOrderNo;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRoyaltyParameters() {
		return royaltyParameters;
	}

	public void setRoyaltyParameters(String royaltyParameters) {
		this.royaltyParameters = royaltyParameters;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getRefundFeeInfo() {
		return refundFeeInfo;
	}

	public void setRefundFeeInfo(String refundFeeInfo) {
		this.refundFeeInfo = refundFeeInfo;
	}

	public String getRefundInfo() {
		return refundInfo;
	}

	public void setRefundInfo(String refundInfo) {
		this.refundInfo = refundInfo;
	}

	public String getRefundEnsureAmount() {
		return refundEnsureAmount;
	}

	public void setRefundEnsureAmount(String refundEnsureAmount) {
		this.refundEnsureAmount = refundEnsureAmount;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getIsWebAccess() {
		return isWebAccess;
	}

	public void setIsWebAccess(String isWebAccess) {
		this.isWebAccess = isWebAccess;
	}

	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("outer_trade_no", outerTradeNo);
		parameterMap.put("orig_outer_trade_no", origOuterTradeNo);
		parameterMap.put("outer_inst_order_no", outerInstOrderNo);
		parameterMap.put("refund_amount", refundAmount);
		parameterMap.put("royalty_parameters", royaltyParameters);
		parameterMap.put("notify_url", notifyUrl);
		parameterMap.put("refund_fee_info", refundFeeInfo);
		parameterMap.put("refund_info", refundInfo);
		parameterMap.put("refund_ensure_amount", refundEnsureAmount);
		parameterMap.put("operator_id", operatorId);
		parameterMap.put("is_web_access", isWebAccess);
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

