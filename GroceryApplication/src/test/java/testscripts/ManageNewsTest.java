package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage home;
	ManageNewsPage news;	
	LoginPage login;
	
	@Test
	public void verifyUserIsAbleToAddNewNews() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();		
		news=home.clickOnManageNews().clickOnNewButton().enterNewsField().clickOnSaveButton();
			
		boolean newsadded=news.isNewsAddedSuccessMsgDisplayed();
		Assert.assertTrue(newsadded, Messages.ADDNEWSFAILED);
	}
		
	@Test
	public void verifyUserIsAbleToSearchNews() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();
		HomePage home = new HomePage(driver);
		ManageNewsPage news = new ManageNewsPage(driver);
		news=home.clickOnManageNews().clickOnNewsSearch().enterNewsTitle().clickOnSearchButton();
	
		boolean searchnews=news.isSearchFoundMsgDisplayed();
		Assert.assertTrue(searchnews, Messages.NEWSSEARCHFAILED);
	}   
	
	@Test
	public void verifyUserIsAbleToEditNews() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();		
		news=home.clickOnManageNews().clickOnEditButton().enterEditNewsTitle().clickOnUpdateButton();
		
		boolean editnews=news.isUpdateSuccessMsgDisplayed();
		Assert.assertTrue(editnews, Messages.NEWSUPDATEFAILED);			
	}
		
	@Test
	public void verifyUserIsAbleToDeleteNews() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();	
		news=home.clickOnManageNews().clickOnDeleteButton();		
	
		boolean deletenews=news.isDeleteSuccessMsgDisplayed();
		Assert.assertTrue(deletenews, Messages.NESDELETEFAILED);
	}  	
}
