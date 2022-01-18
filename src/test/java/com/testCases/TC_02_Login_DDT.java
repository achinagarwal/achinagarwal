package com.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utilities.XLUtils;
import com.automationPOM.LoginPage;

import junit.framework.Assert;

public class TC_02_Login_DDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public  void loginDDT(String user,String pwd)
	
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(user);
		lp.setpassword(pwd);
		lp.clickLogin();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		
		else
		{
			Assert.assertTrue(true);
			lp.clickLogut();
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();			
			
		}	
		
	}
	
	
	public boolean isAlertPresent() // user defined method which checks if alerts is present or not
	
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}catch(Exception e)
		{
			return false;
			
		}
		
		
	}
	
	
	@DataProvider(name="LoginData")
	String [] [] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/testData/LoginData.xlsx";
		
		int rownum= XLUtils.getRowCount(path, "Sheet1");
		int cocnt=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String[rownum][cocnt]; 
	
		for(int i=1;i<=rownum;i++)	
		{
			for(int j=0;j<cocnt;j++)	
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //i=1,j=0	
			}
		}
		return logindata;
		
		
	}
}
