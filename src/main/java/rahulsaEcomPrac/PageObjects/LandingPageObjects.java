package rahulsaEcomPrac.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsaEcomPrac.AbstractComponent.AbstractComponents;

public class LandingPageObjects extends AbstractComponents {
	WebDriver driver;
	
	public LandingPageObjects(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	WebElement Username;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(css="[@class*='flyInOut']")
	WebElement loginError;
	
	public String getErrorMsg() {
		String errorMsg=loginError.getText();
		waitForElementToAppear(loginError);
		return errorMsg;
	}
	
	public ProductCatalogPageObjects Login(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		loginBtn.click();
		return new ProductCatalogPageObjects(driver);
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	
			
	

}
