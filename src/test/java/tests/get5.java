package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
 
public class get5 extends BaseTest{

	@Test (description = "fill Info")
	public void tc01_fillINfo() {  
		homePage.clickOnTopButtons("get $5");
		get5Page.makeActionsInGet5Btn();
		//get5Page.fillInfo("Danielle", "danielleamano01@gmail.com");
		//get5Page.unsubscribe();
		//get5Page.clickInvitefriends();
	//	Assert.assertTrue(get5Page.isItInviteFriendsPage());
	}
 
//	@Test (description = "fill 'to', 'subject' ,'note'")
	public void tc02_fillEmailInformation() {
		get5Page.fillEmailInfo("GalMatalon@gmail.com", "Thank you", "Thank you for your hard work");
		get5Page.cancelReminder();
		get5Page.sendEmail();
		Assert.assertTrue(get5Page.didTheEmailSent());
	}

	@Test (description = "send a message via Facebook")
	public void tc03_connectWithFacbook() {
		get5Page.sendFacbookMsg();
		facebookPopup.fillConnectInfo("danielleamano01@gmail.com", "hire me");
		Assert.assertTrue(facebookPopup.isItFacebookPage());
		get5Page.backToMainWindow();
	}

//	@Test (description = "copy link")
	public void tc04_copyLink() {
		get5Page.copyLink();
		Assert.assertTrue(get5Page.isTheLinkCorrect());
	}

//	@Test (description = "go back 'home'")
	public void tc05_exitReferAFriendWindow() {
		driver.switchTo().defaultContent(); //is this the right place?
		get5Page.clickOnTopButtons("home");
		Assert.assertTrue(homePage.isItHomePage());
	}

}


