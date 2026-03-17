package PracticeAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@placeholder=\"Type to Select Countries\"]")).sendKeys("unit");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]"));
		for(int i=0; i<options.size(); i++) {
			if(options.get(i).getText().equalsIgnoreCase("United States (USA)")){
				System.out.println(options.get(i).getText());
			options.get(i).click();
			break;
			}
		}
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));//to verify the input entered by user is correct
	}

}
