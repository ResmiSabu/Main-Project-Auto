package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {	
	LoginPage login;
	HomePage home;
			
		@Test
		public void verifyUserIsAbletoSuccessfullyLogout() throws IOException {			
			String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
			String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
			login=new LoginPage(driver);
			login.enterUsername(username).enterPassword(password);
			login.clickOnSignInButton();
			home = new HomePage(driver);
			home.clickOnAdminButton();
			login=home.clickOnLogoutButton();
			boolean logout=home.isLogoutSuccess();
			Assert.assertTrue(logout, Messages.LOGOUTERROR);			
		}

}
