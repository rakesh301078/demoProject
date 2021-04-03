package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;


public class AddCustomerTest extends TestBase {
	
	
	private static final String dataProvider = null;

	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode) throws Exception {
		//System.out.println("Add Customer Class");
		//Thread.sleep(3000);
		driver.findElement(By.cssSelector(OR.getProperty("addCustbtn"))).click();
	    driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "AddCustomerTest";
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
			
		}
				
		return data;
	}
	

}
