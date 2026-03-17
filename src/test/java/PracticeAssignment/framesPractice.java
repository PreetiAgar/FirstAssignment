package PracticeAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class framesPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		//driver.switchTo().frame("frameset-middle");
		driver.switchTo().frame("frame-middle");
		//driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name='frameset-middle']")));
		//driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
		driver.switchTo().defaultContent();

	}

}
