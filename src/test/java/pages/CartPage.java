package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends MenuPage {

	@FindBy (css = "[class*='cart__continue']")
	private WebElement continueShoppingBtn;
	@FindBy (css = "[value='Update']")
	private WebElement updateBtn;
	@FindBy (css = ".cart__submit-controls :nth-child(3)")
	private WebElement checkoutBtn;
	@FindBy (css = ".cart__qty-input")
	private WebElement quantityField; 
	@FindBy (css = ".cart__row.border-bottom")
	private List<WebElement> itemAreaList; 
//	@FindBy (css = ".list-view-item__title")
//	private List<WebElement> itemTitleList; 

	//empty cart
	@FindBy (css = ".cart--empty-message")
	private WebElement cartMsg; 

	//cart error
	@FindBy (css = ".status-error")
	private WebElement cartError; 


	//constructor
	public CartPage(WebDriver driver) {
		super(driver);
	}

	//Methods
	public void removeProduct(String itemName) { //need to check 
		//	List<WebElement> areaList = driver.findElements(By.cssSelector(".cart__row.border-bottom"));
		for (WebElement area : itemAreaList) {
			String title = area.findElement(By.cssSelector(".list-view-item__title")).getText();
			if (title.toLowerCase().equals(itemName)) {
				WebElement removeBtn = area.findElement(By.cssSelector("[class*='cart__remove']"));
				click(removeBtn);
				break;
			}
		}
	}

	public void goToItem(String itemName) {
		//List<WebElement> areaList = driver.findElements(By.cssSelector(".cart__row.border-bottom"));
		for (WebElement area : itemAreaList) {
			WebElement title = area.findElement(By.cssSelector(".list-view-item__title"));
			if (getText(title).toLowerCase().equals(itemName)) {
				click(title);
				break;
			}
		} 
	} 

	public void changeItemQuantity(String itemName, String number) {
		//	List<WebElement> areaList = driver.findElements(By.cssSelector(".cart__row.border-bottom"));
		for (WebElement area : itemAreaList) {
			WebElement title = area.findElement(By.cssSelector(".list-view-item__title"));
			if (getText(title).toLowerCase().equals(itemName)) {
				fillText(quantityField, number);
				click(updateBtn);
				break;
			}
		} 
	} 

	public void continueShopping() { 
		waiting(500);
		click(continueShoppingBtn);
	}

	public void update() {
		click(updateBtn);
	}

	public void checkout() {
		click(checkoutBtn);
	}


	//Validation

	public boolean isCartEmpty() {
		if (getText(cartMsg).toLowerCase().equals("your cart is currently empty.")) {
			return true;
		}else {
			return false;
		}
	}

	public boolean isUpdateSucceded() {
		String title = driver.findElement(By.cssSelector("h1")).getText();
		if (title.toLowerCase().equals("your cart")) {
			return true;
		} else {
			return false;
		}
	}
 

	public boolean isIteminTheCart(String itemName) {
		List<WebElement> list = driver.findElements(By.cssSelector(".list-view-item__title"));
		for (WebElement el :  list) {
			String title = getText(el);
			System.out.println(title);
			if (title.toLowerCase().contains(itemName)) {
				return true;
				
			}break;
		}
		return false;
	} 

}
