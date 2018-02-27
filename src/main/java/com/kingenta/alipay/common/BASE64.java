package com.kingenta.alipay.common;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;

public class BASE64 {
	
	public static void main(String args[]) {
		try {
			String pathOrg = "C:\\Users\\anjie.lv\\Desktop\\王华东的文件\\upload\\orgCode.rar";
			String pathLiense = "C:\\Users\\anjie.lv\\Desktop\\王华东的文件\\upload\\liense.rar";
			String pathOpen = "C:\\Users\\anjie.lv\\Desktop\\王华东的文件\\upload\\open.rar";
			File fileOrg = new File(pathOrg);
			File fileLiense = new File(pathLiense);
			File fileOpen = new File(pathOpen);
			Base64 b64 = new Base64();  
		    FileInputStream fisOrg = new FileInputStream(fileOrg);  
		    FileInputStream fisLiense = new FileInputStream(fileLiense);  
		    FileInputStream fisOpen = new FileInputStream(fileOpen);  
	  
		    byte[] bufferOrg = new byte[(int)fileOrg.length()];  
		    byte[] bufferLiense = new byte[(int)fileLiense.length()];  
		    byte[] bufferOpen = new byte[(int)fileOpen.length()];  
	 
		    fisOrg.read(bufferOrg);  
		    fisLiense.read(bufferLiense); 
		    fisOpen.read(bufferOpen); 

		    fisOrg.close();
		    fisLiense.close();
		    fisOpen.close();
		    
		    System.out.println(b64.encodeToString(bufferOrg)); 
		    System.out.println(b64.encodeToString(bufferLiense)); 
		    System.out.println(b64.encodeToString(bufferOpen)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
