package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogFilters extends BaseTest{

	@Test (description = "Check 'Accessories' filter for Catalog")
	public void tc01_checkCatalogFilters() {
		homePage.clickOnTopButtons("catalog");
		catalogPage.filterBy("/collections/all/accessories");
		catalogPage.nextPage();
		catalogPage.chooseItem("Swiss Movement Sports Watch");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 1);
		cartPage.continueShopping();
	}

	@Test (description = "Check filter for Catalog")
	public void tc02_checkCatalogFilters() {
		catalogPage.filterBy("/collections/all/home-decor");
		catalogPage.chooseItem("Pillow and Throw Set");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 2);
		cartPage.continueShopping();
	}

	@Test (description = "Check 'Men' filter for Catalog")
	public void tc03_checkCatalogFilters() {
		catalogPage.filterBy("/collections/all/men");
		catalogPage.nextPage();
		catalogPage.chooseItem("PLAID COTTON SHIRT");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 3);
		cartPage.continueShopping();
	}

	@Test (description = "Check 'Women' filter for Catalog")
	public void tc04_checkCatalogFilters() {
		catalogPage.filterBy("/collections/all/women");
		catalogPage.chooseItem("LUDLOW OXFORD TOP");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 4);
	}

}


