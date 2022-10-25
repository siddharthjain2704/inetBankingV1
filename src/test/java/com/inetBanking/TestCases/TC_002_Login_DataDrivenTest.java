package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_002_Login_DataDrivenTest extends BaseClass
{

@Test
public void loginDDT(String user ,String pwd) throws InterruptedException 
{
	LoginPage loginpage = new LoginPage(driver);
	loginpage.login(user, pwd);
	
	Thread.sleep(3000);
	
	if(isAlertPresent()== true) {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("Login Failed");
	}
	else {
		Assert.assertTrue(true);
		logger.info("Login Passed");
		loginpage.logout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		
	}
}


public boolean isAlertPresent() {
	try
	{
	driver.switchTo().alert();
	return true;
	}
	catch(NoAlertPresentException e) {
		return false;
		
	}
}

@DataProvider(name = "LoginData")
String [][]getData() throws IOException
{
	String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetBanking\\TestData\\LoginFIle.xlsx";
	
	int rownum = XLUtils.getRowCount(path, "Sheet1");
	int cellnum = XLUtils.getCellCount(path, "Sheet1", 1);
	
	String loginData[][] = new String[rownum][cellnum];
	
	for(int i=1; i<=rownum;i++) {
		for(int j=0;j<cellnum;j++) {
			loginData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
		}
	}
	return loginData;
	
}
}
