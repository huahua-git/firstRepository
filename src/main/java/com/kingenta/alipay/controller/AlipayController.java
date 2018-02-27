package com.kingenta.alipay.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kingenta.alipay.common.MagCore;
import com.kingenta.alipay.service.AlipayService;
import com.kingenta.alipay.vo.AlipayCallRecord;
import com.kingenta.alipay.vo.AreaBankQueryParameterVO;
import com.kingenta.alipay.vo.AreaQueryParameterVO;
import com.kingenta.alipay.vo.BalanceQueryParameterVO;
import com.kingenta.alipay.vo.BankcardBindParameterVO;
import com.kingenta.alipay.vo.BankcardQueryParameterVO;
import com.kingenta.alipay.vo.BankcardUnBindParameterVO;
import com.kingenta.alipay.vo.CardbinQueryParameterVO;
import com.kingenta.alipay.vo.EnterpriseModifyParameterVO;
import com.kingenta.alipay.vo.EnterpriseQueryParameterVO;
import com.kingenta.alipay.vo.EnterpriseRegisterParameterVO;
import com.kingenta.alipay.vo.ImgUploadParameterVO;
import com.kingenta.alipay.vo.OnlineCreateParameterVO;
import com.kingenta.alipay.vo.PublicParameterVO;
import com.kingenta.alipay.vo.TradeCloseParameterVO;
import com.kingenta.alipay.vo.TradeCreateAndPayParameterVO;
import com.kingenta.alipay.vo.TradeInfoQueryParameterVO;
import com.kingenta.alipay.vo.TradePayToCardParameterVO;
import com.kingenta.alipay.vo.TradeQueryParameterVO;
import com.kingenta.alipay.vo.TradeRefundParameterVO;

@RestController  
@RequestMapping(value = "/alipay")  
public class AlipayController {
	
	private final static Log logger =LogFactory.getLog(AlipayController.class);
	
	private static int SOCKET_TIMEOUT = 15000; //请求超时时间  
	private static int CONNECT_TIMEOUT = 15000; //连接超时时间
	private static int CONNECTION_REQUEST_TIMEOUT = 15000; //从线程池获取连接超时时间 
	private static int MAX_CONNECTION = 800; //线程池连接数量
	private static int MAX_ROUTE_CONNECTION = 800; //单个路由连接数量(实际起作用 因为只有一个路由到阿里服务)
	
	private static HttpClient httpClient = null;
	private static HttpPost post = null;
	
	@Autowired private AlipayService alipayService;
	
	static {
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT).
															 setConnectTimeout(CONNECT_TIMEOUT).
															 setSocketTimeout(SOCKET_TIMEOUT).build(); 
		httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).
										  setMaxConnTotal(MAX_CONNECTION).
										  setMaxConnPerRoute(MAX_ROUTE_CONNECTION).build();  
		post = new HttpPost(PublicParameterVO.GATEWAY_URL);
	}

	//1.开企业户 (联调成功)
	@RequestMapping(value="/registerEnterprise", method = RequestMethod.POST)   
    public String registerEnterprise(EnterpriseRegisterParameterVO parameter) {  
		return callAlipayService(parameter); 
    } 
	
	//2.修改企业信息 (联调成功)
	@RequestMapping(value="/modifyEnterprise", method = RequestMethod.POST)   
    public String modifyEnterprise(EnterpriseModifyParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//3.查询企业信息 (联调成功)
	@RequestMapping(value="/queryEnterprise", method = RequestMethod.POST)   
    public String queryEnterprise(EnterpriseQueryParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//4.查余额 (联调成功)
	@RequestMapping(value="/queryBalance", method = RequestMethod.POST)   
    public String queryBalance(BalanceQueryParameterVO parameter) {  
		return callAlipayService(parameter);  
    }
	
	//5.绑定银行卡 (联调成功)
	@RequestMapping(value="/bindBankcard", method = RequestMethod.POST)   
    public String bindBankcard(BankcardBindParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//6.解绑银行卡 (联调成功)
	@RequestMapping(value="/unbindBankcard", method = RequestMethod.POST)   
    public String unbindBankcard(BankcardUnBindParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//7.查询银行卡列表 (联调成功)
	@RequestMapping(value="/queryBankcard", method = RequestMethod.POST)   
    public String queryBankcard(BankcardQueryParameterVO parameter) {  
		return callAlipayService(parameter);  
    }
	
	//8.文件上传 (联调成功)
	@RequestMapping(value="/uploadImg", method = RequestMethod.POST)   
    public String uploadImg(ImgUploadParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//9.商户入驻 (联调成功)
	@RequestMapping(value="/createOnline", method = RequestMethod.POST)   
    public String createOnline(OnlineCreateParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//10.即时入账-下单并支付 (联调成功)
	@RequestMapping(value="/createAndPayTrade", method = RequestMethod.POST)   
    public String createAndPayTrade(TradeCreateAndPayParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//11.交易关闭 (联调成功)
	@RequestMapping(value="/closeTrade", method = RequestMethod.POST)   
    public String closeTrade(TradeCloseParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//12.单笔提现 (联调成功)
	@RequestMapping(value="/payToCardTrade", method = RequestMethod.POST)   
    public String payToCardTrade(TradePayToCardParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//13.退款入账 (联调成功)
	@RequestMapping(value="/refundTrade", method = RequestMethod.POST)   
    public String refundTrade(TradeRefundParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//14.交易流水查询 (联调成功)
	@RequestMapping(value="/queryTrade", method = RequestMethod.POST)   
    public String queryTrade(TradeQueryParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//15.交易详情查询 (联调成功)
	@RequestMapping(value="/queryTradeInfo", method = RequestMethod.POST)   
    public String queryTradeInfo(TradeInfoQueryParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//16.省市查询 (联调成功)
	@RequestMapping(value="/queryArea", method = RequestMethod.POST)   
    public String queryArea(AreaQueryParameterVO parameter) { 
		return callAlipayService(parameter); 
    }
	
	//17.银行列表查询 (联调成功)
	@RequestMapping(value="/queryAreaBank", method = RequestMethod.POST)   
    public String queryAreaBank(AreaBankQueryParameterVO parameter) {  
		return callAlipayService(parameter); 
    }
	
	//18.卡BIN查询(联调成功)
	@RequestMapping(value="/queryCardbinBank", method = RequestMethod.POST)   
    public String queryCardbinBank(CardbinQueryParameterVO parameter) {  
        return callAlipayService(parameter); 
    }
	
	private String callAlipayService(PublicParameterVO parameter) {
		Map<String, String> alipayParameter = parameter.toParameterMap();
		Map<String, String> finalAlipayParameter = MagCore.paraFilter(alipayParameter);
		String signVal = "";
        try {
			signVal =  MagCore.buildRequestByTWSIGN(finalAlipayParameter,"utf-8");
		} catch (Exception e) {
			logger.error("Error happened when get public parameter sign value:" + e.getMessage());
		}
        finalAlipayParameter.put("sign_type", "TWSIGN");
        finalAlipayParameter.put("sign", signVal);
		AlipayCallRecord alipayCallRecord = parameter.toRecord();
		String res = doHttpClientPost(finalAlipayParameter, alipayCallRecord);   
		saveAlipayCallRecord(alipayCallRecord);
        return res; 
	}
	
	private String doHttpClientPost(Map<String, String> params, AlipayCallRecord record) {
		JSONObject resObj = new JSONObject();
		HttpResponse response = null;
		String responseStr = null;
		try {
			List<NameValuePair> ps = buildPostParams(params);
			post.setEntity(new UrlEncodedFormEntity(ps, "UTF-8"));
			response = httpClient.execute(post);
			responseStr = inputStreamToStr(response.getEntity().getContent(), "UTF-8");
			if (response.getStatusLine().getStatusCode() == 200) {
				resObj.put("callSuccess", "T");
				resObj.put("callErrorMessage", "");
				resObj.put("callResponse", responseStr);
				record.setCallSuccess("T");
				record.setCallErrorMessage("");
				record.setCallResponse(responseStr);
			} else {
				resObj.put("callSuccess", "F");
				resObj.put("callErrorMessage", responseStr);
				resObj.put("callResponse", "");
				record.setCallSuccess("F");
				record.setCallErrorMessage(responseStr);
				record.setCallResponse("");
			}
		} catch (Exception e) {
			try {
				resObj.put("callSuccess", "F");
				resObj.put("callErrorMessage", e.getMessage());
				resObj.put("callResponse", "");
				record.setCallSuccess("F");
				record.setCallErrorMessage(e.getMessage());
				record.setCallResponse("");
			} catch (JSONException e1) {
				StringBuffer sb = new StringBuffer();
				sb.append(e1.getMessage());
				sb.append(" [");
				sb.append(params.toString());
				sb.append("]");
				logger.error(sb.toString());
			}
		} finally {
			post.releaseConnection();
		}
		return resObj.toString();
	}

	private List<NameValuePair> buildPostParams(Map<String, String> params) {
		if (params == null || params.size() == 0) return null;
		List<NameValuePair> results = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			results.add(new BasicNameValuePair(key, value));
		}
		return results;
	}

	private String inputStreamToStr(InputStream is, String charset) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		return new String(buffer.toString().getBytes("ISO-8859-1"), charset);
	}
	
	private void saveAlipayCallRecord(AlipayCallRecord alipayCallRecord) {
		try {
			alipayService.saveAlipayCallRecord(alipayCallRecord);
		} catch (Exception e) {
			StringBuffer sb = new StringBuffer();
			sb.append(e.getMessage());
			sb.append(" [");
			sb.append(alipayCallRecord.toString());
			sb.append("]");
			logger.error(sb.toString());
		}
	}
	
}

