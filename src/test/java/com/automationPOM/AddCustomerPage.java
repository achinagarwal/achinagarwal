package com.automationPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public  AddCustomerPage(WebDriver rdriver)
	
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	@FindBy(xpath="//a[contains(.,'New Customer')]")
	WebElement addNewCust;
	
	@FindBy(name="name")
	WebElement custName;
	
	@FindBy(name="rad1")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement addr;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinno;
	
	@FindBy(name="telephoneno")
	WebElement telephoneno;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="Submit")
	WebElement Submit;
	


	public void clickAddCust()
	{
		addNewCust.click();
	}
	
	
	public void custName(String cname)
	
	{
		custName.sendKeys(cname);
		
	}
	
	public void custGender(String cgender)
	{
		gender.click();
		
	}
	
	public void custdob(String mm,String dd, String yyyy)
	{
		
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}
	
	public void custaddr(String caddr)
	{
		
		addr.sendKeys(caddr);
	}
	
	
	
	public void custcity(String ccity)
	{
		
		city.sendKeys(ccity);
	}
	
	public void custstate(String cstate)
	{
		
		state.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno)
	{
		
		pinno.sendKeys(cpinno);
	}
	
	public void custtelephoneno(String ctelephoneno)
	
	{
		
		telephoneno.sendKeys(ctelephoneno);
	}
	
	public void custemailid(String ctemailid)
	{
		
		emailid.sendKeys(ctemailid);
	}
	
	public void clickSubmit()
	
	{
		Submit.click();
		
	}
}	