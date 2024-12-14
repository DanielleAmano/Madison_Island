package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends MenuPage{

	@FindBy (css = "#SingleOptionSelector-0")
	private WebElement sizeDD;
	@FindBy (css = "#SingleOptionSelector-1")
	private WebElement colorDD;
	@FindBy (css = "#SingleOptionSelector-0")
	private WebElement genderDD;
	@FindBy (css = "[name='add']")
	private WebElement addToCartBtn;
	@FindBy (css = ".return-link")
	private WebElement backtBtn;

	@FindBy (css = "#more-payment-options-link")
	private WebElement MorePaymentOptionsBtn;

	@FindBy (css = ".product-single__description")
	private WebElement description;
	//social media
	@FindBy (css = ".share-facebook")
	private WebElement shareOnFacebookBtn;
	@FindBy (css = ".btn.btn--small.btn--share.share-twitter")
	private WebElement tweetBtn;
	@FindBy (css = ".share-pinterest")
	private WebElement pinOnPintrestBtn;

	//constructor
	public ItemPage(WebDriver driver) {
		super(driver);
	}

	//Methods
	public void chooseSize(String value) {
		selectByValue(sizeDD, value);
		waiting(200);
	}

	public void chooseColor(String value) {
		selectByValue(colorDD, value);
		waiting(200);
	}

	public void chooseGender(String value) {
		selectByValue(genderDD, value);
		waiting(200);
	}
	
	public void addToCart() {
		click(addToCartBtn);
	}
 
	public void clickOnMorePaymentOptions() {
		click(MorePaymentOptionsBtn);
	}


	public void shareOnFacebook() {
		click(shareOnFacebookBtn);
	}


	public void tweet() {
		click(tweetBtn);
	}

	public void pinOnPintrest() {
		click(pinOnPintrestBtn);
	}

	public void back() {
		waiting(1000);
		click(backtBtn);
	}

	//Validation
	
//	public boolean checkTitle(String itemName) {
//		String title = driver.findElement(By.cssSelector(".product-single__title")).getText();
//		if (title.toLowerCase().equals	(itemName)) {
//			return true;
//		}else {
//			return false;
//		}
//	}
//
//	public boolean checkPrice(String itemPrice) { 
//		String price = driver.findElement(By.cssSelector(".price-item--regular")).getText();
//		System.out.println(price);
//		if (price.toLowerCase().equals(itemPrice)) {
//			return true;
//		}else { 
//			return false; 
//		}
//	}
//
//	public boolean checkDescription(String itemDesc) {
//		String desc = getText(description);
//		if (desc.toLowerCase().equals(itemDesc)) {
//			return true;
//		}else {
//			return false;
//		}
//
//	}

}
