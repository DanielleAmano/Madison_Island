package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends MenuPage {

	@FindBy (css = "")
	private WebElement name;
	
	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

}
