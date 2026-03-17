package rahulsaEcomPrac.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulsaEcomPrac.PageObjects.CartPageObjects;
import rahulsaEcomPrac.PageObjects.LandingPageObjects;
import rahulsaEcomPrac.PageObjects.ProductCatalogPageObjects;
import rahulsaEcomPrac.TestComponents.BaseTest;


public class SubmitOrderTest extends BaseTest {
	WebDriver driver;
	String product = "ZARA COAT 3";
	@Test(dataProvider="getData")
	public void SubmitOrder(HashMap<String,String> input) throws Exception {

		LandingPageObjects Lp=launchApplication();
		ProductCatalogPageObjects Pc=Lp.Login(input.get("email"), input.get("password"));
		
		
		Pc.addToCart(input.get("product"));
		CartPageObjects cpo=Pc.goToCartPage();
		boolean match = cpo.matchProduct(input.get("product"));
		Assert.assertTrue(match);
		
		cpo.clickCheckout();
		cpo.selectCountry("India");
		cpo.clickPlaceOrder();
		Assert.assertTrue(cpo.confirmationMessage());
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+
				"//src/test//java//rahulsaEcomPrac//data//SubmitOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	/*public Object[][] getData(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "preetiagarwal.official@gmail.com");
		map.put("password", "Bubba@1106");
		map.put("product", "ZARA COAT 3");
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "rahuulshetty@gmail.com");
		map1.put("password", "xzyz");
		map1.put("product", "ZARA COAT 33");
		return new Object[][] {{map},{map1}};
	}*/
	
	

}
