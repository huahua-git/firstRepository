package com.kingenta.alipay.vo;

import java.util.Map;

public class AreaBankQueryParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.area.bank.query";
	
	private String parentBranchNo;
	private String areaCode;
	private String keyWords;	

	public String getParentBranchNo() {
		return parentBranchNo;
	}

	public void setParentBranchNo(String parentBranchNo) {
		this.parentBranchNo = parentBranchNo;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("parent_branch_no", parentBranchNo);
		parameterMap.put("area_code", areaCode);
		parameterMap.put("key_words", keyWords);
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

