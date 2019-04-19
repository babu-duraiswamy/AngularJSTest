package UiComponents;

import org.openqa.selenium.Keys;

import Utilities.Common;

public class Textbox extends UiElement {

	public Textbox(String locatorType, String locatorValue) {
		super(locatorType, locatorValue);

	}

	public void setText(String value) {
		if(this.getElement().isEnabled())
		this.getElement().sendKeys(value);
	}

	public void clearText() {
		if(this.getElement().isEnabled())
		this.getElement().clear();
	}

	public void typeEnter() {
		if(this.getElement().isEnabled())
			this.getElement().sendKeys(Keys.RETURN);		
	}
	
	public void typeTab() throws InterruptedException {
		if(this.getElement().isEnabled())
			this.getElement().sendKeys(Keys.TAB);
		Common.ShortWait();
	}

	public String getBorderColor() {
		return this.getElement().getCssValue("border-color");
	}
	
}
