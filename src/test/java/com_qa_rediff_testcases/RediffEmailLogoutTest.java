package com_qa_rediff_testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_qa_rediff_base.TestBase;
import redif_pages.RediffEmailLogoutPage;

public class RediffEmailLogoutTest extends TestBase {

	public RediffEmailLogoutTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void startUp() {
		browserInitialization();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void emailLogout() throws IOException {
		RediffMailSignInTest obj = new RediffMailSignInTest();
		obj.loginInWithCorrectCredintial();
		
		RediffEmailLogoutPage ob = new RediffEmailLogoutPage(driver);
//		ob.clickOnSignIn();
//		ob.enterUserEmail(testdata.getProperty("validEmail"));
//		ob.enterPassword(testdata.getProperty("validPassword"));
//		ob.clickToLoginEmail();
//		implicitTimeWait(10);
//		pageLoadTimeWait(10);
//		Assert.assertTrue(ob.loginConfirmation());
//		Assert.assertTrue(ob.emailID().contains("SeleniumPanda"),"Test failed");
		ob.logoutEmail();
		Assert.assertEquals(ob.logoutEmailMessage(), testdata.getProperty("logoutMessage"),"Test failed");
		
		
//		driver.findElement(By.className("signin")).click();
//		driver.findElement(By.id("login1")).sendKeys(testdata.getProperty("validEmail"));
//		driver.findElement(By.id("password")).sendKeys(testdata.getProperty("validPassword"));
//		driver.findElement(By.name("proceed")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	
//		boolean loginHi = driver.findElement(By.cssSelector("span.rd_tp-rgt")).isDisplayed();
//		Assert.assertTrue(loginHi);
		
//		String emailName = driver.findElement(By.linkText("SeleniumPanda")).getText();
//		Assert.assertTrue(emailName.contains("SeleniumPanda"), "Test Passed ");
//		
//		driver.findElement(By.className("rd_logout")).click();
//		String logoutMessage = driver.findElement(By.cssSelector("div.panel > p")).getText();
//		Assert.assertEquals(logoutMessage, testdata.getProperty("logoutMessage"), "Test failed");
	}

}
