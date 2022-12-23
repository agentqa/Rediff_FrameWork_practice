package com_qa_rediff_testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com_qa_rediff_base.TestBase;
import redif_pages.ReddifHomePage;

public class RediffHomeTests extends TestBase {
	
	public RediffHomeTests() throws IOException {
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
	public void verifyHomePage() {
		ReddifHomePage obj = new ReddifHomePage(driver);
		boolean homePageTest= obj.homePageTest();
		Assert.assertTrue(homePageTest,"Home page test failed");
		
	}
	

}
