/*Goto https://rahulshettyacademy.com/AutomationPractice/
 * Go to Web table example and scroll down within the table. amount total shown below as 296. 
 * Sum the contents of 4th column and verify it to be 296*/
package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class JEScrollWithinWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scroll(0,500)");
		je.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");//to scroll down within a Table(vertically),
		                                                                           //use scrollTop so that rows are pushed down
		List<WebElement> data = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i =0;i<data.size();i++) {
			sum= sum+Integer.parseInt(data.get(i).getText());
		}
		//String text=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		//String[] newText=text.split(":");
		//String actual= newText[1].trim();
		
		int actual= Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, actual);
		System.out.println("Passed");
	}

}
