package testscripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Messages;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.Fakerutility;

public class CategoryTest extends Base {
	HomePage home;
	CategoryPage category;
	LoginPage login;
			
	@Test(groups = "smoke")
	public void addNewCategoryWithValidDetails() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();
		Fakerutility faker=new Fakerutility(); 
		String newcategorytoadd=faker.newcategoryfood();
		category=home.clickOnManageCategory().clickOnNewCategoryButton().entercategory(newcategorytoadd).adddiscount().fileupload();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement savebutton=driver.findElement(By.xpath("//button[@type = 'submit']"));
		js.executeScript("arguments[0].click();", savebutton); 

		boolean productadded=category.isCategoryAddedSuccessMsgDisplayed();
		Assert.assertTrue(productadded, Messages.PRODUCTADDFAILED);
	}	
	
	@Test
	public void verifyUserIsAbleToSearchCategory() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();	
		HomePage home=new HomePage(driver);
		CategoryPage category = new CategoryPage(driver);
        category=home.clickOnManageCategory().clickOnNewSearchButton().entersearchCategory().clickOnSearchButton();
				
		boolean issearchfound=category.isSearchFound();
		Assert.assertTrue(issearchfound,Messages.PRODUCTSEARCHFAILED);
	}
	
	@Test
	public void verifyUserIsAbleToEditCategory() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();	
		category=home.clickOnManageCategory().clickOnEditbutton().updateeditcategory();
				
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement updatebutton=driver.findElement(By.xpath("//button[@type='submit']"));
    	js.executeScript("arguments[0].click();", updatebutton);
			
		boolean productupdated=category.isCategoryUpdatedSuccessfully();
		Assert.assertTrue(productupdated, Messages.EDITPRODUCTFAILED);		
		}
		
	@Test
	public void verifyUserIsAbleToDeleteCategory() throws IOException {
		String username=ExcelUtility.readStringData(0, 0, "loginpage"); 
		String password=ExcelUtility.readStringData(0, 1, "loginpage"); 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username).enterPassword(password);
		home=login.clickOnSignInButton();
		category=home.clickOnManageCategory().clickOnDeleteButton();	
		
		boolean productdeleted=category.isCategoryDeletedSuccessfully();
		Assert.assertTrue(productdeleted, Messages.DELETEPRODUCTFAILED);		
	}
	}
