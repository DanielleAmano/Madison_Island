package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartMaxItemBoundry extends BaseTest{

	//add all products to the cart
 
	@Test (description = "Add all products form page 1")
	public void tc01_addAllCatalogItemPage1() {
		homePage.clickOnTopButtons("catalog");
		catalogPage.chooseItem("aviator sunglasses");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem("blue horizons bracelets");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem("bowery chino pants");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem("carnegie alpaca throw");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem("chelsea tee");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem("core striped sport shirt");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem("delancy cardigan sweater");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.chooseItem("dumbo boyfriend jean");
		itemPage.addToCart();
		cartPage.continueShopping();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 8);
	}

	@Test (description = "Add all products form page 2")
	public void tc02_addAllCatalogItemPage2() {
		catalogPage.nextPage();
		catalogPage.chooseItem("elizabeth knit top");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.chooseItem("essex pencil skirt");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.chooseItem("flat front trouser");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.chooseItem("fragrance diffuser reeds");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.chooseItem("french cuff cotton twill oxford");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.chooseItem("gramercy throw");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.chooseItem("jackie o round sunglasses");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.chooseItem("khaki bowery chino pants");
		itemPage.addToCart();
		cartPage.continueShopping();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 16);
	}

	@Test (description = "Add all products form page 3")
	public void tc03_addAllCatalogItemPage3() {
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("lafayette convertible dress");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("lexington cardigan sweater");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("linen blazer");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("ludlow oxford top");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("ludlow sheath dress");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("merino v-neck pullover sweater");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("nolita cami");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("park avenue pleat front trousers");
		itemPage.addToCart();
		cartPage.continueShopping();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 24);
	}

	@Test (description = "Add all products form page 4")
	public void tc04_addAllCatalogItemPage4() {
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("park row throw");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("pearl necklace set");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("pearl stud earrings");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("Pillow and throw set");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("plaid cotton shirt");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("racer back maxi dress");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("retro chic eyeglasses");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("silver desert necklace");
		itemPage.addToCart();
		cartPage.continueShopping();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 32);
	}

	@Test (description = "Add all products form page 5")
	public void tc5_addAllCatalogItemPage5() {
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("slim fit dobby oxford shirt");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("stone salt and pepper shakers");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("swing time earrings");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("swiss movement sports watch");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("the essential boot cut jean");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("tori tank");
		itemPage.addToCart(); 
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("tribeca skinny jean");
		itemPage.addToCart();
		cartPage.continueShopping();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.nextPage();
		catalogPage.chooseItem("vase set");
		itemPage.addToCart();
		Assert.assertEquals(cartPage.NumOfItemsInCartLabel(), 40);
	}

}