package com.kingenta.alipay.vo;

import java.util.Map;

public class TradeCreateAndPayParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.trade.pay.creatAndpay";
	
	private String outerTradeNo;
	private String buyerId;
	private String buyerIp;
	private String payMethod;
	private String subject;
	private String returnUrl;
	private String price;
	private String quantity;
	private String totalAmount;
	private String sellerId;
	private String accountType;
	private String notifyUrl;
	private String discountPayMethod;
	private String feeInfo;
	private String royaltyParameters;
	private String body;
	private String showUrl;
	private String shopName;
	private String outerInstOrderNo;
	private String whiteChannelCode;
	private String productCode;
	private String operatorId;
	private String goCashier;
	private String isWebAccess;
	private String accountIdentity;
	private String expirationTime;
	private String submitTime;

	public String getOuterTradeNo() {
		return outerTradeNo;
	}

	public void setOuterTradeNo(String outerTradeNo) {
		this.outerTradeNo = outerTradeNo;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerIp() {
		return buyerIp;
	}

	public void setBuyerIp(String buyerIp) {
		this.buyerIp = buyerIp;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getDiscountPayMethod() {
		return discountPayMethod;
	}

	public void setDiscountPayMethod(String discountPayMethod) {
		this.discountPayMethod = discountPayMethod;
	}

	public String getFeeInfo() {
		return feeInfo;
	}

	public void setFeeInfo(String feeInfo) {
		this.feeInfo = feeInfo;
	}

	public String getRoyaltyParameters() {
		return royaltyParameters;
	}

	public void setRoyaltyParameters(String royaltyParameters) {
		this.royaltyParameters = royaltyParameters;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getShowUrl() {
		return showUrl;
	}

	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getGoCashier() {
		return goCashier;
	}

	public void setGoCashier(String goCashier) {
		this.goCashier = goCashier;
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

	public String getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("outer_trade_no", outerTradeNo);
		parameterMap.put("buyer_id", buyerId);
		parameterMap.put("buyer_ip", buyerIp);
		parameterMap.put("pay_method", payMethod);
		parameterMap.put("subject", subject);
		parameterMap.put("return_url", returnUrl);
		parameterMap.put("price", price);
		parameterMap.put("quantity", quantity);
		parameterMap.put("total_amount", totalAmount);
		parameterMap.put("seller_id", sellerId);
		parameterMap.put("account_type", accountType);
		parameterMap.put("notify_url", notifyUrl);
		parameterMap.put("discount_pay_method", discountPayMethod);
		parameterMap.put("fee_info", feeInfo);
		parameterMap.put("royalty_parameters", royaltyParameters);
		parameterMap.put("body", body);
		parameterMap.put("show_url", showUrl);
		parameterMap.put("shop_name", shopName);
		parameterMap.put("outer_inst_order_no", outerInstOrderNo);
		parameterMap.put("white_channel_code", whiteChannelCode);
		parameterMap.put("product_code", productCode);
		parameterMap.put("operator_id", operatorId);
		parameterMap.put("go_cashier", goCashier);
		parameterMap.put("is_web_access", isWebAccess);
		parameterMap.put("account_identity", accountIdentity);
		parameterMap.put("expiration_time", expirationTime);
		parameterMap.put("submit_time", submitTime);
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

