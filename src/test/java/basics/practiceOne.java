package basics;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
public class practiceOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	WebElement checkbox= driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
	checkbox.click();
	Assert.assertTrue(checkbox.isSelected());
	checkbox.click();
	Assert.assertFalse(checkbox.isSelected());
	List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label"));
	System.out.println("Number of checkboxes is "+checkboxes.size());
	}

}
