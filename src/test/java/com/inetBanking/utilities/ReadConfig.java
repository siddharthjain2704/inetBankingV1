package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src = new File ("./Configuration_Files/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e ) {
			System.out.println("Exception is " + e.getMessage());
		}
	
	}

	public String getApplicationURL() {
		String url = pro.getProperty("URL");
		return url;
		
	}
	
	public String getUsername() {
		String user = pro.getProperty("username");
		return user;
		
	}
	
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
		
	}
}
