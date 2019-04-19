package Utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriver {

	public static WebDriver driver;
	private String browserName;

	public BrowserDriver(String browserName) {
		this.browserName = browserName;
	}

	public void initializeDriver() {
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources\\allBrowserDrivers\\chromedriver.exe");
			
			//System.setProperty(arg0, arg1);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "resources\\allBrowserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("IE Instance created");
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void navigateToUrl(String url)
	{
		driver.get(url);
	}

	public void closeDriver() {
		if (driver != null)
			driver.quit();
	}
}