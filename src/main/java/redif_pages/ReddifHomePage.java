package redif_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReddifHomePage  {
	
	public WebDriver driver;
	
	// Object 
	@FindBy(css = "span.hmsprite.logo")
	private WebElement homepag;
	
	// Initialize 
	public ReddifHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// action 
	public boolean homePageTest() {
		return homepag.isDisplayed();
	}
}
