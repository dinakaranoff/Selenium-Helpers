package com.dina.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CofingManger {
	private static CofingManger config=null;
	private Properties props=new Properties();
	private String server=null;
	
	private void CofingManger(){
		String path=System.getProperty("user.home")+File.separator +"workspace"+File.separator+"Selenium"+File.separator+"src"+File.separator+"resource"+File.separator;
		InputStream stream=getClass().getClassLoader().getResourceAsStream(path+"qa.properties");
		try {
			props.load(stream);
		} catch (IOException e) {
			System.out.println("Not able to load qa.propperty file ");
			e.printStackTrace();
		}
		
	}
	public static CofingManger getConfig(){
		if(config==null){
			config =new CofingManger();
		}
		return config;
	}
	
	public String getServer(){
		return (String) props.get("server");
	}
	

}
