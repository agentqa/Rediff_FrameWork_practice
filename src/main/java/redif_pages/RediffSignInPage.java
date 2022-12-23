package redif_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffSignInPage {
	
	public WebDriver driver;

	//Obj
	@FindBy(className ="signin")
	private WebElement signInButton;
	
	@FindBy(id = "login1")
	private WebElement userEmail;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(name = "proceed")
	private WebElement emailLoginButton;
	
	@FindBy(css = "span.rd_tp-rgt")
	private WebElement verifyLogin;
	
	@FindBy(linkText = "SeleniumPanda")
	private WebElement emailVerification;
	
	@FindBy(css = "div#div_login_error > b")
	private WebElement loginError;
	
	
	
	//Inilialize 
	public RediffSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// action
	public void clickOnSignIn() {
		signInButton.click();
	}
	
	public void enterUserEmail(String email) {
		userEmail.sendKeys(email);
	}
	
	public void enterPassword(String pasword) {
		password.sendKeys(pasword);
	}
	
	public void clickToLoginEmail() {
		emailLoginButton.click();
	}
	
	public boolean loginConfirmation() {
		boolean loged = verifyLogin.isDisplayed();
		return loged;
	}
	
	public String emailID() {
		String myEmail = emailVerification.getText();
		return myEmail;
	}
	
	public String emailErrorMessage() {
		String  error = loginError.getText();
		return error;
	}
	

}
