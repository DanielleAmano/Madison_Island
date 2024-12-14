package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Get5Page extends MenuPage {
	//also  the pop-up "refer a friend" pink button

	@FindBy (css = "#SiteNav>li")
	private List<WebElement> menuList;

	@FindBy (css = "#affiliate_member_first_name")
	private WebElement firstNameField;
	@FindBy (css = ".js-input-email")
	private WebElement emailField;
	@FindBy (css = ".checkbox")
	private WebElement subscribeCB; //checkbox
	@FindBy (css = ".checkbox.is-checked")
	private WebElement unsubscribeCB; //checkbox
	@FindBy (css = ".is-large.is-block")
	private WebElement inviteFriendsBtn;
	@FindBy (css = "[class*='facebook-login']")
	private WebElement facebookBtn;
	@FindBy (css = "#js-google-signup")
	private WebElement googleBtn;
	@FindBy (css = ".popup-close")
	private WebElement exitBtn;

	//After "invite friends" 
	@FindBy (css = "#email_recipient_list")
	private WebElement toField;
	@FindBy (css = ".is-subject")
	private WebElement subjectField;
	@FindBy (css = "#share_message")
	private WebElement noteField;
	@FindBy (css = ".checkbox")
	private WebElement reminderCB;
	@FindBy (css = ".js-email-share-submit")
	private WebElement sendEmailBtn;
	//Facebook
	@FindBy (css = ".is-facebook")
	private WebElement topFBtn;
	@FindBy (css = "[class*='facebook-message']")
	private WebElement sendasMessageBtn;
	//Link
	@FindBy (css = ".is-link")
	private WebElement topLinkBtn;
	@FindBy (css = ".for-flash :nth-child(2)")
	private WebElement copyLinkBtn;


	//Constructor
	public Get5Page(WebDriver driver) {
		super(driver);
	}

	//Methods
	public void fillInfo(String firstName, String email) {
		fillText(firstNameField, firstName);
		fillText(emailField, email);
	}

	public void clickInvitefriends() {
		click(inviteFriendsBtn);
	}

	public void subscribe() {
		click(subscribeCB);
	}

	public void unsubscribe() {
		click(unsubscribeCB);
	}

	public void loginWithFacebook() {
		click(facebookBtn);
		moveToNewWindow();		//move the driver
	}

	public void loginWithGoogle() {
		click(googleBtn); 
		moveToNewWindow(); 		//move the driver
	}

	public void fillEmailInfo(String toText, String subject, String note) {
		//frame?
		//WebElement frEl = driver.findElement(By.cssSelector("talkable-offer-iframe"));
		//driver.switchTo().frame(frEl);
		fillText(toField, toText); 
		fillText(subjectField, subject);
		fillText(noteField, note);
	}

	public void cancelReminder() {
		click(reminderCB);
	}

	public void reminder() {
		click(reminderCB);
	}

	public void sendEmail() {
		click(sendEmailBtn);
	}

	public void exitWindow() {
		//out of frame
		driver.switchTo().defaultContent();
		click(exitBtn);
	}

	public void sendFacbookMsg() {
		WebElement frEl = driver.findElement(By.cssSelector("#facebook"));
		driver.switchTo().frame(frEl);
		click(topFBtn);
	}

	public void copyLink() {
		click(topLinkBtn);
	}

	//Validation
	public boolean isItGet5Page() {
		WebElement frEl = driver.findElement(By.cssSelector("[name='talkable-offer-iframe']"));
		driver.switchTo().frame(frEl);

		String title = driver.findElement(By.cssSelector(".header h1")).getText();
		System.out.println(title);
		if (title.toLowerCase().equals("give $5, get $5!")) {
			return true; 
		}else {
			return false;
		}
	}

	public boolean isTheLinkCorrect() {
		String msg = driver.findElement(By.cssSelector(".is-share-link")).getText();
		if (msg.toLowerCase().equals("https://www.talkable.com/x/YjHquW")) {
			return true;
		}else {
			return false;
		}		
	}

	public boolean isItInviteFriendsPage() {
		WebElement button = driver.findElement(By.cssSelector("[value='Send Email']"));
		if (button.isDisplayed()) {
			return true;
		}else {
			return false; 
		}
	}

	//Demo website- email is not being sent
	public boolean didTheEmailSent() {
		String msg1 = driver.findElement(By.cssSelector(".validation")).getText();
		if (msg1.toLowerCase().equals("Sorry! We are unable to deliver an email to da@gmail.com")) {
			return true;
		}else {
			return false;
		}	
	}
}
