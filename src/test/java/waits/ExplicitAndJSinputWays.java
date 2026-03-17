/*Go to https://rahulshettyacademy.com/loginpagePractise/ 
 * enter username-rahulshetty and pw-learning, select radio button as User and click on Okay in the pop up.
 * Select Consultant from dropdown and click on Sign in
 * Verify user is signed in by grabbing the title of page after login*/
package waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitAndJSinputWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
				//WebDriverWait(5, TimeUnit.SECONDS);//CHANGED SYNTAX from Selenium4.0
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
		
		//je.executeScript("arguments[0].setAttribute('value','rahulshettyacademy')",element);
		je.executeScript("arguments[0].value='rahulshettyacademy';",element);	
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
		driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Okay')]"))).click();
		
		WebElement dropdown= driver.findElement(By.xpath("//select[@class='form-control']"));
		dropdown.click();
		Select s=new Select(dropdown);
		s.selectByVisibleText("Consultant");
		
		
		
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value=\"consult\"]"))).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		w.until(ExpectedConditions.titleContains("ProtoCommerce"));
		System.out.println(driver.getTitle());
		

	}

}
