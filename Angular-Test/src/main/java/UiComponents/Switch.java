package UiComponents;

public class Switch extends UiElement {

	public Switch(String locatorType, String locatorValue) {
		super(locatorType, locatorValue);		
	}

	public void click() {
		//if(this.getElement().isEnabled())
		this.getElement().click();
	}	
	
	public boolean isEnabled() {
		return this.getElement().isEnabled();
	}
	
	public boolean isVisible() {
		return this.getElement().isDisplayed();
	}
}