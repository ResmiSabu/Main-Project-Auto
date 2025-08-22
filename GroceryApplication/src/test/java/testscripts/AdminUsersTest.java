package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.Fakerutility;

public class AdminUsersTest extends Base {
	HomePage home;
	AdminUsersPage admin;
	LoginPage login;
		
	@Test(groups = "smoke")
	public void addNewAdminUser() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();
		Fakerutility faker= new Fakerutility();
		String newuser=faker.username();
		String newpass=faker.password();
		admin=home.clickOnAdminUsers().clickOnNewbutton().enterUserNameOnUsernameField(newuser).enterPasswordOnPasswordField(newpass).clickOnUserTypeDropDown().clickOnSaveButton();
		
		boolean usercreatedsuccess=admin.isUserCreatedtSuccess();
		Assert.assertTrue(usercreatedsuccess, Messages.USERCREATIONFAILED); 
		}
	}
