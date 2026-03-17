package rahulsaEcomPrac.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulsaEcomPrac.PageObjects.LandingPageObjects;

public class BaseTest {
	public WebDriver driver;
	public LandingPageObjects Lp;

	public WebDriver intializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//rahulsaEcomPrac//resources//GlobalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		return driver;
	}

	@BeforeMethod
	public LandingPageObjects launchApplication() throws Exception {
		try {
			driver = intializeDriver();
			Lp = new LandingPageObjects(driver);
			Lp.goTo();
		} catch (Exception e) {
			System.out.println(e);
		}
		return Lp;

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		// read json file as string
		@SuppressWarnings("deprecation")
		String fileContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// Jackson Databind to convert string to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(fileContent,
				new TypeReference<List<HashMap<String, String>>>(){}
		);

		return data;
	}
	
	public String getScreenshot(String testName,WebDriver driver) throws IOException {
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File file=new File(System.getProperty("user.dir") + "/reports/" +testName+".png");
		 FileUtils.copyFile(src,file);
		 return System.getProperty("user.dir") + "/reports/" +testName+".png";
	}
}
