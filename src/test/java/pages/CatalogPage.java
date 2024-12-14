package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends MenuPage {
	//also known as "Products page" / "Women" / "Men" / "Accessories" / "Home&Decor"

	@FindBy (css = "#FilterTags")
	private WebElement filterDD;
	@FindBy (css = "[name='sort_by']")
	private WebElement SortDD;
	@FindBy (css = ".icon.icon--wide.icon-arrow-right")
	private WebElement nextPageBtn;
	@FindBy (css = ".icon--wide.icon-arrow-left")
	private WebElement previousPageBtn;
	@FindBy (css = ".grid-view-item.product-card")
	private List<WebElement> itemList;


	//constructor
	public CatalogPage(WebDriver driver) {
		super(driver); 
	}


	//Methods

	public void nextPage() {
		waiting(200);
		click(nextPageBtn);
	} 

	public void previousPage() {
		click(previousPageBtn);
	}

	//15 options
	public void filterBy(String filterOption) {
		selectByValue(filterDD, filterOption);
	}

	//sort
	public void selectByValue(String value) {// the element is defined here
		selectByValue(SortDD, value);
	}

	public void chooseItem(String itemName) {
		List<WebElement> list = driver.findElements(By.cssSelector(".grid-view-item__link"));
		for (WebElement el : list) {
			//			System.out.println(getText(el)); //check
			if (getText(el).equalsIgnoreCase(itemName)) {
				click(el);
				break;
			}waiting(200);
		}
	}

	public void printItemList() {
		System.out.println(itemList);
	}

	public void addAllItemsFromPage() { //IS it possible?
		int itemCount = 0;
		int pageNumber = 1;

		while (pageNumber <= 5) { 
			for (WebElement item : itemList) {
				click(item);
				WebElement addToCartBtn = driver.findElement(By.cssSelector("[name='add']"));
				click(addToCartBtn);
				WebElement continueShopping = driver.findElement(By.cssSelector("[class*='cart__continue']"));
				click(continueShopping);
				waiting(200);
				itemCount++;
				if (itemCount % 8 == 0) {
					click(nextPageBtn);
					waiting(300); //page loading
					pageNumber++;
					break;
				}break;
			}
			if (itemCount >= 40) { //Total 40 Products
				break;
			}
		}
	}

	//לולאה שמדפדפת
	//לולאה שרצה על כל הפריטים בדף
	//נכנסת לפריט ראשון, מוספיה לעגלה,ממשיכה בקניות
	//רצה על כל הפריטים בדף, נכנסת לפריט השני מוספיה לעגלה,ממשיכה בקניות

	//אחרי 8 פריטים,היא מדפדפת לדף הבא (עד שהיא מגיעה לדף 5)
	//מוסיפה 8 פריטים
	//break;





	//Validation
	public boolean isItProductsPage() {
		String title = driver.findElement(By.cssSelector(".section-header span")).getText();

		// Split the title by spaces and check if "Products" is one of the words
		String[] words = title.split("\\s+"); // Split by one or more spaces
		for (String word : words) {
			if (word.equalsIgnoreCase("products")) {
				return true;
			}
		}
		return false; 
	}

	public int numberOfProducts() {
		String num = driver.findElement(By.cssSelector("filters-toolbar__product-count")).getText(); 
		int i = Integer.parseInt(num);
		return i;
	}


}
