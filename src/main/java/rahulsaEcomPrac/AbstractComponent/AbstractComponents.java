package rahulsaEcomPrac.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulsaEcomPrac.PageObjects.CartPageObjects;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".ng-animating")
	WebElement spinner;
	@FindBy(css="[routerlink*='cart']")
	WebElement CartIcon;
	//By CartIcon2 = By.cssSelector("[routerlink*='cart']");
	
	public void waitForElementToAppear(By cartIcon2) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon2));
	}
	
	public void waitForElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	public void waitForElementToDisappear() throws InterruptedException {
		//Thread.sleep(3000);
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	public CartPageObjects goToCartPage() throws InterruptedException {
		waitForElementToDisappear();
		CartIcon.click();
		return new CartPageObjects(driver);
	}
}	
	
