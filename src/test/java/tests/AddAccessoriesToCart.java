package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAccessoriesToCart extends BaseTest{
	//also, check the cart label from different pages

	final String ITEM = "jackie o round sunglasses";

	@Test (description = "Add 'pearl stud earings' to cart from 'Accessories', sort by 'Alphabetically, Z-A' ")
	public void tc01_goToAccessories() {
		homePage.clickCollectionList("accessories");
		catalogPage.selectByValue("title-descending");
		catalogPage.chooseItem("pearl stud earrings");
		itemPage.addToCart(); 
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 1);
		cartPage.clickOnTopButtons("home");
	}

	@Test (description = "Add 'pearl necklace set' to cart from 'Accessories', sort by 'Alphabetically, A-Z' ")
	public void tc02_addProductFromAccessories() { 
		homePage.clickCollectionList("accessories");
		catalogPage.selectByValue("title-ascending");
		catalogPage.chooseItem("pearl necklace set");
		itemPage.addToCart();
		cartPage.clickOnTopButtons("home");
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 2);
	}

	@Test (description = "Add 'Jackie O Round Sunglasses' to cart from 'Accessories', sort by 'Price, high to low' ")
	public void tc03_addProductFromAccessories() { 
		homePage.clickCollectionList("accessories");
		catalogPage.selectByValue("price-descending");
		catalogPage.chooseItem(ITEM);
		itemPage.addToCart();
		cartPage.goToItem(ITEM);
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 3);
		itemPage.openCart();
	}

	@Test (description = "Remove 'Jackie O Round Sunglasses' from cart ")
	public void tc04_removeProduct() { 
		cartPage.removeProduct(ITEM); 
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 2);
	}

	@Test (description = "Add 'Aviator Sunglasses' to cart from 'Accessories', sort by 'Price, low to high' ")
	public void tc05_addProductFromAccessories() { 
		cartPage.clickOnTopButtons("home");
		homePage.clickCollectionList("accessories");
		catalogPage.selectByValue("price-ascending");
		catalogPage.chooseItem("aviator sunglasses");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 3);
	}

	@Test (description = "Add 'Blue Horizons Bracelets' to cart from 'Accessories', sort by 'Date, old to new' ")
	public void tc06_addProductFromAccessories() { 
		get5Page.clickOnTopButtons("home");
		homePage.clickCollectionList("accessories");
		catalogPage.selectByValue("created-ascending");
		catalogPage.chooseItem("blue horizons bracelets");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 4);
	}

	@Test (description = "Add 'Retro Chic Eyeglasses' to cart from 'Accessories', sort by 'Date, new to old' ")
	public void tc07_addProductFromAccessories() { 
		get5Page.clickOnTopButtons("home");
		homePage.clickCollectionList("accessories");
		catalogPage.selectByValue("created-descending");
		catalogPage.chooseItem("retro chic eyeglasses");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 5);
	}

	@Test (description = "Add 'Silver Desert Necklace' to cart from 'Accessories', sort by 'featured' ")
	public void tc08_addProductFromAccessories() { 
		cartPage.clickOnTopButtons("home");
		homePage.clickCollectionList("accessories");
		catalogPage.selectByValue("manual");
		catalogPage.chooseItem("silver desert necklace");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 6);
		cartPage.continueShopping(); 
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 6); 
		Assert.assertTrue(catalogPage.isItProductsPage()); 
		catalogPage.clickOnTopButtons("get $5");; 
		Assert.assertTrue(get5Page.isItGet5Page());
		driver.switchTo().defaultContent();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 6);
	}

}