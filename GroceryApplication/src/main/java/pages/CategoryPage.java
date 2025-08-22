package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constant;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;

public class CategoryPage {
	
	public WebDriver driver;
	FileUploadUtility file = new FileUploadUtility();
	GeneralUtilities util=new GeneralUtilities();
	
	public CategoryPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']") WebElement newbutton;
@FindBy(xpath = "//input[@class = 'form-control']") WebElement newcategoryfield;
@FindBy(xpath = "//li[@id = '134-selectable']") WebElement discount;
@FindBy(xpath = "//input[@id = 'main_img']") WebElement addimage;
@FindBy(xpath = "//button[@type = 'submit']") WebElement savebutton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement categoryaddedsuccessmsg;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement newsearchbutton;
@FindBy(xpath = "//input[@class='form-control']") WebElement category;
@FindBy(xpath = "//i[@class='fa fa-search']") WebElement searchbutton;
@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']") WebElement searchfound;
@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']") WebElement editcategorybutton;
@FindBy(xpath = "//input[@class='form-control']") WebElement editcategory;
@FindBy(xpath = "//button[@type='submit']") WebElement updatebutton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement categoryupdatesuccessmsg;
@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']") WebElement deletebutton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement categorydeletesuccessmsg;

public CategoryPage clickOnNewCategoryButton() {
	newbutton.click();
	return this;
}
public CategoryPage entercategory(String newcategorytoadd) {
	newcategoryfield.sendKeys(newcategorytoadd);
	return this;
}
public CategoryPage adddiscount() {
	discount.click();
	return this;
}
public CategoryPage fileupload() {
	file.fileuploadmethod(addimage, Constant.imagefile);
	return this;
}
public CategoryPage clickOnSaveButton() {
//	GeneralUtilities util=new GeneralUtilities();
//	util.clickJavaScriptExecutor(savebutton, driver);
	return this;
}
public boolean isCategoryAddedSuccessMsgDisplayed() {
	return categoryaddedsuccessmsg.isDisplayed();
}
public CategoryPage clickOnNewSearchButton() {
	newsearchbutton.click();
	return this;
}
public CategoryPage entersearchCategory() {
	category.sendKeys(Constant.categorysearchname);
	return this;
}
public CategoryPage clickOnSearchButton() {
	searchbutton.click();
	return this;
}
public boolean isSearchFound() {
	return searchfound.isDisplayed();
}
public CategoryPage clickOnEditbutton() {
	editcategorybutton.click();
	return this;
}
public CategoryPage updateeditcategory() {
	editcategory.clear();
	editcategory.sendKeys(Constant.categoryedit);
	return this;
}
public CategoryPage clickOnUpdate() {
//	GeneralUtilities util=new GeneralUtilities();
//	util.clickJavaScriptExecutor(updatebutton, driver);
	return this;
}
public boolean isCategoryUpdatedSuccessfully() {
	return categoryupdatesuccessmsg.isDisplayed();
}
public CategoryPage clickOnDeleteButton() {
	deletebutton.click();
	driver.switchTo().alert().accept();
    return this;
}
public boolean isCategoryDeletedSuccessfully() {
	return categorydeletesuccessmsg.isDisplayed();
}
}
