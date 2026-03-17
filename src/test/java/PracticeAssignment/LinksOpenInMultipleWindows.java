package PracticeAssignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksOpenInMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		driver.get("https://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement footerdriver=driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> links= columndriver.findElements(By.tagName("a"));
		
		for(int i =0;i<links.size();i++) {
			String clickontab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickontab);//sendkeys can be used to input enter in a textbox
			Thread.sleep(5000);
		}
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		//String parentid=it.next();
		//driver.switchTo().window()
		while(it.hasNext()) {
			System.out.println(driver.switchTo().window(it.next()).getTitle());
		}
		
		
		
	}
	
	
	
	

}
