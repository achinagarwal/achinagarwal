package com.testCases;

import java.io.IOException;


import org.testng.annotations.Test;

import com.automationPOM.AddCustomerPage;
import com.automationPOM.LoginPage;

import junit.framework.Assert;

public class TC03_AddCustomerTest extends BaseClass{

	@Test
	public void addCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setpassword(password);
		lp.clickLogin();
		
		Thread.sleep(2000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddCust();
		addcust.custName("Achin");
		addcust.custdob("01","01","1987");
		addcust.custGender("male");
		addcust.custcity("Noida");
		addcust.custpinno("201301");
		addcust.custaddr("Noida Extn");
		addcust.custstate("UP");
		addcust.custtelephoneno("4233231123");
		
		String email = randomString()+"gmail.com";
		addcust.custemailid(email);
		addcust.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean bln=driver.getPageSource().contains("Customer Registered Succesfully");
		
		if(bln==true)
			
		{
			
			Assert.assertTrue(true);
		}
		
		else
		{
			
			Assert.assertTrue(false);
			captureScreen(driver,"AddCustScreen");
		}	
		
	}
	
	
	
}
