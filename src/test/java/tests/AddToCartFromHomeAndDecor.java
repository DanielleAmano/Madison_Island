package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromHomeAndDecor extends BaseTest{
	//also, check the cart label from different pages

	final String ITEM = "vase set";

	
	@Test (description = "Add 'Vase Set' to the cart from Home & Decor, sort by 'price ascending' ")
	public void tc01_addItemToCartFromHomeAndDecor() {
		homePage.clickCollectionList("home & decor");
		catalogPage.selectByValue("price-ascending");
		catalogPage.chooseItem(ITEM);  
		itemPage.addToCart(); 
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 1);
		cartPage.clickOnTopButtons("home");
		Assert.assertEquals(homePage.NumOfItemsInCartLabel(), 1); 
	}

	@Test (description = "Filter by 'BED&BATH',sort by 'Alphabeticlly, A_Z'choose 'Pillow and Throw Set', go back, add 'Carnegie Alpaca Throw' to the cart")
	public void tc02_addSecondItem() {
		homePage.clickCollectionList("home & decor");
		catalogPage.filterBy("/collections/home-decor/bed-bath");
		catalogPage.selectByValue("title-ascending");
		catalogPage.chooseItem("pillow and throw set");
		Assert.assertEquals(itemPage.NumOfItemsInCartLabel(), 1);
		itemPage.back();
		catalogPage.chooseItem("Carnegie Alpaca Throw");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 2); 
		cartPage.continueShopping();
		catalogPage.clickOnTopButtons("home");
	} 

	@Test (description = "Filter by 'Decorative Accents', sort by 'Featured', add 'Stone Salt and Pepper Shakers' to cart")
	public void tc03_addThirdItem() {
		homePage.clickCollectionList("home & decor");
		catalogPage.filterBy("/collections/home-decor/decorative-accents");
		catalogPage.selectByValue("manual");
		catalogPage.chooseItem("stone salt and pepper shakers");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 3);
		cartPage.clickOnTopButtons("home");
	}

	@Test (description = "Sort by'Date, old to new' add 'Fragrance Diffuser Reeds' to the cart")
	public void tc04_addFourthItem() {
		homePage.clickCollectionList("home & decor");
		catalogPage.selectByValue("created-ascending");
		Assert.assertEquals(catalogPage.NumOfItemsInCartLabel(), 3); 
		catalogPage.chooseItem("fragrance diffuser reeds");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 4); 
	}

	@Test (description = "Remove 'Vase Set' from the cart")
	public void tc05_removeItemFromCart() {
		cartPage.removeProduct(ITEM);
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 3); 
	}

}


