package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constant;
import utilities.GeneralUtilities;

public class AdminUsersPage {
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newadminusersbutton;
	@FindBy(xpath = "//input[@id='username']") WebElement username;
	@FindBy(xpath = "//input[@id='password']") WebElement password;
	@FindBy(xpath = "//select[@id='user_type']") WebElement usertypedropdown;
	@FindBy(xpath = "//button[@name='Create']") WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertsuccess;
	
	public AdminUsersPage clickOnNewbutton() {
		newadminusersbutton.click();
		return this;
	}
		public AdminUsersPage enterUserNameOnUsernameField(String newuser) {
		username.sendKeys(newuser);
		return this;
	}
		public AdminUsersPage enterPasswordOnPasswordField(String newpass) {
		password.sendKeys(newpass);
		return this;
	}
		public AdminUsersPage clickOnUserTypeDropDown() {
		usertypedropdown.click();
		GeneralUtilities util=new GeneralUtilities();
	    util.selectDropdownWithValue(usertypedropdown, Constant.AdminUserType);
		return this;
	}
		public AdminUsersPage clickOnSaveButton() {
		savebutton.click();
		return this;
	}
		public boolean isUserCreatedtSuccess() {
		return alertsuccess.isDisplayed();
	}
}
