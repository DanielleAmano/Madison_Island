package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	//global
	WebDriver driver;
	WebDriverWait wait; 
	String mainWindow;
	JavascriptExecutor js; 


	//Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		js = (JavascriptExecutor)driver; 
	}  

	//Methods
	public void fillText(WebElement el, String text) {
		highlightElement(el, "yellow", "yellow");
		el.clear();
		el.sendKeys(text);
	}


	public void click(WebElement el) {
		waiting(200);
		highlightElement(el, "yellow", "yellow");
		el.click();
	} 

	public void moveToNewWindow() {
		mainWindow = driver.getWindowHandle();  //the name of the current page
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);//will go one by one until he'll reach the last one
		}
	}

	public void backToMainWindow() {
		driver.close(); 	//close the new window tab
		driver.switchTo().window(mainWindow); 	//moves the driver to the main

	}
	
	public void selectByValue(WebElement el, String value) { //we can do another Method "by Text"
		highlightElement(el, "yellow", "yellow");
		Select s = new Select(el);
		s.selectByValue(value);
	}

	public void waitForElemenatToBeVisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el)); 
	}// usually with loader circle * wait until it shows up- wait until it disappear

	public void waitForElemenatToBeclickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el)); 
	}// usually with loader circle * wait until it shows up- wait until it disappear

	
	public String getText(WebElement el) {
		highlightElement(el, "orange", "orange");
		return el.getText();
	}
	
	public String getAttribute(WebElement el) {
		highlightElement(el, "orange", "orange");
		return getAttribute(el);
	}

	public void waiting(long milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void navigateBack() {
		driver.navigate().back();
	}
	
	private void highlightElement(WebElement element, String color, String backgroundColor) { //only to the Methods in this page
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:" + backgroundColor+ "; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few milliseconds (click affect)
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);
		//hold to see the actions
		waiting(300);
	}
 


}
