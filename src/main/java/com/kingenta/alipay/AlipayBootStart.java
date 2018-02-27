package com.kingenta.alipay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.kingenta.alipay.common.ConfigTool;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.kingenta.alipay.dao")
public class AlipayBootStart {

	public static void main(String[] args) {
		if (args != null & args.length > 0) {
			ConfigTool.getInstance().setSignRootPath(args[0]);
		}
		SpringApplication.run(AlipayBootStart.class, args);  
	}

}
