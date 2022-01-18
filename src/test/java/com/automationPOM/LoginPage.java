package com.automationPOM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(name="uid") 
	@CacheLookup
	WebElement txtUserName;
	
	
	  @FindBy(name="password")
	  @CacheLookup 
	  WebElement txtPassword;
	 
	
	//WebElement txtPassword = ldriver.findElement(By.name("password"));
	
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[contains(.,'Log out')]")
	WebElement logout;
	
	
	
	public void setUsername(String uname)
	{
		txtUserName.sendKeys(uname);
		
	}
	
	public void setpassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
		
	}
	
	public void clickLogin()
	{
		btnLogin.click();
		
	}
	
	public void clickLogut()
	
	{
		logout.click();
		
	}
	
	
	

}
