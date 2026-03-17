package PracticeAssignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> rows=driver.findElements(By.cssSelector(".table-display tr"));
		int rowCount=rows.size();
		System.out.println("No.of rows are "+rowCount+" ");
		List<WebElement> columns =driver.findElements(By.cssSelector(".table-display th"));
		int colCount=columns.size();
		System.out.println("No.of columns are "+colCount+" ");
		
	    System.out.println(driver.findElement(By.xpath("//table[@id='product']/tbody/tr[3]")).getText());	
	}

}
