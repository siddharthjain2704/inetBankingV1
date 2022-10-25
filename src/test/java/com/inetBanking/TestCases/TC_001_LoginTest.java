package com.inetBanking.TestCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

public class TC_001_LoginTest extends BaseClass {

	@Test
	public void login() throws IOException {
		LoginPage lg = new LoginPage(driver);
		lg.login(user, pass);
		String title = driver.getTitle();
		System.out.println(title);
		

		if (driver.getTitle().equalsIgnoreCase(title)) {
			Assert.assertTrue(true);
			logger.info("Login TestCase Passed");
		}

		else {
			captureScreen(driver , "login");
			Assert.assertTrue(false);
			logger.info("Login TestCase Failed");
			
		}

	}

	

}
