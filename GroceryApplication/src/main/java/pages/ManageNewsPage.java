package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class ManageNewsPage {
	
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newbuttton;
	@FindBy(xpath = "//textarea[@id='news']") WebElement newsfield;
	@FindBy(xpath = "//button[@type='submit']") WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement newsaddedsuccessmsg;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement newssearch;
	@FindBy(xpath = "//input[@class='form-control']") WebElement newstitle;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchbutton;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchfound;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']") WebElement editbutton;
	@FindBy(xpath = "//textarea[@id='news']") WebElement edittextarea;
	@FindBy(xpath = "//button[@class='btn btn-danger']") WebElement editupdatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement updatesuccessmsg;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']") WebElement deletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement deletesuccessmsg;
	
	public ManageNewsPage clickOnNewButton() {
		newbuttton.click();
		return this;
	}
	public ManageNewsPage enterNewsField() {
		newsfield.sendKeys(Constant.addnews);
		return this;
	}
	public ManageNewsPage clickOnSaveButton() {
		savebutton.click();
		return this;
	}
	public boolean isNewsAddedSuccessMsgDisplayed() {
		return newsaddedsuccessmsg.isDisplayed();
	}
	public ManageNewsPage clickOnNewsSearch() {
		newssearch.click();
		return this;
	}
	public ManageNewsPage enterNewsTitle() {
		newstitle.sendKeys(Constant.searchnews);
		return this;
	}
	public ManageNewsPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}
	public boolean isSearchFoundMsgDisplayed() {
		return searchfound.isDisplayed();
	}
	public ManageNewsPage clickOnEditButton() {
		editbutton.click();
		return this;
	}
	public ManageNewsPage enterEditNewsTitle() {
		edittextarea.clear();
		edittextarea.sendKeys(Constant.editnews);
		return this;
	}
	public ManageNewsPage clickOnUpdateButton() {
		editupdatebutton.click();
		return this;
	}
	public boolean isUpdateSuccessMsgDisplayed() {
		return updatesuccessmsg.isDisplayed();
	}
	public ManageNewsPage clickOnDeleteButton() {
		deletebutton.click();
		driver.switchTo().alert().accept();
        return this;
	}
	public boolean isDeleteSuccessMsgDisplayed() {
		return deletesuccessmsg.isDisplayed();
	}
	
}
