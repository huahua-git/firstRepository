package com.kingenta.alipay.common;


import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.topca.api.cert.CertApiException;
import cn.topca.api.cert.CertSet;
import cn.topca.api.cert.CertStore;
import cn.topca.api.cert.Certificate;

/**
 *
 * <p>RSA签名,加解密处理核心文件，注意：密钥长度1024</p>
 * @author leelun
 * @version $Id: RSA.java, v 0.1 2013-11-15 下午2:33:53 lilun Exp $
 */
public class TWSIGN {

    private static Logger logger = LoggerFactory.getLogger(TWSIGN.class);

    /**
     * 
     * @author simon.xxm
     * @version $Id: Sign.java, v 0.1 2016年1月13日 下午3:49:42 simon.xxm Exp $
     * @param plainData 原文
     * @param encapsulate 是否包含原文
     * @throws CertApiException 
     * @throws UnsupportedEncodingException 
     */
    public static String sign(String plainData, boolean encapsulate) throws CertApiException, UnsupportedEncodingException {
        Certificate certificate = null;
        CertSet certSet = null;
        try {
            ConfigTool.getInstance().init();
            certSet = CertStore.listAllCerts();
            certificate = certSet.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //是否包含原文
        byte[] signedData = null;
        try {
        	
            //签名
            signedData = certificate.signP7(plainData.getBytes("UTF-8"), encapsulate);
        } catch (CertApiException e) {
            logger.info("天威签名异常：{}", e.getMessage());
            throw new CertApiException(e.getErrCode(), e.getCause());
        }
        String sign = Base64.encodeBase64String(signedData);
        return sign;
    }

    //加密byte[]
    public static byte[] encodeByte(byte[] plainData, boolean encapsulate)
                                                                                                 throws CertApiException {
        Certificate certificate = null;
        CertSet certSet = null;
        try {
            ConfigTool configTool = ConfigTool.getInstance();
            configTool.init();
            certSet = CertStore.listAllCerts();
            certificate = certSet.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] retunData = null;
        try {
            //签名
            byte[] signedData = certificate.signP7(plainData, encapsulate);
            retunData = Base64.encodeBase64(signedData);

        } catch (CertApiException e) {
            logger.info("天威签名异常：{}", e.getMessage());
            throw new CertApiException(e.getErrCode(), e.getCause());
        }
        return retunData;
    }
}