package UiComponents;

public class Label extends UiElement {

	public Label(String locatorType, String locatorValue) {
		super(locatorType, locatorValue);
	}

public String getCssValue(String cssValue) {
	return this.getElement().getCssValue(cssValue);
}

}

