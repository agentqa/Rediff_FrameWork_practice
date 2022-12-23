package com_qa_rediff_testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_qa_rediff_base.TestBase;
import redif_pages.RediffMailSignInPage;
import redif_pages.RediffSignInPage;

public class RediffSignInTest extends TestBase{
	
	public RediffSignInTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@BeforeMethod
	public void startUp() {
		browserInitialization();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test()
	public void clickOnSignInLink() {
		RediffSignInPage ob = new RediffSignInPage(driver);
		ob.clickOnSignIn();
		
		RediffMailSignInPage obj= new RediffMailSignInPage(driver);
		Assert.assertTrue(obj.mailPageVerification());
		
//		driver.findElement(By.className("signin")).click();
//		boolean singPage = driver.findElement(By.className("logtext")).isDisplayed();
//		Assert.assertTrue(singPage);
//		
	}
	
	
	
	

}
