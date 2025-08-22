package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;
	LoginPage login;
	@Test
	public void verifyUserloginwithValidCredentials() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();
		boolean isHomepageload=login.isHomePageLoaded();
		Assert.assertTrue(isHomepageload,Messages.LOGINVALIDCREDENTIALERROR);
	}
	
	@Test
	public void verifyuserLoginwithValidUsernamewithInvalidpassword() throws IOException {
		String username=ExcelUtility.readStringData(1, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(1, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password).clickOnSignInButton();
		boolean password1=login.isAlertDisplayed();
		Assert.assertTrue(password1, Messages.LOGININVALIDCREDENTIALERROR);
	}

	@Test
	public void verifyUserLoginWithInvalidUsernameWithValidPassword() throws IOException {
		String username=ExcelUtility.readStringData(2, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(2, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password).clickOnSignInButton();
		boolean username1=login.isAlertDisplayed();
		Assert.assertTrue(username1, Messages.LOGININVALIDCREDENTIALERROR);
	}
	 
	@Test    
	public void verifyUserloginWithInvalidCredentials() throws IOException {
		String username=ExcelUtility.readStringData(3, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(3, 1, "loginpage"); 
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password).clickOnSignInButton();
		boolean isAlertDisplayed=login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Messages.LOGININVALIDCREDENTIALERROR);
		}
	  
	}
