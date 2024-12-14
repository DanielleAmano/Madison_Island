package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromMenAndCheckout extends BaseTest{

	@Test (description = "Choose 'LINEN BLAZE' and return to 'Men', from 'Collection List' filter by 'new arrivals', sort by 'Price, high to low' ")
	public void tc01_chooseAnItemAndReturnToCatalog() {
		homePage.clickCollectionList("men");
		catalogPage.filterBy("/collections/men/new-arrivals");
		catalogPage.selectByValue("price-descending");
		catalogPage.chooseItem("LINEN BLAZER");
		itemPage.back();
		catalogPage.openCart();
		Assert.assertTrue(cartPage.isCartEmpty());
		cartPage.clickOnTopButtons("home");
		homePage.clickCollectionList("men");
	} 

	@Test (description = "Add 'KHAKI BOWERY CHINO PANT' size '32', 'Khaki' color,  to the cart, filter by ' pants-denim', sort by 'Date, new to old' ")
	public void tc02_addItemTocart() {
		homePage.clickCollectionList("men");

		catalogPage.filterBy("/collections/men/pants-denim");
		catalogPage.selectByValue("created-descending");
		catalogPage.chooseItem("KHAKI BOWERY CHINO PANTS"); 
		itemPage.chooseSize("32");
		itemPage.chooseColor("Khaki");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 1);
		cartPage.continueShopping();
		Assert.assertEquals(catalogPage.NumOfItemsInCartLabel(), 1);
		catalogPage.clickOnTopButtons("home");
	}

	@Test (description = "Add 'FRENCH CUFF COTTON TWILL OXFORD' to the cart, filter by 'shirts', sort by 'Price,low to high' ")
	public void tc03_addItemTocart() {
		homePage.clickCollectionList("men");
		catalogPage.filterBy("/collections/men/shirts");
		catalogPage.selectByValue("price-ascending");
		catalogPage.chooseItem("FRENCH CUFF COTTON TWILL OXFORD");
		itemPage.chooseSize("M");
		itemPage.addToCart();
		Assert.assertEquals(catalogPage.NumOfItemsInCartLabel(), 2);
		cartPage.clickOnTopButtons("home");
	}

	@Test (description = "From slideshow, add 'LEXINGTON CARDIGAN SWEATER', size 'M', filter by 'tees & knits & polos, sorted by 'Featured ")
	public void tc04_addItemToCart() {
		homePage.freezeSlideshow();
		homePage.cliskOnSlideshowMen();
		catalogPage.filterBy("/collections/men/tees-knits-polos");
		catalogPage.selectByValue("manual");
		catalogPage.chooseItem("LEXINGTON CARDIGAN SWEATER");
		itemPage.chooseSize("M");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 3);
		cartPage.checkout();
	}

	@Test (description = "checkout") 
	public void tc05_checkout() {
		checkoutPage.fillEmail("danielleamano01@gmail.com", true);
		checkoutPage.fillInfo("AD", "Danielle", "Amano", "Automation", "100", "AD500", "Andorra la Vella");
		checkoutPage.fillPayingMethod("1234 1234 1234 1234", "11 / 00 / 2025", "123", true);
	}

}
 

