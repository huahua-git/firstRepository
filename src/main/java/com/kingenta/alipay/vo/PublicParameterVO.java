package com.kingenta.alipay.vo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PublicParameterVO implements Serializable  {
	
	private static final long serialVersionUID = 5834765606177092614L;
	
	public static final String GATEWAY_URL = "http://test.tc.mybank.cn/gop/gateway.do";
	
	protected Map<String, String> toPublicParameter() {
		Map<String, String> publicParameter = new HashMap<String, String>();
		publicParameter.put("charset", "UTF-8");
        publicParameter.put("partner_id", "200001460628");
        publicParameter.put("version", "2.1");
        publicParameter.put("sign_type", "TWSIGN");
        publicParameter.put("sign", "e8qdwl9caset5zugii2r7q0k8ikopxor");
        return publicParameter;
	}

	public static String getNowTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date now = Calendar.getInstance().getTime();
		String nowStr = df.format(now);
		return nowStr;
	}
	
	public Map<String, String> toParameterMap() {return null;};
	public AlipayCallRecord toRecord() {return null;}
}

