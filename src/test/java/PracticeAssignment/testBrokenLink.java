package PracticeAssignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.asserts.SoftAssert;

public class testBrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		
		List<WebElement> links=driver.findElements(By.xpath("//li[@class='gf-li']/a"));
	
		//pass the url tied to links to Java methods
		//capture the status code and compare with expected
		 SoftAssert a =new SoftAssert();
		
		for(int i=0;i<links.size();i++) {
		  String	url= links.get(i).getAttribute("href");
		  HttpURLConnection al =(HttpURLConnection) new URL(url).openConnection();
		  al.setRequestMethod("HEAD");
		  al.connect();
		  //Thread.sleep(2000);
		  int responseCode=al.getResponseCode();
		  System.out.println(responseCode);
		  a.assertTrue(al.getResponseCode()<400, "the link is broken" +links.get(i).getText()+ "with response code" +responseCode);
			
		}
		 a.assertAll();// this step is important to print all soft assertions which was failed but was kept on hold to complete TC execution.
	}

}
