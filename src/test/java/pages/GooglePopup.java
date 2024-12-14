package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePopup extends BasePage {

	@FindBy (css = "#identifierId")
	private WebElement emailOrPhoneField;

	//constructor
	public GooglePopup(WebDriver driver) {
		super(driver);
	}


	//Methods
	public void fillConnectInfo(String emailOrPhone) {
		fillText(emailOrPhoneField, emailOrPhone);
	}

	//Validation
	public boolean isItGooglePage() {
		String title = driver.findElement(By.cssSelector(".WHUyzc")).getText();
		if (title.toLowerCase().contains("google")) {
			return true;
		}else {
			return false;
		}
	}

}
