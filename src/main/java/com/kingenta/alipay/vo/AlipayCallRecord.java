package com.kingenta.alipay.vo;

import java.io.Serializable;

public class AlipayCallRecord implements Serializable {

	private static final long serialVersionUID = -8777540493194253514L;
	
	private String id;
	private String callService;
	private String callParam;
	private String callSuccess;
	private String callErrorMessage;
	private String callResponse;
	private String callTime;
	private String callTime222;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCallService() {
		return callService;
	}
	public void setCallService(String callService) {
		this.callService = callService;
	}
	public String getCallParam() {
		return callParam;
	}
	public void setCallParam(String callParam) {
		this.callParam = callParam;
	}
	public String getCallSuccess() {
		return callSuccess;
	}
	public void setCallSuccess(String callSuccess) {
		this.callSuccess = callSuccess;
	}
	public String getCallErrorMessage() {
		return callErrorMessage;
	}
	public void setCallErrorMessage(String callErrorMessage) {
		this.callErrorMessage = callErrorMessage;
	}
	public String getCallResponse() {
		return callResponse;
	}
	public void setCallResponse(String callResponse) {
		this.callResponse = callResponse;
	}
	public String getCallTime() {
		return callTime;
	}
	public void setCallTime(String callTime) {
		this.callTime = callTime;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" callService:" + callService);
		sb.append(" callParam:" + callParam);
		sb.append(" callSuccess:" + callSuccess);
		sb.append(" callErrorMessage:" + callErrorMessage);
		sb.append(" callResponse:" + callResponse);
		sb.append(" callTime:" + callTime);
		return sb.toString();
	}
	
}
