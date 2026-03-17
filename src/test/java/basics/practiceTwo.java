package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceTwo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("Preeti");
		driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys("preetiagarwal");
		driver.findElement(By.xpath("//div/input[@placeholder='Password']")).sendKeys("Bub");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		
		
	}

}
