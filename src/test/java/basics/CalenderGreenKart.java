/*Go to https://rahulshettyacademy.com/seleniumPractise/#/offers
 * in the Datepicker calender set value as "07/25/2027"
 * Print the date set on the console and verify it is same as expected*/
package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class CalenderGreenKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		String month = "7";
		String date = "25";
		String year= "2027";
		String Expected[] = {month,date,year};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();//year selected
		List<WebElement> options= driver.findElements(By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']"));
		options.get(Integer.parseInt(month)-1).click(); //month selected
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		//to print the input date on console as getText will not give the date which was input
		List<WebElement> inputdate= driver.findElements(By.xpath("//input[contains(@class,'react-date-picker__inputGroup__input react-date-picker__inputGroup')]")); 
		for(int i=0;i<inputdate.size();i++) {
		Assert.assertEquals(inputdate.get(i).getAttribute("value"), Expected[i]);
		}
	}

}
