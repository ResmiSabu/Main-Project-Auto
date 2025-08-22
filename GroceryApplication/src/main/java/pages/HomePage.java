package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") WebElement managecategory;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement managenews;
	@FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement adminbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement logoutbutton;
	@FindBy(xpath = "//a[@class='small-box-footer']") WebElement adminusers;
	@FindBy(xpath = "//p[@class='login-box-msg']") WebElement Logoutsuccess;
	@FindBy(xpath = "//input[@placeholder = 'Username']") WebElement usernamefield;
	
	public CategoryPage clickOnManageCategory() {
		managecategory.click();	
		return new CategoryPage(driver);
	}	
	public ManageNewsPage clickOnManageNews() {
		managenews.click();
		return new ManageNewsPage(driver);
	}	
	public HomePage clickOnAdminButton() {
		adminbutton.click();
		return this;
	}
	public LoginPage clickOnLogoutButton() {
		logoutbutton.click();
		return new LoginPage(driver);
	}	
	public AdminUsersPage clickOnAdminUsers() {
		adminusers.click();
		return new AdminUsersPage(driver);
	}	
	public boolean isLogoutSuccess() {
		return usernamefield.isDisplayed();
	}		
}
