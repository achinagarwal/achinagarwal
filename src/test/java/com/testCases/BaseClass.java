package com.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Utilities.ReadConfig;
import com.google.common.io.Files;



public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br) throws FileNotFoundException, IOException
	
	{
		
		if (br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
			driver = new ChromeDriver();
		}
		
		else if(br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.geico.driver",readconfig.getfirefoxpath());
			driver = new FirefoxDriver();
			
		}	
		
		else
		{
			System.out.println("Invalid Browser");
			
		}	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		logger = Logger.getLogger("eBanking");
		Properties props = new Properties();
		props.load(new FileInputStream("log4j.properties"));
		PropertyConfigurator.configure(props);
		//PropertyConfigurator.configure("log4j.propertes");
	}
	
	
	
	@AfterClass
	public void tearDown()
	
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		Files.copy(source, target);
		//Factor.copyFile(source, target);
		System.out.println("Test Case Failed and Screenshot taken");
	}
	
	public String randomString()
	
	{
		String randEmail = org.apache.commons.codec.binary.StringUtils.newStringUtf16Be(null);
	
		return randEmail;
	}

}

