package com.kingenta.alipay.common;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import cn.topca.api.cert.CertApiException;
import cn.topca.api.cert.TCA;

public class ConfigTool {
	
    private static ConfigTool configTool = new ConfigTool();
    private static boolean initialized = false;
    
    public static ConfigTool getInstance(){
        return configTool;
    }
    
    private String signRootPath = "C:/alipay";
    
    private ConfigTool() {}
	
    @SuppressWarnings("static-access")
	public void init() throws IOException, CertApiException {
        //初始化不可重复
        if (initialized) return;
        //在此处设置配置文件的路径 
        FileInputStream fis = new FileInputStream(
        				new File(signRootPath + "/TopESA.SignAndVerify.onlyCACert.conf.json")
        			);
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fis.close();
        String json = new String(buf, "UTF-8");
        URL pfx = new URL("file://" + signRootPath + "/yinqizhiliantest.pfx"); 
        json = json.format(json, pfx.getPath());
        TCA.config(json);
        initialized = true;
    }

	public String getSignRootPath() {
		return signRootPath;
	}

	public void setSignRootPath(String signRootPath) {
		this.signRootPath = signRootPath;
	}
}