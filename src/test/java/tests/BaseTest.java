package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.CatalogPage;
import pages.CheckoutPage;
import pages.FacebookPopup;
import pages.Get5Page;
import pages.GooglePopup;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;
import pages.SearchResultPage;
import pages.ShopifyPage;
import utils.Utils;

public class BaseTest {

	//Global
	WebDriver driver ;
	HomePage homePage;
	CatalogPage catalogPage;
	Get5Page get5Page;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	LoginPage loginPage;
	ShopifyPage shopifyPage;
	SearchResultPage searchResultPage;
	ItemPage itemPage;
	FacebookPopup facebookPopup;
	GooglePopup googlePopup;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(Utils.getValue("url")); 

		//pages
		homePage = new HomePage(driver);
		catalogPage = new CatalogPage(driver);
		get5Page = new Get5Page(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		loginPage = new LoginPage(driver);
		shopifyPage = new ShopifyPage(driver);
		searchResultPage = new SearchResultPage(driver);
		itemPage = new ItemPage(driver);
		facebookPopup = new FacebookPopup(driver);
		googlePopup = new GooglePopup(driver);
	}

	@AfterClass
	public void tearDown() {
		//	driver.quit(); 
	}

}
