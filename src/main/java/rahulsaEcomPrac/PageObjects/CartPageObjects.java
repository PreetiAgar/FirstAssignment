package rahulsaEcomPrac.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsaEcomPrac.AbstractComponent.AbstractComponents;

public class CartPageObjects extends AbstractComponents {
	WebDriver driver;

	public CartPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartItems;

	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkout;

	public List<WebElement> getCartList() {

		return cartItems;

	}

	public boolean matchProduct(String product) {

		List<WebElement> cartItems = getCartList();
		boolean match = cartItems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(product));
		return match;
	}

	public void clickCheckout() {
		checkout.click();
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryField;
	
	By results=By.cssSelector("section[class*='ta-results']");
	
	 @FindBy(css="section[class*='ta-results']")
	 WebElement result;
	 
	//@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	//WebElement countryIndia;
	 By countryIndia=By.xpath("(//button[contains(@class,'ta-item')])[2]");

	public void selectCountry(String countryName) throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(countryField, countryName).build().perform();
		waitForElementToAppear(results);
		result.findElement(countryIndia).click();
		//countryIndia.click();
		
	}

	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	WebElement placeOrder;

	public void clickPlaceOrder() {
		placeOrder.click();
	}

	By confirmMsg=By.xpath("//h1[contains(text(),'Thankyou for the order.')]");
	@FindBy(xpath="//h1[contains(text(),'Thankyou for the order.')]")
	WebElement confirmMessage;

	public boolean confirmationMessage() {
		waitForElementToAppear(confirmMsg);
		boolean flag = confirmMessage.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		return flag;
	}
}
