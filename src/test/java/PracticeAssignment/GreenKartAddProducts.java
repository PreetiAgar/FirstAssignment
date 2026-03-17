/*Go to https://rahulshettyacademy.com/seleniumPractise/#/
 * Add the products brocoli, cucumber and tomato to cart and verify the count of 3 products added */
package PracticeAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class GreenKartAddProducts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] productList = {"Brocolli","Cucumber","Tomato"};
		List<String> actualList = Arrays.asList(productList);
		//fetch all elements and store in list
		//convert array to array list
		//format the text from elements and compare it with arraylist
		List<WebElement> products= driver.findElements(By.xpath("//h4[@class='product-name']"));
		Thread.sleep(2000);
		int j=0;
		System.out.println(products.size());
		for(int i=0; i< products.size(); i++) 
		{
			String name=(products.get(i)).getText().split("-")[0].trim();
			if(actualList.contains(name)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();//products.findElement not working here
			}if(j==actualList.size()) {
				break;
			}
		}
		Thread.sleep(3000);
		int count= Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'Items')]/following-sibling::td[2]")).getText());
		System.out.println(count);
		Assert.assertEquals(actualList.size(), count);

	}
}
