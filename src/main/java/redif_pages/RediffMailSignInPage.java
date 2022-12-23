package redif_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffMailSignInPage  {
	
	public WebDriver driver;
	
	// Object 
	@FindBy(css = "div.logtext")
	WebElement verifyMailPage;

	
	
	// Initialization constructor 
	public RediffMailSignInPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	// Action 
	
	public boolean mailPageVerification() {
		boolean mailPageis = verifyMailPage.isDisplayed();
		return mailPageis;
	}

}
