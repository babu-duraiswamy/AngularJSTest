package UiComponents;

import org.openqa.selenium.Keys;

public class Dropdown extends UiElement {

	public Dropdown(String locatorType, String locatorValue) {
		super(locatorType, locatorValue);		
	}

	public void click() {
		if(this.getElement().isEnabled())
		this.getElement().click();
		this.getElement().sendKeys(Keys.TAB);
	}
	
		
}