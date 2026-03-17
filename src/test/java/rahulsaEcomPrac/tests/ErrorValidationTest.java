package rahulsaEcomPrac.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulsaEcomPrac.PageObjects.CartPageObjects;
import rahulsaEcomPrac.PageObjects.LandingPageObjects;
import rahulsaEcomPrac.PageObjects.ProductCatalogPageObjects;
import rahulsaEcomPrac.TestComponents.BaseTest;
import rahulsaEcomPrac.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {
	WebDriver driver;
	
	
	@Test
	public void loginErrorValidate() throws Exception {
		//LandingPageObjects Lp=launchApplication();
		Lp.Login("preetiagarwal.officiaal@gmail.com", "Bubba@11106");
		String msg=Lp.getErrorMsg();
		Assert.assertEquals(msg, "Incorrect email or password.");
		
	}
	
	@Test(groups= {"Error Handling"}, retryAnalyzer=Retry.class)
	public void checkProductMismatch() throws Exception {
		//LandingPageObjects Lp=launchApplication();
		ProductCatalogPageObjects Pc=Lp.Login("preetiagarwal.official@gmail.com", "Bubba@1106");
		String product = "ZARA COAT 3";
		Pc.addToCart(product);
		CartPageObjects cpo=Pc.goToCartPage();
		boolean match = cpo.matchProduct("ZARA COAT 3");
		Assert.assertTrue(match);
	}

}
