package redif_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffEmailLogoutPage {
	
	public WebDriver driver;
	
	// Initialize 
	public RediffEmailLogoutPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Obj
//	@FindBy(className ="signin")
//	private WebElement signInButton;
//	
//	@FindBy(id = "login1")
//	private WebElement userEmail;
//	
//	@FindBy(id = "password")
//	private WebElement password;
//	
//	@FindBy(name = "proceed")
//	private WebElement emailLoginButton;
//	
//	@FindBy(css = "span.rd_tp-rgt")
//	private WebElement verifyLogin;
//	
//	@FindBy(linkText = "SeleniumPanda")
//	private WebElement emailVerification;
//	
//	@FindBy(css = "div#div_login_error > b")
//	private WebElement loginError;
	
	@FindBy(className = "rd_logout")
	private WebElement logout;
	
	@FindBy(css = "div.panel > p")
	private WebElement verifyLogout;
	
	// action
//		public void clickOnSignIn() {
//			signInButton.click();
//		}
//		
//		public void enterUserEmail(String email) {
//			userEmail.sendKeys(email);
//		}
//		
//		public void enterPassword(String pasword) {
//			password.sendKeys(pasword);
//		}
//		
//		public void clickToLoginEmail() {
//			emailLoginButton.click();
//		}
//		
//		public boolean loginConfirmation() {
//			boolean loged = verifyLogin.isDisplayed();
//			return loged;
//		}
//		
//		public String emailID() {
//			String myEmail = emailVerification.getText();
//			return myEmail;
//		}
//		
//		public String emailErrorMessage() {
//			String  error = loginError.getText();
//			return error;
//		}
//		
//		public String logoutMessage() {
//			String log = logout.getText();
//			return log;
//		}
//		
		public void logoutEmail() {
			logout.click();
		}
		
		public String logoutEmailMessage() {
			String logoutMessage = verifyLogout.getText();
			return logoutMessage;
		}
		

}
