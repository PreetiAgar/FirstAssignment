/*Go to amazon.com, type HELLO in text box and also select it. also mouse over to Hello Sign in and verify dropdown menu is shown*/
package PracticeAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClassPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement move= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		a.moveToElement(move).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		WebElement element= driver.findElement(By.xpath("//a[@data-nav-ref=\"nav_ya_signin\"]"));
		a.moveToElement(element).build().perform();
	}

}
