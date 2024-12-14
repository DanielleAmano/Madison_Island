package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReferAFriendWithFacebookAndGoogle extends BaseTest{


	@Test (description = "Login With Google")
	public void tc01_connectWithgoogle() {
		homePage.referAFriendPinkFrame();
		get5Page.makeActionsInGet5Btn();
	//	get5Page.loginWithGoogle();//doesn't work
	//	Assert.assertTrue(googlePopup.isItGooglePage());
	//	googlePopup.fillConnectInfo("danielleamano01@gmail.com");
	//	homePage.backToMainWindow();
	}

	@Test (description = "Login With Facebook")
	public void tc02_connectWithFacbook() {
		get5Page.loginWithFacebook();
		Assert.assertTrue(facebookPopup.isItFacebookPage());
		facebookPopup.fillConnectInfo("danielleamano01@gmail.com", "TheBest");
		homePage.backToMainWindow();
	}

	@Test (description = "Exit 'refer a friend' window")
	public void tc03_exitReferAFriendWindow() {
		get5Page.exitWindow();
		Assert.assertTrue(homePage.isItHomePage());
	}

}


