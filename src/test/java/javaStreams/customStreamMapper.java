package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class customStreamMapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> products = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		List<String> sortedList=products.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		
		//Note here the price will come from webelement so use map method
		List<String> price = products.stream().filter(s ->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
		System.out.println(price);
	}
	public static String getPrice(WebElement element) {
		
		String price=element.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
