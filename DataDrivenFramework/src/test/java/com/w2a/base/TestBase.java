package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

public class TestBase {
	
//	webdriver
//	properties
//	logs -- log 4j.jar, .log files, log4j properties, Logger class
//	extendreport
//	db
//	excel 
//	mail

	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoylogger"); 
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	
	
@BeforeSuite
	public void setUp()
	{
	
		if (driver == null) {
			//FileInputStream fis;
			
			System.out.println("driver == null");
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				config.load(fis);
				log.debug("Config file loaded.....");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				OR.load(fis);
				log.debug("OR file loaded.....");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		if (config.getProperty("browser").equals("firefox")) {
			
			//driver.
		}

		 else if (config.getProperty("browser").equals("chrome")) {
			 System.out.println("Hi>>>"+System.getProperty("user.dir"));
			
             System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
             //\\src\\test\\resources\\executables\\
             
             driver = new ChromeDriver();
             
             log.debug("Chrome launched !!!");
		}
		else if (config.getProperty("browser").equals("IE")) {
		    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		}
		
		
		driver.get(config.getProperty("testsiteurl"));
		 log.debug("Chrome launched !!!"+config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicite.wait")), TimeUnit.SECONDS);
		}//if (driver == null)
}//public void setUp()
		
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e){
			
			return false;
        }		
	}
	
	
@AfterSuite
	public void tearDown()
	{
		/*if (driver != null) {
			driver.quit();
		
	}//public void tearDown()*/
		
	//log.debug("Login Test Competed successfully !!!");
	
	

}
}


