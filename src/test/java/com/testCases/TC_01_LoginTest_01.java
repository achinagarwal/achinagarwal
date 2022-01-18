package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationPOM.LoginPage;

public class TC_01_LoginTest_01 extends BaseClass

{
	@Test
	public void loginTest() throws IOException
	
	{
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setpassword(password);
		lp.clickLogin();
		logger.info("Login Succesful");
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
		}	
		
	}
	

}
