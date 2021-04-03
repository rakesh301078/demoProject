package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		log.debug("Inside Login Test !!!");
		driver.findElement(By.cssSelector(OR.getProperty("bmlbtn"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustbtn"))),"Login is not successful");
		//driver.findElement(By.cssSelector(OR.getProperty("addCustbtn"))).click();
		log.debug("Login Test executed successfully !!!");	
		
	}//public void loginAsBankManager()

}//Class LoginTest
