package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

	//Header
	//Logo
	@FindBy (css=".site-header__logo-link")
	private WebElement logoBtn;
	
	//3 tabs buttons
	@FindBy (css = "#SiteNav>li")
	private List<WebElement> menuList;
	
	//3 right buttons
	@FindBy (css="[class*='search-toggle']")
	private WebElement searchtBtn;
	@FindBy (css=".search-bar__input")
	private WebElement searchField;
	@FindBy (css=".icon-login")
	private WebElement loginBtn;
	@FindBy (css=".icon-cart")
	private WebElement openCartBtn;
	@FindBy (css="#CartCount")
	private WebElement CartItemNumLabel;

	//General
	@FindBy (css=".trigger-text")
	private WebElement referAFriendBtn;
	@FindBy (css = "#affiliate_member_first_name")
	private WebElement firstNameField;
	@FindBy (css = ".textfield.js-input-email")
	private WebElement emailField;
	@FindBy (css = ".checkbox")
	private WebElement subscribeCheckbox;
	@FindBy (css = ".button.is-large.is-block")
	private WebElement inviteFriendsBtn;
	@FindBy (css = "[class*='login is-facebook-login']")
	private WebElement loginWithFacebookBtn;
	@FindBy (css = "#js-google-signup")
	private WebElement loginWithGoogleBtn;

	//Footer
	@FindBy (css=".site-footer__linklist-item")
	private WebElement footersearchBtn;
	@FindBy (css="#ContactFooter-email")
	private WebElement subscribeField;
	@FindBy (css=".newsletter__submit-text--large")
	private WebElement subscribeBtn;
	@FindBy (css=".small--one-whole .small--hide :nth-child(1)") //check if it works 
	private WebElement madisonIsleandLink;
	@FindBy (css=".small--one-whole .small--hide :nth-child(2)") //check if it works 
	private WebElement poweredByShopifyLink;

	//constructor
	public MenuPage(WebDriver driver) {
		super(driver);
	}

	//Header
	//logo
	public void clickOnLogo() {
		click(logoBtn);
	}

	//Menu tabs
	public void clickOnTopButtons(String topButton) {
		for (WebElement el : menuList) {
			if (getText(el).toLowerCase().contains(topButton)) {	
				waitForElemenatToBeclickable(el);
				click(el);
				break; 
			}
		} //get $5 needs the second method, accessing the frame from "Get5Page"
	}

	public void makeActionsInGet5Btn() {
		WebElement frEl = driver.findElement(By.cssSelector("[name='talkable-offer-iframe']"));
		driver.switchTo().frame(frEl);
		for (WebElement el : menuList) {
			//	System.out.println(el);
			if (getText(el).toLowerCase().contains("get $5")) {	 
				waitForElemenatToBeclickable(el);
				click(el);
				break;
			} 
		}
		//remember to exit the frame in the test
	}
	

	//icons
	public void search(String text) {
		click(searchtBtn);
		waiting(100);
		fillText(searchField, text);
		click(searchtBtn);
	} 

	public void login() {
		click(loginBtn);	
	}

	public void openCart() {
		click(openCartBtn);
	}


	//Footer
	public void footerSerach(String text) {
		fillText(footersearchBtn, text);
	}

	public void subscribe(String text) {
		fillText(subscribeField, text);
		click(searchtBtn);
	}

	public void referAFriendPinkFrame() { //does it work?
		WebElement frEl = driver.findElement(By.cssSelector("[name='talkable-offer-iframe']"));
		driver.switchTo().frame(frEl);
		click(referAFriendBtn);
		waiting(500);
	}
 
	public void clickOnMadisonIsleandLink() {
		click(madisonIsleandLink);
	}

	public void clickOnPoweredfyShopifyLink() {
		click(poweredByShopifyLink);
		//move the driver to the new window
		moveToNewWindow();
	}

	//validation
	public int NumOfItemsInCartLabel() {
		String num = getText(CartItemNumLabel);
		int numOfItems = Integer.parseInt(num);
		return numOfItems;
	}
}
