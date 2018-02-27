package com.kingenta.alipay.vo;

import java.util.Map;

public class TradePayToCardParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.trade.paytocard";
	
	private String outerTradeNo;
	private String uid;
	private String outerInstOrderNo;
	private String whiteChannelCode;
	private String accountType;
	private String bankId;
	private String amount;
	private String notifyUrl;
	private String feeInfo;
	private String isWebAccess;
	private String accountIdentity;
	private String productCode;
	private String bankAccountNo;
	private String payAttribute;

	public String getOuterTradeNo() {
		return outerTradeNo;
	}

	public void setOuterTradeNo(String outerTradeNo) {
		this.outerTradeNo = outerTradeNo;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getOuterInstOrderNo() {
		return outerInstOrderNo;
	}

	public void setOuterInstOrderNo(String outerInstOrderNo) {
		this.outerInstOrderNo = outerInstOrderNo;
	}

	public String getWhiteChannelCode() {
		return whiteChannelCode;
	}

	public void setWhiteChannelCode(String whiteChannelCode) {
		this.whiteChannelCode = whiteChannelCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getFeeInfo() {
		return feeInfo;
	}

	public void setFeeInfo(String feeInfo) {
		this.feeInfo = feeInfo;
	}

	public String getIsWebAccess() {
		return isWebAccess;
	}

	public void setIsWebAccess(String isWebAccess) {
		this.isWebAccess = isWebAccess;
	}

	public String getAccountIdentity() {
		return accountIdentity;
	}

	public void setAccountIdentity(String accountIdentity) {
		this.accountIdentity = accountIdentity;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
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
		parameterMap.put("outer_trade_no", outerTradeNo);
		parameterMap.put("uid", uid);
		parameterMap.put("outer_inst_order_no", outerInstOrderNo);
		parameterMap.put("white_channel_code", whiteChannelCode);
		parameterMap.put("account_type", accountType);
		parameterMap.put("bank_id", bankId);
		parameterMap.put("amount", amount);
		parameterMap.put("notify_url", notifyUrl);
		parameterMap.put("fee_info", feeInfo);
		parameterMap.put("is_web_access", isWebAccess);
		parameterMap.put("account_identity", accountIdentity);
		parameterMap.put("product_code", productCode);
		parameterMap.put("bank_account_no", bankAccountNo);
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

