package basics;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeOptionsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Preeti\\Downloads\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);// navigating to unsafe urls anyway
		//options.addExtensions(""); to add extensions to browser, give the extension path
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444"); //ask the support team which type of proxy is to be set, normally it is http
		options.setCapability("proxy", proxy);
		
		Map<String, Object> prefs = new HashMap<String, Object>(); //download this code from chrome options official selenium page
		prefs.put("download.default_directory", "/directory/path");// to download the files by webdriver at a specified location
		options.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
