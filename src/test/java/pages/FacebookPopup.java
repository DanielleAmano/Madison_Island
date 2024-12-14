package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPopup extends BasePage {

	@FindBy (css = "#email")
	private WebElement emailOrPhoneField;
	@FindBy (css = "#pass")
	private WebElement passwordField;

	//constructor
	public FacebookPopup(WebDriver driver) {
		super(driver);
	}


	//Methods
	public void fillConnectInfo(String emailOrPhone, String password) {
		fillText(emailOrPhoneField, emailOrPhone);
		fillText(passwordField, password);
	}

	//Validation
	public boolean isItFacebookPage() {
		String title = driver.findElement(By.cssSelector("#homelink")).getText();
		if (title.toLowerCase().equals("facebook")) {
			return true;
		}else {
			return false;
		}
	}

}
