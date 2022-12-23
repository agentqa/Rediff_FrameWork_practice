package com_qa_rediff_testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com_qa_rediff_base.TestBase;
import redif_pages.RediffSignInPage;

public class RediffMailSignInTest extends TestBase{
	
	public RediffMailSignInTest() throws IOException {
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

	@Test(priority = 1)
	public void loginInWithCorrectCredintial() throws IOException  {
		RediffSignInPage ob = new RediffSignInPage(driver);
		ob.clickOnSignIn();
		ob.enterUserEmail(testdata.getProperty("validEmail"));
		ob.enterPassword(testdata.getProperty("validPassword"));
		ob.clickToLoginEmail();
		implicitTimeWait(10);
		pageLoadTimeWait(10);
		Assert.assertTrue(ob.loginConfirmation());
		Assert.assertTrue(ob.emailID().contains("SeleniumPanda"), "Test failed");
		

	
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
	}

	@Test(priority = 2)
	public void loginInvalidEmailWithValidPassword() {
		RediffSignInPage ob = new RediffSignInPage(driver);
		ob.clickOnSignIn();
		ob.enterUserEmail(testdata.getProperty("inValidEmail"));
		ob.enterPassword(testdata.getProperty("validPassword"));
		ob.clickToLoginEmail();
		implicitTimeWait(10);
		pageLoadTimeWait(10);
		try {
			Assert.assertTrue(ob.emailErrorMessage().contains(testdata.getProperty("errorMessage1")),"Test failed");
		} catch (Exception e) {
			System.out.println(e+" First error message failed.");
			try {
				Assert.assertTrue(ob.emailErrorMessage().contains(testdata.getProperty("errorMessage2")),"Test failed");
			} catch (Exception e2) {
				System.out.println(e2 +" Second error message failed.");
			}
		}
		
//		driver.findElement(By.className("signin")).click();
//		driver.findElement(By.id("login1")).sendKeys(testdata.getProperty("inValidEmail"));
//		driver.findElement(By.id("password")).sendKeys(testdata.getProperty("validPassword"));
//		driver.findElement(By.name("proceed")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		String errorMessage = "";
//		try {
//			errorMessage = driver.findElement(By.cssSelector("div#div_login_error > b")).getText();
//			Assert.assertTrue(errorMessage.contains(testdata.getProperty("errorMessage1")), "Test Passed ");
//		} catch (Exception e) {
//			System.out.println(e + "First trial");
//			try {
//				Assert.assertTrue(errorMessage.contains(testdata.getProperty("errorMessage2")),
//						"Test Passed ");
//			} catch (Exception b) {
//				System.out.println(b + "Second trial");
//			}
//		}

	}
	
	@Test(priority = 3)
	public void loginValidEmailWithInvalidPassword() {
		RediffSignInPage ob = new RediffSignInPage(driver);
		ob.clickOnSignIn();
		ob.enterUserEmail(testdata.getProperty("validEmail"));
		ob.enterPassword(testdata.getProperty("inValidPassword"));
		ob.clickToLoginEmail();
		implicitTimeWait(10);
		pageLoadTimeWait(10);
		try {
			Assert.assertTrue(ob.emailErrorMessage().contains(testdata.getProperty("errorMessage1")),"Test failed");
		} catch (Exception e) {
			System.out.println(e+" First error message failed.");
			try {
				Assert.assertTrue(ob.emailErrorMessage().contains(testdata.getProperty("errorMessage2")),"Test failed");
			} catch (Exception e2) {
				System.out.println(e2 +" Second error message failed.");
			}
		}
		
		
		
//		driver.findElement(By.className("signin")).click();
//		driver.findElement(By.id("login1")).sendKeys(testdata.getProperty("validEmail"));
//		driver.findElement(By.id("password")).sendKeys(testdata.getProperty("inValidPassword"));
//		driver.findElement(By.name("proceed")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		String errorMessage = "";
//		try {
//			errorMessage = driver.findElement(By.cssSelector("div#div_login_error > b")).getText();
//			Assert.assertTrue(errorMessage.contains(testdata.getProperty("errorMessage1")), "Test Passed ");
//		} catch (Exception e) {
//			System.out.println(e + "First error message failed");
//			try {
//				Assert.assertTrue(errorMessage.contains(testdata.getProperty("errorMessage2")),
//						"Test Passed ");
//			} catch (Exception b) {
//				System.out.println(b + "Second error message failed");
//			}
//		}

	}

	@Test(priority = 4)
	public void loginWithNoInput() {
		RediffSignInPage ob = new RediffSignInPage(driver);
		ob.clickOnSignIn();
		ob.clickToLoginEmail();
		Assert.assertEquals(getAlertText(), testdata.get("alertMessage"),"Test failed");
		acceptAlert();
		
//		driver.findElement(By.className("signin")).click();
//		driver.findElement(By.name("proceed")).click();
//		String alertMessage = driver.switchTo().alert().getText();
//		Assert.assertEquals(alertMessage, testdata.get("alertMessage"), "Test failed");
//		driver.switchTo().alert().accept();
	}
}
