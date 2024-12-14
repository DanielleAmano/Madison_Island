package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends MenuPage {

	//Contact
	@FindBy (css = "#email")
	private WebElement emailField;
	@FindBy (css = "#marketing_opt_in")
	private WebElement emailCheckbox;

	//Delivery
	@FindBy (css = "[name='countryCode']")
	private WebElement countryDD;
	@FindBy (css = "[name='firstName']")
	private WebElement firstNameField;
	@FindBy (css = "#TextField1")
	private WebElement lastNameField;
	@FindBy (css = "#TextField2")
	private WebElement addressField;
	@FindBy (css = "#TextField3")
	private WebElement ApartmentField;
	@FindBy (css = "[name='postalCode']")
	private WebElement postalcodeField;
	@FindBy (css = "[name='city']")
	private WebElement cityField;
	@FindBy (css = "[name='zone']")
	private WebElement stateDD;
	@FindBy (css = "#save_shipping_information")
	private WebElement saveInfoCheckbox;

	//Shipping method
	//	@FindBy (css = "")
	//	private WebElement USPSFirstClassShipping;	
	//	@FindBy (css = "")
	//	private WebElement DHLExpressShipping;		
	//	@FindBy (css = "[class='_1fragems1']")
	//	private WebElement USPSPriorityShipping;		
	//	@FindBy (css = "")
	//	private WebElement USPSPriorityExpressShipping;		

	//Payment
	@FindBy (css = "#number")
	private WebElement cardNumberField;
	@FindBy (css = "#expiry")
	private WebElement expirationDateField; // MM/YY
	@FindBy (css = "#verification_value")
	private WebElement securityCodeField;
	@FindBy (css = ".CsSsR #name")
	private WebElement nameOnCardField;
	@FindBy (css = "#billingAddress")
	private WebElement useShippingAddressAsBillingAddressCheckbox;
	//Billing address
	@FindBy (css = "#Select3")
	private WebElement billingCountryField;
	@FindBy (css = "#TextField18-label")
	private WebElement billingFirstnameField;
	@FindBy (css = "#TextField19-label")
	private WebElement billingLastnameField;
	@FindBy (css = "#TextField20")
	private WebElement billingAdressField;
	@FindBy (css = "#TextField21")
	private WebElement billingApartmentField;
	@FindBy (css = "#TextField22")
	private WebElement billingPostalcodeField;
	@FindBy (css = "#TextField23")
	private WebElement billingCityField;

	//constructor
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	//Methods
	public void fillEmail (String email, Boolean subscribe ) {
		fillText(emailField, email);
		if (subscribe) {
			click(emailCheckbox);
		}
	}

	public void fillInfo(String country, String firstName, String lastName, String address, String apartment, String postalcode, String city) {
		selectByValue(countryDD, country);  // 2 letters	
		waiting(200);
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(addressField, address);
		fillText(ApartmentField, apartment);
		fillText(postalcodeField, postalcode);
		fillText(cityField, city);
		waiting(500);
	}

	//	public void chooseShippingMethod() {
	//		click(USPSPriorityShipping);
	//		click(driver.findElement(By.cssSelector("[name='shipping_methods']")));
	//		List<WebElement> areaList = driver.findElements(By.cssSelector("[name='shipping_methods']"));
	//	for (WebElement area : areaList) {
	//			String title = area.findElement(By.cssSelector("")).getText();
	//			System.out.println(title);
	//		}
	//	}

	public void fillPayingMethod(String cardNumber, String expirationDate, String securityCode, boolean billingSameAsShippingAddress) {
		//every field is in a frame
		WebElement frEl = driver.findElement(By.cssSelector("[id*='card-fields-number']"));
		driver.switchTo().frame(frEl);
		fillText(cardNumberField, cardNumber); 
		driver.switchTo().defaultContent(); 
		waiting(200);
		WebElement frEl2 = driver.findElement(By.cssSelector("[id*='card-fields-expiry']"));
		driver.switchTo().frame(frEl2);		
		waiting(500);
		fillText(expirationDateField, expirationDate);
		driver.switchTo().defaultContent(); 


		WebElement frEl3 = driver.findElement(By.cssSelector("[id*='card-fields-verification']"));
		driver.switchTo().frame(frEl3);
		fillText(securityCodeField, securityCode);
		driver.switchTo().defaultContent(); 

		if (! billingSameAsShippingAddress) {
			click(useShippingAddressAsBillingAddressCheckbox);
		}
	}

	public void fillBillingAddress(String country, String firstname, String lastname, String address, String apartment, String postalCode, String city) {
		fillText(billingCountryField, country);
		fillText(billingFirstnameField, firstname);
		fillText(billingLastnameField, lastname);
		fillText(billingAdressField, address);
		fillText(billingApartmentField, apartment);
		fillText(billingPostalcodeField, postalCode);
		fillText(billingCityField, city);
	}
}
