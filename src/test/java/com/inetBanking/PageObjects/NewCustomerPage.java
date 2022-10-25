package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver ldriver;

	public NewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "New Customer")
	@CacheLookup
	WebElement CustLink;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement custName;

	@FindBy(how = How.XPATH, using = "//tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement gender;

	@FindBy(how = How.NAME, using = "dob")
	@CacheLookup
	WebElement DOB;

	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")
	@CacheLookup
	WebElement Address;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement city;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement state;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement pin;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement mobNo;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement email;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement pwd;

	@FindBy(how = How.XPATH, using = "//tbody/tr[14]/td[2]/input[1]")
	@CacheLookup
	WebElement submitButton;

	public void getCustDetails(String Name, String addrss, String cty, String stte, String pincode, String mobNumber) {

		gender.click();
		custName.sendKeys(Name);
		Address.sendKeys(addrss);
		city.sendKeys(cty);
		state.sendKeys(stte);
		pin.sendKeys(pincode);
		mobNo.sendKeys(mobNumber);

	}

	public void DateofBirth(String dd, String mm, String yyyy) {
		DOB.sendKeys(dd);
		DOB.sendKeys(mm);
		DOB.sendKeys(yyyy);
	}

	public void submit() {
		submitButton.click();
	}

	public void EmailId(String emal, String pswd) {
		email.sendKeys(emal);
		pwd.sendKeys(pswd);
	}

	public void customerCreationLink() {
		CustLink.click();

	}

}
