package rahulsaEcomPrac.PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulsaEcomPrac.AbstractComponent.AbstractComponents;

public class ProductCatalogPageObjects extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By prod = By.cssSelector(".mb-3");

	public List<WebElement> getProductList() {
		waitForElementToAppear(prod);
		return products;
	}

	By toastMessage = By.id("toast-container");
	By addToCartIcon = By.cssSelector(".card-body button:last-of-type");

	public WebElement getProductByName(String product) {
		WebElement productItem = getProductList().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);
		return productItem;
	}

	public void addToCart(String product) throws InterruptedException {
		WebElement productItem = getProductByName(product);
		productItem.findElement(addToCartIcon).click();
		waitForElementToAppear(toastMessage);
	}

}
