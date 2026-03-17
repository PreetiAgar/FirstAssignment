package javaStreams;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class validateSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
		//click on sort button
		//capture all webelements in list
		//capture text of all elements and store in another arraylist
		//use sort method on this arraylist using Java streams
		//assert and compare both
		List<WebElement> items = driver.findElements(By.xpath("//tbody/tr"));
		//for (WebElement item : items){
			//String text =item.getText();
		List<String> inputList= items.stream().map(s->s.getText()).collect(Collectors.toList());
			//List<String> actualList=Arrays.asList(inputList);
			List<String> expectedList =inputList.stream().sorted().collect(Collectors.toList());
			Assert.assertFalse(inputList.equals(expectedList), "Sorting is correct");
		}
		
		
		
		
		
	}


