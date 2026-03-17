package rahulsaEcomPrac.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
import rahulsaEcomPrac.PageObjects.CartPageObjects;
import rahulsaEcomPrac.PageObjects.LandingPageObjects;
import rahulsaEcomPrac.PageObjects.ProductCatalogPageObjects;
import rahulsaEcomPrac.TestComponents.BaseTest;
import rahulsaEcomPrac.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {
	//WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Test(groups= {"Error Handling"}, retryAnalyzer=Retry.class)
	public void loginErrorValidate() throws Exception {
		LandingPageObjects Lp=launchApplication();
		Lp.Login("preetiagarwal.officiaal@gmail.com", "Bubba@11106");
		String msg=Lp.getErrorMsg();
		Assert.assertEquals(msg, "Incorrect email or password");
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void checkProductMismatch() throws Exception {
		LandingPageObjects Lp=launchApplication();
		ProductCatalogPageObjects Pc=Lp.Login("rahul.official@gmail.com", "Bubba@1106");
		String product = "ZARA COAT 3";
		Pc.addToCart(product);
		CartPageObjects cpo=Pc.goToCartPage();
		boolean match = cpo.matchProduct("ZARA COAT 33");
		Assert.assertTrue(match);
	}

}
