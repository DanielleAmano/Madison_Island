package tests;

import org.testng.annotations.Test;

public class Search extends BaseTest{

	@Test (description = "")
	public void tc01_search() {
		homePage.search("skirt");
		//search a word
		//get the list
		//assert the list
	}  


//	@Test (description = "")
	public void tc02_addItemToCartFromSerachResult() {
		//choose an item
		//add to cart
		//assert the cart items
	}
}


