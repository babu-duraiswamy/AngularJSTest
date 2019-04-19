package Utilities;
import org.openqa.selenium.By;
public class Locate {

	public static By getLocator(String locatorType, String locatorValue) {
		switch (locatorType) {
		case "Id":
			return By.id(locatorValue);
		case "Name":
			return By.name(locatorValue);
		case "ClassName":
			return By.className(locatorValue);
		case "LinkText":
			return By.linkText(locatorValue);
		case "PartialLinkText":
			return By.tagName(locatorValue);
		case "XPath":
			return By.xpath(locatorValue);
		case "CssSelector":
			return By.cssSelector(locatorValue);
		default:
			return null;
		}
	}
}