package UiComponents;

public class Button extends UiElement {

	public Button(String locatorType, String locatorValue) {
		super(locatorType, locatorValue);		
	}

	public void click() {
		if(this.getElement().isEnabled())
		this.getElement().click();
	}
	
	public boolean isEnabled() {
		return this.getElement().isEnabled();
	}	
}