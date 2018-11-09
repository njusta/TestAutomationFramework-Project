package utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseClass {
	public static WebDriver driver = null;
	CommonUtils envFileReader;

	@BeforeSuite
	public void openApplication() {
		Reporter.log("=== Browser Session Started ===");
		switch (CommonUtils.LocalBrowser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", CommonUtils.ChromeDriverPath);
			driver = new ChromeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", CommonUtils.IEDriverPath);
			driver = new InternetExplorerDriver();
			break;
		
		}
		
		driver.manage().window().maximize();
		driver.navigate().to(CommonUtils.ApplicatonURL);
		Reporter.log("=== Application Started ===");
		driver.manage().timeouts().implicitlyWait(CommonUtils.ImplicitlyWait, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void closeApplication() {
		driver.quit();
		Reporter.log("=== Browser Session Ended ===");
	}
}
