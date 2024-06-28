package com.mtm.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
//import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mtm.stepdefs.BaseClass;

//import com.base.BaseClass;
//import com.cpt.qa.util.Generic;
//import com.cpt.qa.util.TestUtil;
import com.google.common.base.Function;
//import com.ibm.reusable.utils.Constants;
//import com.ibm.reusable.utils.SuperTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Generic extends BaseClass  {
	/*******************************************************************************************************************************************************************************************************************
	   'Created By	    : Seemone Mejo		
	   'Created On		: June-2023				
	   'Last Updated By	: June-2023	
	   'Last Updated On	: June-2023	
	   'Purpose			: To create re-usability of methods
'**********************************************************************************************************************************************************/
	public static Duration ts=Duration.ofSeconds(120);
	
	

	/*public static void logManager(String className) {

		try {
			log = LogManager.getLogger(className);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}*/
	

	
/*	public static WebDriver launchBrowser () {
		String browserName = getBrowser();
		System.out.println(getBrowser());
         log.info(getBrowser());
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("chrome browser executed...");
				log.fatal("chrome browser executed...");

			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			//	log.fatal("firefox browser executed...");
			} else if (browserName.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			//	log.fatal("ie browser executed...");
			} else {
				System.out.println("Invlid Brwoser");
			}
			maximize();
			implicitlyWait(10);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			} 
		
		return driver;
	}*/


	
	/*public static void loadUrl() {
		String url = getUrl();
		log.info(getUrl());
		try {
			driver.get(url);
			pageLoadTime(15);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}*/
	public static WebElement locator(String locatorName, String data) {

		WebElement findElement = null;

		try {
			if (locatorName.equals("xpath")) {
				findElement = driver.findElement(By.xpath(data));
			} else if (locatorName.equals("id")) {
				findElement = driver.findElement(By.id(data));

			} else if (locatorName.equals("className")) {
				findElement = driver.findElement(By.className(data));
			} else if (locatorName.equals("Name")) {
				findElement = driver.findElement(By.name(data));
			} else if (locatorName.equals("linkText")) {
				findElement = driver.findElement(By.linkText(data));
			} else if (locatorName.equals("partialLinkText")) {
				findElement = driver.findElement(By.partialLinkText(data));
			} else if (locatorName.equals("tagName")) {
				findElement = driver.findElement(By.tagName(data));
			} else if (locatorName.equals("cssSelector")) {
				findElement = driver.findElement(By.cssSelector(data));
			}
			implicitlyWait(10);
			maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return findElement;

	}
	public static void maximize() {
		try {
			window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static Options manage() {
		Options option = null;
		try {
			option = driver.manage();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return option;
	}

	public static Timeouts timeouts() {
		Timeouts timeouts = null;
		try {
			timeouts = manage().timeouts();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return timeouts;
	}

	public static void pageLoadTime(int seconds) {
		try {
			forceSleep(1000);
			timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void implicitlyWait(int seconds) {
		try {
			timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Window window() {
		Window window = null;
		try {
			window = manage().window();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return window;
	}

	public static void deleteCookies() {
		try {
			manage().deleteAllCookies();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static List<WebElement> locators(String locatorName, String data) {
		List<WebElement> listOfElements = null;
		try {
			if (locatorName.equals("xpath")) {
				listOfElements = driver.findElements(By.xpath(data));
			} else if (locatorName.equals("id")) {
				listOfElements = driver.findElements(By.id(data));

			} else if (locatorName.equals("className")) {
				listOfElements = driver.findElements(By.className(data));
			} else if (locatorName.equals("Name")) {
				listOfElements = driver.findElements(By.name(data));
			} else if (locatorName.equals("linkText")) {
				listOfElements = driver.findElements(By.linkText(data));
			} else if (locatorName.equals("partialLinkText")) {
				listOfElements = driver.findElements(By.partialLinkText(data));
			} else if (locatorName.equals("tagName")) {
				listOfElements = driver.findElements(By.tagName(data));
			} else if (locatorName.equals("cssSelector")) {
				listOfElements = driver.findElements(By.cssSelector(data));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listOfElements;

	}public String getProperty() {
		String directory = null;

		try {
			directory = System.getProperty("user.dir");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return directory;
	}

	public static void dragAndDrob(WebElement src, WebElement target) {
		try {
			Actions ac;
			ac = new Actions(driver);
			ac.dragAndDrop(src, target).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void rightClick(WebElement target) {
		try {
			Actions ac;
			ac = new Actions(driver);
			ac.contextClick(target).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public  static void doubleClick(WebElement target) {
		try {
			Actions ac;
			ac = new Actions(driver);
			ac.doubleClick(target).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void mouseOver(WebElement target) {
		try {
			Actions ac;
			ac = new Actions(driver);
			ac.moveToElement(target).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void chooseOption(String selectOption, WebElement e, String data) {
		try {
			if (selectOption.equals("text")) {
				s = new Select(e);
				s.selectByVisibleText(data);
			} else if (selectOption.equals("value")) {
				s = new Select(e);
				s.selectByValue(data);
			} else {
				System.out.println("No select option");
			}

		} catch (Exception ex) {

		}

	}

	public static void chooseOptionIndex(WebElement e, int index) {
		try {
			s = new Select(e);
			s.selectByIndex(index);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void dontChosseOption(String notSelectOption, String text, int index, String value, WebElement e) {
		try {
			if (notSelectOption.equals("text")) {
				s = new Select(e);
				s.deselectByVisibleText(text);
			} else if (notSelectOption.equals("value")) {
				s = new Select(e);
				s.deselectByValue(value);

			} else if (notSelectOption.equals("index")) {
				s = new Select(e);
				s.deselectByIndex(index);
			} else {
				System.out.println("No select option");
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void deSelectOptionByAll(WebElement e) {
		try {
			s = new Select(e);
			s.deselectAll();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static List<WebElement> selectGetOption(WebElement e) {
		List<WebElement> li = null;
		try {
			s = new Select(e);
			li = s.getOptions();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return li;
	}

	public  static List<WebElement> selectGetAllOption(WebElement e) {
		List<WebElement> li = null;
		try {
			s = new Select(e);
			li = s.getAllSelectedOptions();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return li;

	}

	public static WebElement firstGetSelectOption(WebElement e) {
		WebElement selectFirst = null;
		try {
			s = new Select(e);
			selectFirst = s.getFirstSelectedOption();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return selectFirst;
	}

	public static boolean selectIsMultiple(WebElement e) {
		try {
			s = new Select(e);
			b = s.isMultiple();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return b;
	}

	public static TargetLocator switchToTargetElement() {
		TargetLocator locator = null;
		try {
			locator = driver.switchTo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return locator;
	}

	public static Alert alertSwitchToAlert() {
		Alert al = null;
		try {
			al = switchToTargetElement().alert();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return al;
	}

	public static void switchToFrameId(String data) {
		try {
			switchToTargetElement().frame(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void switchToFrameName(String data) {

		try {
			switchToTargetElement().frame(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void switchToFrameWebElement(WebElement e) {
		try {
			switchToTargetElement().frame(e);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void switchToFrameWebIndex(int index) {
		try {

			switchToTargetElement().frame(index);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void switchToFrameParentFrame() {
		try {
			switchToTargetElement().parentFrame();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	
	
	

	public static void switchToFrameDefaultContent() {
		try {
			switchToTargetElement().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void switchToSingleWindow() {
		// TODO Auto-generated method stub	
		try {
			String par = driver.getWindowHandle();
			Set<String> all = driver.getWindowHandles();
			for(String x:all){
				if(!par.equals(x)){
			 switchToTargetElement().window(x);
				}
				}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void switchToWindows(int intext) {
		// TODO Auto-generated method stub	
		try {
			Set<String> all =driver.getWindowHandles();
			 List<String> l= new LinkedList();
		     l.addAll(all);
		     switchToTargetElement().window(l.get(intext));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	
	

	public static void senkeyAlert(String data) {
		try {
			alertSwitchToAlert().sendKeys(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getTextAlert(String data) {
		try {
			data = alertSwitchToAlert().getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}


	public static byte[] takeScreenShots() throws CustomizedException  {
		try {

//	 		Dimension d = new 	Dimension (1526,967);
//   		driver.manage().window().setSize(d); 
				tk = (TakesScreenshot) driver;
				byte[] src = tk.getScreenshotAs(OutputType.BYTES);
				return src;
			} catch (Exception e) {
				// Handle the exception here
				e.printStackTrace(); // Print the stack trace (optional)
				return null; // or any other appropriate action
			}
		}
	

	// Selecting values from Drop-down list--Bootstrap dropdown-list
	public static String selectOptionFromDropDown(List<WebElement> options, String value) throws CustomizedException {
		try {
			for (WebElement option : options) {
				String obtained = option.getText().trim();
				if (obtained.equals(value)) {
					option.click();
					break;
				}
			}
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the list of Elements " + options);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Item is not listed in the listbox: " + value);
		}
		return value;
	}

	// **************************************************************************************************************************************************************************************************************/

	public static void closeBrowser() throws CustomizedException {
		try {
			driver.close();
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	// **********************************************************************************************************************************************************************************************************/

	public static void quitBrowser() throws CustomizedException {
		try {
			driver.quit();
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}

	}

	

	
	// ************************************************************************************************************************************************************************************************************************/
	public static void webEnter(WebElement ele, String strTextValue) throws CustomizedException, IOException {
		try {
			ele.clear();
			ele.sendKeys(strTextValue);
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Unable to enter the value: " + strTextValue);
		}
	}

	// ************************************************************************************************************************************************************************************************************************/
	public static void webClick(WebElement ele) throws CustomizedException {
		try {
			ele.click();
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Unable to click the element");
		}
	}

	public static void waitForPageLoaded() throws CustomizedException {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, ts);
			wait.until(expectation);
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	
	public static void waitForPageSpecificElement(WebElement element) throws CustomizedException {
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, ts);
		//	wait.until(expectation);
			
			//wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}
	
	
	

	public static void forceSleep(int timeInMilliSec) {
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void nullifyImplicitlyWait() {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}

	
	

	public static void waitForDOMLoad(final WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, ts);
			
		wait.withTimeout(Duration.ofSeconds(100)).pollingEvery(Duration.ofSeconds(2)).ignoring(StaleElementReferenceException.class);
		ExpectedCondition<Boolean> pageLoadCondition = new
		       ExpectedCondition<Boolean>() {
		           public Boolean apply(WebDriver dr) {
		           	return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		           }
		       };
		       wait.until(pageLoadCondition);
	 }
	public static boolean waitForElement1(WebDriver driver,final WebElement element) {
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(StaleElementReferenceException.class);
		try {
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>() {

				@Override
				public Boolean apply(WebElement ele) {
					if (!element.isDisplayed()) {
						return false;
					} else {
						return true;
					}

				}
			};
			return wait.until(fun);
		} catch (TimeoutException e) {
			return false;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			implicitlyWait(100);
		}

	}
	
	public static boolean waitForElement(final WebElement element) {
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(StaleElementReferenceException.class);
		try {
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>() {

				@Override
				public Boolean apply(WebElement ele) {
					if (!element.isDisplayed()) {
						return false;
					} else {
						return true;
					}

				}
			};
			return wait.until(fun);
		} catch (TimeoutException e) {
			return false;
		} catch (NoSuchElementException e) {
			return false;
		} finally {
			implicitlyWait(100);
		}
	}
	

	public static WebElement waitForElementSingle(WebDriver driver, final By locator) {
		nullifyImplicitlyWait();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofSeconds(2))
		.ignoring(StaleElementReferenceException.class);

		WebElement element = wait.until(new Function<WebDriver,WebElement>(){
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(locator);
			     }
			   });
			return element;
	}
	
	public static boolean waitForElement_List(final List<WebElement> element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>((WebElement) element);
		wait.withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofSeconds(2))
		.ignoring(StaleElementReferenceException.class);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{

						@Override
						public Boolean apply(WebElement ele) 
						{
							if(!((WebElement) element).isDisplayed()){
								return false;
							}
							else
							{
								return true;
							}
							
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e)
		{
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			implicitlyWait(100);		}
		
	}
	
	
	//Waitforlement for specific return type is WebElement
	public static WebElement waitForElementWithFluentWaitWebElement(final By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(120))
			       .pollingEvery(Duration.ofSeconds(2))
			       .ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(locator);
		     }
		 });
		return element;
	}
	
	

	
	/*
	 * public static boolean waitForElementVisible(WebDriver driver, WebElement
	 * element) {
	 * 
	 * try { WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	 * wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).
	 * ignoring(StaleElementReferenceException.class);
	 * wait.until(ExpectedConditions.visibilityOf(element));
	 * 
	 * }catch(TimeoutException t){ return false;
	 * 
	 * }catch(Exception e) {
	 * failATestCase("Exception occured while waiting for element to be visible."+e)
	 * ; } return false; }
	 * 
	 * 
	 * public static String waitForLoadingMessage(WebDriver driver){
	 * forceSleep(1000); String loadMsg = null; WebElement loadingElement; try {
	 * loadingElement = driver.findElement(By.className("loading-message"));
	 * if(loadingElement.isDisplayed()) { loadMsg = loadingElement.getText();
	 * Reporter.log("Loading message --> "+loadMsg,true); WebDriverWait wait = new
	 * WebDriverWait(driver, 30); wait.withTimeout(30,
	 * TimeUnit.SECONDS).pollingEvery(100,
	 * TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
	 * wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement
	 * (loadingElement, loadMsg))); waitForPageLoad(driver); }
	 * }catch(NoSuchElementException e) {
	 * Reporter.log("No loading message is displayed.1",true); }catch(Exception e) {
	 * Reporter.log("No loading message is displayed.2",true); } return loadMsg; }
	 * 
	 * public static void waitForElementToClick(WebDriver driver, WebElement
	 * element) { WebDriverWait wait = new WebDriverWait(driver, 10);
	 * wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(100,
	 * TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
	 * wait.until(ExpectedConditions.elementToBeClickable(element)); }
	 */
	public static void waitForElements_List(WebDriver driver, List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, ts);
		wait.withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public static void waitForElements(WebElement elements) {
		WebDriverWait wait = new WebDriverWait(driver, ts);
		wait.withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofSeconds(4))
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(elements));

	}

	public static boolean isDisplayed(WebElement ele) throws CustomizedException {
		boolean blnDisplayStatus = false;
		try {
			if (ele.isDisplayed()) {
				blnDisplayStatus = true;
			}
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Element is not displayed");
		}
		return blnDisplayStatus;
	}
	

	public static boolean isDisplayedList(List<WebElement> ele) throws CustomizedException {
		boolean blnDisplayStatus = false;
		try {
			if (((WebElement) ele).isDisplayed()) {
				blnDisplayStatus = true;
			}
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Element is not displayed");
		}
		return blnDisplayStatus;
	}

	public static boolean verifyTitle(String strPageTitle) throws CustomizedException {
		boolean bReturn = false;
		String actualTitle;
		try {
			actualTitle = getTitle();
			if (actualTitle.equals(strPageTitle)) {
				bReturn = true;
			} else {
				throw new CustomizedException("The expected page title " + "\"" + strPageTitle + "\""
						+ " Actual page title: " + "\"" + actualTitle + "\"" + " are not matched");
			}
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return bReturn;
	}

	public static String getTitle() throws CustomizedException {
		String sReturn = "";
		try {
			sReturn = driver.getTitle();
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Unable to get the title");
		}
		return sReturn;
	}

	public static void selectByVisibleText(WebElement ele, String strDropdownVisibleText) throws CustomizedException {
		try {
			Select selectDropDown = new Select(ele);
			selectDropDown.selectByVisibleText(strDropdownVisibleText);
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Item is not listed in the listbox: " + strDropdownVisibleText);
		}
	}

	// GetSize
	public static void getSize(String xpath) throws CustomizedException {
		try {

			List<WebElement> list = driver.findElements(By.xpath(xpath));
			int options = list.size();
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + xpath);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Item is not listed in the listbox: " + xpath);
		}
	}

	public static void selectIndexByName(WebElement ele, int dropDownIndex) throws CustomizedException {
		try {
			Select selectDropDown = new Select(ele);
			selectDropDown.selectByIndex(dropDownIndex);
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("Item is not listed in the listbox: " + dropDownIndex);
		}
	}

	public static void clickUsingJavaScriptExe(WebElement ele) throws CustomizedException {
		try {
			js.executeScript("arguments[0].click();", ele);
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException("unable to click the element");
		}
	}

	public static WebElement FindElementByID(String strlocatorId) throws CustomizedException {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.id(strlocatorId));
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return ele;
	}

	public static WebElement FindElementByName(String strlocatorName) throws CustomizedException {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.name(strlocatorName));
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return ele;
	}

	public static WebElement FindElementByClassName(String strlocatorClassName) throws CustomizedException {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.className(strlocatorClassName));
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return ele;
	}

	public static WebElement FindElementByLinkText(String strlocatorLinkText) throws CustomizedException {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.linkText(strlocatorLinkText));
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return ele;
	}

	public static WebElement FindElementByPartialLinkText(String strlocatorPartialLinkText) throws CustomizedException {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.partialLinkText(strlocatorPartialLinkText));
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return ele;
	}

	public static WebElement FindElementByTagname(String strlocatorTagName) throws CustomizedException {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.tagName(strlocatorTagName));
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return ele;
	}

	public static WebElement FindElementByCSS(String strlocatorCSS) throws CustomizedException {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.cssSelector(strlocatorCSS));
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return ele;
	}

	public static WebElement FindElementByXpath(String strlocatorXpath) throws CustomizedException {
		WebElement ele = null;
		try {
			ele = driver.findElement(By.xpath(strlocatorXpath));
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return ele;
	}

	public static String getCuttentTimeStamp() {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("Eyyyy.MM.dd'_'hh:mm:ssa");
		return ft.format(date).replaceAll(":", "_");
	}

	
	
	
	public static boolean verifyExpectedActualValue(String strExpectedValue, String strActualValue) {
		boolean blnStatus = false;

		if (strExpectedValue.contains(strActualValue)) {
			blnStatus = true;

		}
		return blnStatus;
	}

	public static void FileUploadRobotClass(String strFileName) throws AWTException {

		File file = new File(System.getProperty("user.dir") + strFileName);
		StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		// Cmd + Tab is needed since it launches a Java app and the browser looses focus
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);

		// Open Goto window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);

		// Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);

		// Press Enter key to close the Goto window and Upload window
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void mouseHoverPage() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(500);
		//highlightElement(facilities.facilities_lnk);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
	
	
	public static void srcollDownRobot() throws AWTException {
	Robot robot = new Robot();
	robot.delay(500);
	
	Generic.isElementPresnt(driver,"//div[@title='Facilities']", 120).click();
	
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.delay(500);
	
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	
	}
	
	public static void srcollRobotClearCachse() throws AWTException {
		Robot robot = new Robot();
		robot.delay(500);
		
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.delay(500);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(500);
		

		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.delay(500);
		
		//robot.keyPress(KeyEvent.VK_TAB);
		//robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
	
		
		}
	public static void srcollSubmitRequest() throws AWTException {
		Robot robot = new Robot();
		robot.delay(500);
		
		Generic.isElementPresnt(driver,"//span[@id='LatestNewText']", 120).click();
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(500);
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		}
	public static void srcollDownRobotZenefit() throws AWTException, InterruptedException {
		
		WebElement element = Generic.isElementPresnt(driver,"//div[@title='Human Resources']", 120);
		
		Robot robot = new Robot();
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.DOWN);
		act.perform();
		act.sendKeys(Keys.DOWN);
		act.perform();
		
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(500);
	
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(500);
	
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(500);
	}
	
		// Clinical Operations
		public static void srcollDownUsingRobotClicnicalOperaions() throws AWTException {
			// Thread.sleep(2000);
			WebElement element = Generic.isElementPresnt(driver, "//span[normalize-space()='Clinical Operations']",
					120);
			Actions act = new Actions(driver);
			act.moveToElement(element).click().build().perform();
			Robot robot = new Robot();
			Generic.isElementPresnt(driver, "//div[@title='Clinical Operations']", 120).click();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.delay(500);
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			act.sendKeys(Keys.PAGE_DOWN);
			act.perform();
			act.sendKeys(Keys.PAGE_DOWN);
			act.perform();
			act.sendKeys(Keys.PAGE_DOWN);
			act.perform();
			act.sendKeys(Keys.PAGE_DOWN);
			act.perform();
			act.sendKeys(Keys.PAGE_DOWN);
			act.perform();
			act.sendKeys(Keys.PAGE_DOWN);
			act.perform();
		}
	
	public static void srcollDownUsingRobotDigitalTransformation() throws AWTException, InterruptedException {
//		Thread.sleep(2000);
		Robot robot = new Robot();
//		WebElement element = Generic.isElementPresnt(driver, "//span[normalize-space()='Digital Transformation']", 60);
//		log.info("User click on the Digital Transformation link in menu"); 
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(element).click().build().perform();
//		Thread.sleep(4000);
//
//		Generic.isElementPresnt(driver, "//span[normalize-space()='Digital Transformation']", 60).click();
//		Thread.sleep(2000);
//		log.info("User click on the Digital Transformation link in page");
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.delay(500);
//
//		robot.delay(500);
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		
//		robot.delay(500);
//		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//		log.info("User is widnow scroll down ");
//		act.sendKeys(Keys.PAGE_DOWN);
//		act.perform();
//		act.sendKeys(Keys.PAGE_DOWN);
//		act.perform();
//		log.info("User is widnow scroll down using action");
//		act.sendKeys(Keys.PAGE_DOWN);
//		act.perform();
//		act.sendKeys(Keys.PAGE_DOWN);
//		act.perform();
//
//		act.sendKeys(Keys.PAGE_DOWN);
//		act.perform();
//		act.sendKeys(Keys.PAGE_DOWN);
//		act.perform();
//
//		act.sendKeys(Keys.PAGE_DOWN);
//		act.perform();
//		act.sendKeys(Keys.PAGE_DOWN);
//		act.perform();

//		Thread.sleep(2000);
		Thread.sleep(2000);
		Generic.isElementPresnt(driver, "//span[normalize-space()='Digital Transformation']", 60).click();
		Thread.sleep(2000);
		//log.info("User click on the Digital Transformation link in menu");

		// Generic.isElementPresnt(driver, "//div[@title='Clinical Operations']", 120).click();
		// Thread.sleep(2000);
//
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(500);

		robot.delay(500);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		//log.info("User is widnow scroll down using action");
		Actions act = new Actions(driver);

		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();

		Thread.sleep(2000);
	}
	
	public static void MovetoElementbyActionClass(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	
	public static void MovetoElementbyMultiple(WebElement ele, WebElement ele1) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).moveToElement(ele1).click().build().perform();

	}

	public static void switchToFrameById(String locatorId) throws CustomizedException {
		try {
			driver.switchTo().frame(locatorId);
		} catch (NoSuchFrameException e) {
			throw new CustomizedException("Frame not found with locator id '" + locatorId + "'");
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Element not found with id '" + locatorId + "'");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void switchToFrameByName(String locatorName) throws CustomizedException {
		try {
			driver.switchTo().frame(locatorName);
		} catch (NoSuchFrameException e) {
			throw new CustomizedException("Frame not found with locator name '" + locatorName + "'");
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Element not found with ClassName '" + locatorName + "'");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void switchToFrameByClassName(String locatorClassName) throws CustomizedException {
		try {
			driver.switchTo().frame(driver.findElement(By.className(locatorClassName)));
		} catch (NoSuchFrameException e) {
			throw new CustomizedException("Frame not found with locator ClassName '" + locatorClassName + "'");
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Element not found with ClassName '" + locatorClassName + "'");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}

	}

	public static void switchToFrameByTagName(String locatorTagName) throws CustomizedException {
		try {
			driver.switchTo().frame(driver.findElement(By.tagName(locatorTagName)));
		} catch (NoSuchFrameException e) {
			throw new CustomizedException("Frame not found with locator TagnName '" + locatorTagName + "'");
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Element not found with TagnName '" + locatorTagName + "'");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void switchToFrameByIndex(int frameIndex) throws CustomizedException {
		try {
			driver.switchTo().frame(frameIndex);
		} catch (NoSuchFrameException e) {
			throw new CustomizedException("Frame not found with locator index '" + frameIndex + "'");
		} catch (NoSuchElementException e) {
			throw new CustomizedException("Element not found with index '" + frameIndex + "'");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void switchToDefaultContent() throws CustomizedException {
		try {
			driver.switchTo().defaultContent();
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void acceptAlert() throws CustomizedException {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			throw new CustomizedException("No Alert found");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void dismissAlert() throws CustomizedException {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			throw new CustomizedException("No Alert found");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static String getURL() throws CustomizedException {
		String currentUrl = "";
		try {
			currentUrl = driver.getCurrentUrl();
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return currentUrl;
	}

	public static void navigatePage(String url) throws CustomizedException {
		try {
			driver.navigate().to(url);
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void MovetoChildWindow() throws CustomizedException {
		// Switch to new window opened
		try {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		} catch (NoSuchWindowException e) {
			throw new CustomizedException("No such window exists.");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void GetParentWindow() throws CustomizedException {
		// Store the current window handle
		try {
			 String windowHandle = driver.getWindowHandle();
		} catch (NoSuchWindowException e) {
			throw new CustomizedException("No such window exists.");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static void MovetoParentWindow() throws CustomizedException {
		// Store the current window handle
		try {
			String windowHandle = driver.getWindowHandle();
			driver.switchTo().window(windowHandle);
		} catch (NoSuchWindowException e) {
			throw new CustomizedException("No such window exists.");
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static String GetCurrentDateTime(String strDateFormat) throws CustomizedException {
		DateFormat dateFormat = null;
		Date date = null;

		try {
			dateFormat = new SimpleDateFormat(strDateFormat);
			date = new Date();

		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
		return (dateFormat.format(date));
	}

	public static void SelectFile(String strFileName) throws IOException, CustomizedException {
		String strFinalPath = null;
		try {
			String strPath = System.getProperty("user.dir");
			strFinalPath = strPath + "\\" + strFileName;
			Runtime.getRuntime().exec(strFinalPath);
		} catch (FileNotFoundException e) {
			throw new CustomizedException("File  " + strFileName + " not found  in the path " + strFinalPath);
		}

	}

	public static void RefreshPage() throws CustomizedException {
		try {
			driver.navigate().refresh();
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}
	}

	public static boolean ViewtoScrollBar() throws InterruptedException {
		boolean blnScrollStatus = true;

		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		try {
			scrollBarPresent.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			blnScrollStatus = false;
		}
		return blnScrollStatus;
	}


	
	public static boolean ScrollToElement(WebElement element) throws InterruptedException, CustomizedException {
		boolean blnScrollStatus = true;

		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		try {
			scrollBarPresent.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			blnScrollStatus = false;
			throw new CustomizedException(e.getMessage());
		}
		return blnScrollStatus;
	}

	public static boolean ViewtoScrollBarToTop() throws InterruptedException {
		boolean blnScrollStatus = true;

		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		try {
			scrollBarPresent.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		} catch (Exception e) {
			blnScrollStatus = false;
		}
		return blnScrollStatus;
	}

	public static boolean ViewtoScrollBarToBottom() throws InterruptedException {
		boolean blnScrollStatus = true;

		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		try {
			scrollBarPresent.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		} catch (Exception e) {
			blnScrollStatus = false;
		}
		return blnScrollStatus;
	}

	public static String getSessionStorageValue(String sessionStorageKey) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			String value = (String) js.executeScript("return window.sessionStorage.getItem(arguments[0]);",
					sessionStorageKey);
			return value;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String getLocalStorageValue(String localStorageKey) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			String value = (String) js.executeScript("return window.localStorage.getItem('arguments[0]');",
					localStorageKey);
			return value;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static void setSessionStorageValue(String sessionStorageKey, String sessionStorageValue)
			throws CustomizedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.sessionStorage.setItem('arguments[0]','arguments[1]');", sessionStorageKey,
					sessionStorageValue);
		} catch (Exception e) {
			throw new CustomizedException("Unable to set " + sessionStorageKey + " object in session storage");
		}
	}

	public static void setLocalStorageValue(String localStorageKey, String localStorageValue)
			throws CustomizedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.sessionStorage.setItem('arguments[0]','arguments[1]');", localStorageKey,
					localStorageValue);
		} catch (Exception e) {
			throw new CustomizedException("Unable to set " + localStorageKey + " object in local storage");
		}
	}

	public static void setElementText(WebElement element, String text) throws CustomizedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].innerHTML=arguments[1]", element, text);
		} catch (Exception e) {
			throw new CustomizedException("Unable to set test to an element");
		}
	}

	public String decodeBase64(String encodedString) {
		String decodedString = new String(Base64.getDecoder().decode(encodedString));
		return decodedString;
	}

	public static String encodeBase64(byte[] text) {
		String encodedString = new String(Base64.getEncoder().encodeToString(text));
		return encodedString;
	}

	public static void takeScreenshot(WebElement ele, String path) {
		TakesScreenshot ts = (TakesScreenshot) ele;
		File f = ts.getScreenshotAs(OutputType.FILE);
		try {
			File file = new File(path);
			if (file.exists()) {
				FileHandler.copy(f, new File(path));
			} else {
				file.getParentFile().mkdirs();
				FileHandler.copy(f, new File(path));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenshot(WebDriver driver, String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		try {
			File file = new File(path);
			if (file.exists()) {
				FileHandler.copy(f, new File(path));
			} else {
				file.getParentFile().mkdirs();
				FileHandler.copy(f, new File(path));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void highlightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].style.border='1px solid red';", ele);
		
		js.executeScript("arguments[0].setAttribute('style', 'color: blue; border: 2px solid Magenta;');", ele);
	}
	

	public static void hoverOnElement(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).pause(2000).build().perform();
	}

	public static void hoverOnElementAndClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).pause(2000).click().build().perform();
	}

	public static void hoverOnElement(WebElement ele, int x, int y) {
		Actions a = new Actions(driver);
		a.moveToElement(ele, x, y).pause(2000).build().perform();
	}

	public static void pressEnterSpaceBtn() {
		Robot robo;
		try {
			robo = new Robot();
			robo.keyPress(KeyEvent.VK_SPACE);
			robo.keyRelease(KeyEvent.VK_SPACE);

		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public static String getHexValue(WebElement ele, String attribute) {
		return Color.fromString(ele.getCssValue(attribute).split("\\)")[0] + ")").asHex();
	}

	public static String getCSSAttribute(WebElement ele, String attribute) {
		return ele.getCssValue(attribute);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	
	 public static WebElement isElementPresnt(WebDriver driver,String xpath,int time)
	 {
	 	 WebElement ele = null;
	  
	 	 for(int i=0;i<time;i++)
	 	 {
	 		 try
	 		 {
	 			 ele=driver.findElement(By.xpath(xpath));
	 			 String text = ele.getText();
	 			 //driver.navigate().back();
	 			 //Thread.sleep(2000);
	 			 //driver.navigate().forward();
	 			 break;
	 		 }
	 		 catch(Exception e)
	 		 {
	 			 try 
	 			 {
	 				 Thread.sleep(1000);
	 			 } 
	 			 catch (InterruptedException e1) 
	 			 {
	 				 System.out.println("Waiting for element to appear on DOM");
	 			 }
	 		}		  			  
	 	}
	 	return ele;			  
	  }
	 
	 
	 public static List<WebElement> isElementPresentLists(WebDriver driver,String xpath,int time)
	 {
	 	 List<WebElement> ele = null;
	  
	 	 for(int i=0;i<time;i++)
	 	 {
	 		 try
	 		 {
	 			 ele=driver.findElements(By.xpath(xpath));
	 			 
	 			 //driver.navigate().back();
	 			 //Thread.sleep(2000);
	 			 //driver.navigate().forward();
	 			 break;
	 		 }
	 		 catch(Exception e)
	 		 {
	 			 try 
	 			 {
	 				 Thread.sleep(1000);
	 			 } 
	 			 catch (InterruptedException e1) 
	 			 {
	 				 System.out.println("Waiting for element to appear on DOM");
	 			 }
	 		}		  			  
	 	}
	 	return ele;			  
	  }
	 
	 public static WebElement isElementPresntWait(WebDriver driver,WebElement element,int time)
	 {
	 	 WebElement ele=null;
	  
	 	 for(int i=0;i<time;i++)
	 	 {
	 		 try
	 		 {
	 			// ele=driver.findElement(By.xpath(xpath));
	 			 ele = driver.findElement(By(element));
	 			 String text = ele.getText();
	 			 //driver.navigate().back();
	 			 //Thread.sleep(2000);
	 			 //driver.navigate().forward();
	 			 break;
	 		 }
	 		 catch(Exception e)
	 		 {
	 			 try 
	 			 {
	 				 Thread.sleep(1000);
	 			 } 
	 			 catch (InterruptedException e1) 
	 			 {
	 				 System.out.println("Waiting for element to appear on DOM");
	 			 }
	 		}		  			  
	 	}
	 	return element;			  
	  }
	 
	 
	 
	 

	 private static By By(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	//To sendKeys
	 public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value)
	 {
		 WebDriverWait wait = new WebDriverWait(driver,ts);
			wait.until(ExpectedConditions.visibilityOf(element));
		 element.sendKeys(value);
	 }
	 
	 public static void sendKeysTextbox(String value,WebElement element) throws CustomizedException
	 {
		 try {
			 element.sendKeys(value);
			} catch (NoSuchElementException e) {
				throw new CustomizedException("Failed to find the Element " + element);
			} catch (WebDriverException e) {
				throw new CustomizedException("The browser is not available for unknown reason.");
			} catch (Exception e) {
				throw new CustomizedException("Unable to send the element");
			}
	 }
	 
	 
	 //To click on
	 public static void clickOn(WebDriver driver, WebElement element, int timeout)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, ts);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 element.click(); 
	 }
	 
	 
	 public static void waitForElementOne(WebElement element) {
		    FluentWait<WebDriver> wait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(120))
		            .pollingEvery(Duration.ofSeconds(2))
		            .ignoring(NoSuchElementException.class);

		    wait.until(ExpectedConditions.visibilityOf(element));
		}
	 
	 public static boolean waitForElementVisible(WebDriver driver, WebElement element)
		{
			
			try
			{
				WebDriverWait wait = new WebDriverWait(driver,ts);
				wait.withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(StaleElementReferenceException.class);
				wait.until(ExpectedConditions.visibilityOf(element));
				
			}catch(TimeoutException t){
				return false;
				
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return false;
		}
	 
	 
}
