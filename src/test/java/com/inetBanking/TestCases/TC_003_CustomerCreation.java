package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.NewCustomerPage;

public class TC_003_CustomerCreation extends BaseClass {

	@Test
	public void CustomerCreationTest() throws IOException, InterruptedException {
		LoginPage lg = new LoginPage(driver);
		NewCustomerPage cust = new NewCustomerPage(driver);

		lg.login(user, pass);
		cust.customerCreationLink();
		Thread.sleep(3000);
		cust.getCustDetails("Siddharth", "Patera", "Patera", "MP", "323456", "9888776556");
		cust.DateofBirth("27", "04", "1997");
		String emailId = generateRandomEmail() + "@gmail.com";
		logger.info("Email Id generated is " + emailId);
		cust.EmailId(emailId, "hu876h");
		cust.submit();
		Thread.sleep(6000);

		Boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Customer Created Successfully");
		} else {
			captureScreen(driver, "CustomerCreationTest");
			Assert.assertTrue(false);
			logger.warn("Customer Not Created");
		}
	}

}
