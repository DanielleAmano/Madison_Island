package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromWomen extends BaseTest{

	@Test (description = "Add 'ESSEX PENCIL SKIRT' size '4 to the cart, filter by 'Dresses & Skirts', sort by 'Alphabetically, A-Z'")
	public void tc01_goToCatalog() {
		homePage.clickCollectionList("women");
		catalogPage.filterBy("/collections/women/dresses-skirts");
		catalogPage.selectByValue("title-ascending");
		catalogPage.chooseItem("ESSEX PENCIL SKIRT");
		itemPage.chooseSize("4");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 1);
		cartPage.clickOnTopButtons("home");
		Assert.assertEquals(homePage.NumOfItemsInCartLabel(), 1);
	} 

	@Test (description = "Add 'TORI TANK' , filter by 'new arrivals', sort by 'Featured',to the cart and continue shopping")
	public void tc02_addItemTocart() {
		homePage.clickCollectionList("women");
		catalogPage.filterBy("/collections/women/new-arrivals");
		catalogPage.selectByValue("manual");
		catalogPage.chooseItem("TORI TANK");  
		itemPage.addToCart();
		cartPage.continueShopping();
		Assert.assertEquals(catalogPage.NumOfItemsInCartLabel(), 2);
	}

	@Test (description = "Add 'LAFAYETTE CONVERTIBLE DRESS' size '6' from the sceond page, to the cart and continue shopping")
	public void tc03_addItemTocart() {
		cartPage.clickOnTopButtons("home");
		homePage.clickCollectionList("women");
		catalogPage.nextPage();
		Assert.assertEquals(catalogPage.NumOfItemsInCartLabel(), 2);
		catalogPage.chooseItem("LAFAYETTE CONVERTIBLE DRESS");
		itemPage.chooseSize("6");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 3);
	}
	
	@Test (description = "Click an item and return to 'Women'")
	public void tc04_clickAndReturnFromItem() {
		cartPage.clickOnTopButtons("home");
		homePage.clickCollectionList("women");
		catalogPage.nextPage();
		Assert.assertEquals(catalogPage.NumOfItemsInCartLabel(), 3);
		catalogPage.chooseItem("NOLITA CAMI");
		itemPage.chooseSize("S");
		itemPage.back();
		Assert.assertEquals(catalogPage.NumOfItemsInCartLabel(), 3);
	}
	
	@Test (description = "Add 'DUMBO BOYFRIEND JEAN' size '30', filter by 'Pants & Denim',to the cart and continue shopping")
	public void tc05_addItemTocart() {
		cartPage.clickOnTopButtons("home");
		homePage.clickCollectionList("women");
		catalogPage.filterBy("/collections/women/pants-denim");
		catalogPage.chooseItem("DUMBO BOYFRIEND JEAN");
		itemPage.chooseSize("30");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 4);
	}
	
	@Test (description = "Checkout")
	public void tc0_checkout() {
		catalogPage.openCart();
		cartPage.checkout();
		checkoutPage.fillEmail("galgadot@hotmail.com", false);
		checkoutPage.fillInfo("GR", "gal", "gadot", "Athinas", "22", "10554", "athens");
		checkoutPage.fillPayingMethod("8888 8888 8888 8888", "1 2026", "304", true);
	}
	
}


