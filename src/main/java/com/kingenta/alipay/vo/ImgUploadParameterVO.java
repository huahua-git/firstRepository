package com.kingenta.alipay.vo;

import java.util.Map;

public class ImgUploadParameterVO extends PublicParameterVO {

	private static final long serialVersionUID = -5179641488474630667L;
	
	private final static String SERVICE = "mybank.tc.user.info.img.upload";
	
	private String file;
	private String fileName;
	private String purpose;
	private String relaVoucherNo;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRelaVoucherNo() {
		return relaVoucherNo;
	}

	public void setRelaVoucherNo(String relaVoucherNo) {
		this.relaVoucherNo = relaVoucherNo;
	}

	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> parameterMap = toPublicParameter();
		parameterMap.put("service", SERVICE);
		parameterMap.put("file", file);
		parameterMap.put("file_name", fileName);
		parameterMap.put("purpose", purpose);
		parameterMap.put("rela_voucher_no", relaVoucherNo);
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

