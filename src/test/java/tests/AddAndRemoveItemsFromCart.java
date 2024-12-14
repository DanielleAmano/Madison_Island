package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAndRemoveItemsFromCart extends BaseTest{

	final String ITEM1 = "aviator sunglasses";
	final String ITEM2 = "blue horizons bracelets";
	final String ITEM3 = "bowery chino pants";
	final String ITEM4 = "carnegie alpaca throw";
	final String ITEM5 = "chelsea tee";
	final String ITEM6 = "core striped sport shirt";
	final String ITEM7 = "delancy cardigan sweater";
	final String ITEM8 = "dumbo boyfriend jean";


	@Test (description = "Adding the 8 products from 'Catalog', first page, to the cart")
	public void tc01_add8Products() {
		homePage.clickOnTopButtons("catalog");
		catalogPage.chooseItem(ITEM1); 
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem(ITEM2); 
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem(ITEM3); 
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem(ITEM4); 
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem(ITEM5); 
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem(ITEM6); 
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem(ITEM7); 
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem(ITEM8); 
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 8);
	}

	@Test (description = "Remove all 8 items from cart")
	public void tc02_Remove8Products() {
		cartPage.removeProduct(ITEM1);
		cartPage.removeProduct(ITEM2);
		cartPage.removeProduct(ITEM3);
		cartPage.removeProduct(ITEM4);
		cartPage.removeProduct(ITEM5);
		cartPage.removeProduct(ITEM6);
		cartPage.removeProduct(ITEM7);
		cartPage.removeProduct(ITEM8);
		Assert.assertTrue(cartPage.isCartEmpty());
	}

	@Test (description = "Verify the 'continue' button is clickable when cart is empty")
	public void tc03_continueShooping() {
		cartPage.continueShopping();	
		Assert.assertTrue(catalogPage.isItProductsPage());
	}

}


