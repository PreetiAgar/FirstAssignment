package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class paginationJavaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/Offers");
		//capture all elements and store in list
		List<WebElement> elements=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//capture the text and store in list
		List<String> productText=elements.stream().map(s->s.getText()).collect(Collectors.toList());
		//search for the text equals to Rice
		List<String> price;
		do 
		{		
			List<WebElement> p=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		price=p.stream().filter(s->s.getText().contains("Banana")).map(s->getPrice(s)).collect(Collectors.toList());

			if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).click();
			}
		}while(price.size()<1);
		System.out.println(price);

	}
	public static String getPrice(WebElement item) {
		String itemprice=item.findElement(By.xpath("following-sibling::td[1]")).getText();
		return itemprice;
	}
}
