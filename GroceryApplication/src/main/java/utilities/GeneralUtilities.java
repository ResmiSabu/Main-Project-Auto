package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	WebDriver driver;
	
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollJavaScriptExecutorRightXAxis(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0)",""); 
	}
	
	public void scrollJavaScriptExecutorLeftXAxis(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-500,0)",""); 
	}
	
	public void scrollJavaScriptExecutorUpYAxis(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)",""); 
	}
	
	public void scrollJavaScriptExecutorDownYAxis(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)",""); 
	}
	
	public static void selectCheckBox(WebElement checkbox) {
		if(!checkbox.isSelected())
		{
			checkbox.click();
		}
	}
	
	public static void deselectCheckBox(WebElement checkbox) {
		if(checkbox.isSelected())
		{
			checkbox.click();
		}
	}
	
	public static void clickElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.click(element).perform();
	}
	
	public static void rightClickElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public static void doubleClickElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	public static void overOnElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}
}
