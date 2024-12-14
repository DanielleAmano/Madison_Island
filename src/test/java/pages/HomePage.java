package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends MenuPage {

	//Slideshow
	@FindBy(css = ".slideshow__controls [aria-label='Next slide']")
	private WebElement nextSlideBtn;
	@FindBy(css = ".slideshow__controls [aria-label='Previous slide']")
	private WebElement previosSlideBtn;
	@FindBy(css = ".icon-pause")
	private WebElement freezeSlideBtn;
	@FindBy(css = ".icon-resume")
	private WebElement resumeSlideBtn;
	@FindBy(css = "[class*='btn slideshow']") 
	private WebElement shopNowBtn; 
	@FindBy(css = ".[class*='btn slideshow']") 
	private WebElement referAFriendBtn; 

	//Collection list
	@FindBy (css = ".collection-grid-item__title")
	private List<WebElement> collectionList;
	@FindBy (css = ".section-header.text-center")
	private WebElement catagoriesHeadline;


	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	//Methods

	//Slideshow
	public void freezeSlideshow() {
		click(freezeSlideBtn);
	}

	public void resumeSlideshow() {
		click(resumeSlideBtn);
	}

	public void cliskOnSlideshowMen() { 
		waiting(200);
		click(shopNowBtn);
		//men works
		//women doesn't
		//accessories doesn't
		//home&decor
	}

	public void scrollSlideshowToTheRight() {
		click(nextSlideBtn);
		waiting(200);
	}

	public void scrollslideshowToTheLeft() {
		click(previosSlideBtn);
	}
	//end Slideshow

	//Collection list
	public void clickCollectionList(String collection) {
		for (WebElement el : collectionList) {
			if (getText(el).toLowerCase().equals(collection)) {
				click(el);
				break;
			}
		} 
	}


	//Validation
	public boolean isItHomePage() { 
		if (getText(catagoriesHeadline).toLowerCase().contains("collection list")) {
			return true;
		}else {
			return false;
		}
	}

}