package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	
	Properties prop;
	FileInputStream file;
	
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();
	@BeforeMethod
	@Parameters("browser")
	
	public void initializebrowser(String browser) throws Exception {
		prop = new Properties();
		file = new FileInputStream(Constant.Configfile);
		prop.load(file);
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else throw new Exception("Invalid Browser");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		wait.SetImplicitWait(driver);
	}
	
	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE)
	{
	ScreenshotUtility screenShot=new ScreenshotUtility();
	screenShot.getScreenshot(driver, iTestResult.getName());
	}
//	driver.quit();

	}
	
}
