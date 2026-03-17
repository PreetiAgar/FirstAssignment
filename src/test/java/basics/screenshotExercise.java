package basics;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.file.*;

public class screenshotExercise {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//add relevant dependencies in pom.xml and also download jars from common.apache 
																			//and add to classpath instead of Modulepath
		FileUtils.copyFile(src, new File("C:\\Users\\Preeti\\Documents\\screenshot.png"));//cannot copy file to C: drive directly so use User folder if no other drive
	}
}