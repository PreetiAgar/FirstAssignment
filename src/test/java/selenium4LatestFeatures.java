import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
//import org.openqa.selenium.support.locators.RelativeLocator.*;
public class selenium4LatestFeatures {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Relative locators- above,below,toLeftOf, torightOf
		//Partial screenshot of webelement
		//Invoking(not only Handling)MULTIPLE WINDOWS
		//Get Height and width of WebElement for UX validation
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement name	=driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys("Hello");
		//Relative locator used
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(name)).getText());
		//webelement SS
		File src=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("logo.png"));
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windowIDs=driver.getWindowHandles();
		Iterator<String> it=windowIDs.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");
		driver.switchTo().window(parentWindow);// Note switch to default content doesn't work here so switched back to Parent window
		Thread.sleep(2000);
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		driver.findElement(RelativeLocator.with(By.cssSelector("xyz")));
		
		
	}

}
