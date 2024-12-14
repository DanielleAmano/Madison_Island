package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

	@FindBy (css = "#SearchInput")
	private WebElement submitBtn;
	@FindBy (css = "#SearchResultSubmit")
	private WebElement searchField;
	@FindBy (css = ".product-card.product-card--list")
	private List<WebElement> itemList;

	//constructor
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

 
	//Methods
	public void search(String text) {
		fillText(searchField, text);
		click(submitBtn);
	}

	public void printSearchResults() {
		for (WebElement el : itemList) {
			System.out.println(getText(el));
			break;
		}
	}

	
	//Validations
	
}
