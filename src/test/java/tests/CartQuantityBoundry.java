package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test; 

public class CartQuantityBoundry extends BaseTest{

	@Test (description = "Add 'Aviator Sunglasses' to the cart")
	public void tc01_addItemToTheCart() {
		homePage.clickOnTopButtons("catalog");
		catalogPage.chooseItem("aviator sunglasses");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.isIteminTheCart("aviator sunglasses"), true);
	}
 
	@Test (dataProvider = "getData")
	public void tc02_changeQuantity(String quantity) {
		cartPage.changeItemQuantity("aviator sunglasses", quantity);
		cartPage.update();
		Assert.assertTrue(cartPage.isUpdateSucceded());
	}

	@DataProvider 
	public Object[][] getData(){
		Object[][] data = {
				{"50"},
				{"500"},
				{"5000"},
				{"50000"},
				{"500000"},
				{"900000"},
		};
		return data;
	}

}


