package pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import UiComponents.Dropdown;
import UiComponents.Label;
import UiComponents.Switch;
import UiComponents.Textbox;
import Utilities.FileReader;

public class DemoInputPageFunctions {
	static Properties demoInputPageControlsAndValues = new Properties();

	public DemoInputPageFunctions() throws IOException {
		InputStream demoInputPageStream = FileReader.class.getClassLoader()
				.getResourceAsStream("DemoInputPageControlsAndValues.properties");
		demoInputPageControlsAndValues.load(demoInputPageStream);
	}

	public void fillField(String controlName, String fieldValue) throws InterruptedException {
		Textbox textbox = new Textbox("XPath", controlName);
		textbox.clearText();
		textbox.setText(fieldValue);
	}

	public String getLabelColor(String controlName) {
		Label label = new Label("XPath", controlName);
		return (label.getCssValue("Color"));
	}

	public String fillFieldAndReturnBorderColor(String controlName, String fieldValue) throws InterruptedException {
		Textbox textbox = new Textbox("XPath", controlName);
		textbox.clearText();
		textbox.setText(fieldValue);
		textbox.typeTab();
		textbox.getBorderColor();
		return textbox.getBorderColor();
	}

	public String getErrorMessage(String controlName) {
		Label label = new Label("XPath", controlName);
		
		if(label.getText()!="")
			return label.getText();
		else
			return("No error message shown");
	}

	public Boolean isSwitchOn(String controlName, String switchText) {
		Label label = new Label("XPath", controlName);
		if (label.getText().contains(switchText))
			return true;
		else
			return false;
	}

	public void changeSwitchState(String controlName) {
		Switch flag = new Switch("XPath", controlName);
		flag.click();
	}

	public void selectControl(String controlName) {
		Dropdown list= new Dropdown("XPath", controlName);
		list.click();			
	}
	
	public String getBorderColor(String controlName) {
		Dropdown list= new Dropdown("XPath", controlName);
		return list.getElement().getCssValue("border-color");			
	}	
}