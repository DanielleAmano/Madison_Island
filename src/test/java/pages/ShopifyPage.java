package pages;

import org.openqa.selenium.WebDriver;

public class ShopifyPage extends BasePage{

	//constructor
	public ShopifyPage(WebDriver driver) {
		super(driver);
	}

	//Validation
	public boolean isItShopifyPage() {
		waiting(1000);
		String title = driver.getTitle();
		System.out.println(title);
		if (title.toLowerCase().contains("Shopify")) {
			return true;
		}else {
			return false ;
		}//back to the main window is in the test itself
	}

} 
