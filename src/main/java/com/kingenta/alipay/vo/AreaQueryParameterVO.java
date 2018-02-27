package com.kingenta.alipay.vo;

import java.util.Map;

public class AreaQueryParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.area.query";
	
	private String parentDistrictCode;
		
	public String getParentDistrictCode() {
		return parentDistrictCode;
	}
	public void setParentDistrictCode(String parentDistrictCode) {
		this.parentDistrictCode = parentDistrictCode;
	}

	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("parent_district_code", parentDistrictCode);
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

