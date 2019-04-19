package UiComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utilities.BrowserDriver;
import Utilities.Locate;

public class UiElement {

	private By by;
	WebDriver driver = BrowserDriver.driver;

	UiElement(String locatorType, String locatorValue) {
		this.by = Locate.getLocator(locatorType, locatorValue);
	}
	public WebElement getElement() {
		return driver.findElement(this.by);
	}
	
	public String getText() {
		return this.getElement().getText();
	}
}