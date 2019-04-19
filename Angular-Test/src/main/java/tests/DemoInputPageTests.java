/*Author BABU.....*/
package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import Utilities.FileReader;
import pages.DemoInputPageFunctions;

public class DemoInputPageTests extends TestRunner {
	static Properties configValues = new Properties();
	static Properties demoInputPageControlsAndValues = new Properties();

	static String errorLabelColor = "rgb(221, 44, 0)";
	DemoInputPageFunctions demoInputPage;

	DemoInputPageTests() throws IOException {
		InputStream configStream = FileReader.class.getClassLoader().getResourceAsStream("Config.properties");
		InputStream demoInputControlsAndValuesStream = FileReader.class.getClassLoader()
				.getResourceAsStream("DemoInputPageControlsAndValues.properties");
		configValues.load(configStream);
		demoInputPageControlsAndValues.load(demoInputControlsAndValuesStream);
		demoInputPage = new DemoInputPageFunctions();
	}

	@Test
	public void testInvalidEmail() throws InterruptedException {
		String userEmail = demoInputPageControlsAndValues.getProperty("invalidUserEmail");
		String userEmailTextbox = demoInputPageControlsAndValues.getProperty("userEmailTextbox");

		String emailBorderColor = demoInputPage.fillFieldAndReturnBorderColor(userEmailTextbox, userEmail);
		assertTrue(emailBorderColor.equals(errorLabelColor), "Email format validation not working");
	}

	@Test
	public void testValidEmail() throws InterruptedException {
		String userTitle = demoInputPageControlsAndValues.getProperty("userTitle");
		String userEmail = demoInputPageControlsAndValues.getProperty("validUserEmail");
		String userTitleTextbox = demoInputPageControlsAndValues.getProperty("userTitleTextbox");
		String userEmailTextbox = demoInputPageControlsAndValues.getProperty("userEmailTextbox");
		demoInputPage.fillField(userTitleTextbox, userTitle);
		String emailBorderColor = demoInputPage.fillFieldAndReturnBorderColor(userEmailTextbox, userEmail);
		assertFalse(emailBorderColor.equals(errorLabelColor), "Error shown wrongly");
	}

	@Test
	public void testInvalidDate() throws InterruptedException {
		String dateTextbox = demoInputPageControlsAndValues.getProperty("dateTextbox");
		String invalidDate = demoInputPageControlsAndValues.getProperty("invalidDate");
		String dateBorderColor = demoInputPage.fillFieldAndReturnBorderColor(dateTextbox, invalidDate);
		assertTrue(dateBorderColor.equals(errorLabelColor));
	}

	@Test
	public void testInvalidPostalcode() throws InterruptedException {
		String postalcodeTextbox = demoInputPageControlsAndValues.getProperty("postalcodeTextbox");
		String invalidPostalcode = demoInputPageControlsAndValues.getProperty("invalidPostalcode1");
		String postalcodeBorderColor = demoInputPage.fillFieldAndReturnBorderColor(postalcodeTextbox,
				invalidPostalcode);
		assertTrue(postalcodeBorderColor.equals(errorLabelColor), "postalcode format validation not working");
	}

	@Test
	public void testInvalidPostalcodeErr1() throws InterruptedException {
		String postalcodeTextbox = demoInputPageControlsAndValues.getProperty("postalcodeTextbox");
		String invalidPostalcode = demoInputPageControlsAndValues.getProperty("invalidPostalcode1");
		String postalcodeBorderColor = demoInputPage.fillFieldAndReturnBorderColor(postalcodeTextbox,
				invalidPostalcode);
		assertTrue(postalcodeBorderColor.equals(errorLabelColor), "postalcode format validation not working");
		String ExpectedErrMessage1 = demoInputPageControlsAndValues.getProperty("postalcodeErrorMsg1");
		String ExpectedErrMessage2 = demoInputPageControlsAndValues.getProperty("postalcodeErrorMsg2");
		String ErrMsgAct = demoInputPage
				.getErrorMessage(demoInputPageControlsAndValues.getProperty("postalCodeErrorMessageLabel"));
		assertTrue(ErrMsgAct.contains(ExpectedErrMessage1) && ErrMsgAct.contains(ExpectedErrMessage2));
	}

	@Test
	public void testInvalidPostalcodeErr2() throws InterruptedException {
		String postalcodeTextbox = demoInputPageControlsAndValues.getProperty("postalcodeTextbox");
		String invalidPostalcode = demoInputPageControlsAndValues.getProperty("invalidPostalcode2");
		String postalcodeBorderColor = demoInputPage.fillFieldAndReturnBorderColor(postalcodeTextbox,
				invalidPostalcode);
		assertTrue(postalcodeBorderColor.equals(errorLabelColor), "postalcode format validation not working");
		String ExpectedErrMessage1 = demoInputPageControlsAndValues.getProperty("postalcodeErrorMsg1");
		String ErrMsgAct = demoInputPage
				.getErrorMessage(demoInputPageControlsAndValues.getProperty("postalCodeErrorMessageLabel"));
		assertTrue(ErrMsgAct.trim().equals(ExpectedErrMessage1.trim()));
	}

	@Test
	public void testShowHintsErrors() throws InterruptedException {
		// String showHintsErrorsSwitch =
		// demoInputPageControlsAndValues.getProperty("showHintsErrorsSwitch");
		String showHintsErrorsLabel = demoInputPageControlsAndValues.getProperty("showHintsErrorsLabel");
		Boolean switchState = demoInputPage.isSwitchOn(showHintsErrorsLabel,
				demoInputPageControlsAndValues.getProperty("showingHintsText"));
		assertTrue(switchState);
//		demoInputPage.changeSwitchState(showHintsErrorsLabel);
//		switchState = demoInputPage.isSwitchOn(showHintsErrorsLabel,
//				demoInputPageControlsAndValues.getProperty("showingErrorsText"));
//		assertTrue(switchState);
	}

	@Test
	public void testValidClientName() throws InterruptedException {
		String clientNameTextbox = demoInputPageControlsAndValues.getProperty("clientNameTextbox");
		String validClientName = demoInputPageControlsAndValues.getProperty("validClientName");
		String clientBorderColor = demoInputPage.fillFieldAndReturnBorderColor(clientNameTextbox, validClientName);
		assertFalse(clientBorderColor.equals(errorLabelColor));
	}

	@Test
	public void testInvalidClientName() throws InterruptedException {
		String clientNameTextbox = demoInputPageControlsAndValues.getProperty("clientNameTextbox");
		String invalidClientName = demoInputPageControlsAndValues.getProperty("invalidClientName");
		String clientBorderColor = demoInputPage.fillFieldAndReturnBorderColor(clientNameTextbox, invalidClientName);
		assertTrue(clientBorderColor.equals(errorLabelColor));

		String clientNameRequiredMessageLabel = demoInputPageControlsAndValues
				.getProperty("clientNameRequiredMessageLabel");
		assertTrue(demoInputPage.getErrorMessage(clientNameRequiredMessageLabel)
				.contains(demoInputPageControlsAndValues.getProperty("clientNameRequiredMessage")));
	}

	@Test
	public void testBlankProjectType() throws InterruptedException
	{
		String projectTypeDropdown = demoInputPageControlsAndValues.getProperty("projectTypeDropdown");
		demoInputPage.selectControl(projectTypeDropdown);
		String borderColor=demoInputPage.getBorderColor(projectTypeDropdown);
		assertTrue(borderColor.equals(errorLabelColor));

	}

	@Test
	public void testInvalidClientEmail() throws InterruptedException
	{
		String clientEmailTextbox = demoInputPageControlsAndValues.getProperty("clientEmailTextbox");
		String invalidClientEmail = demoInputPageControlsAndValues.getProperty("invalidClientEmail");
		String clientEmailBorderColor= demoInputPage.fillFieldAndReturnBorderColor(clientEmailTextbox, invalidClientEmail);
		assertTrue(clientEmailBorderColor.equals(errorLabelColor));			
		
		String clientEmailValidationMessageLabel = demoInputPageControlsAndValues.getProperty("clientEmailValidationMessageLabel");
		assertTrue(demoInputPage.getErrorMessage(clientEmailValidationMessageLabel).
				contains(demoInputPageControlsAndValues.getProperty("clientEmailValidationMessage")));	
	}

	@Test
	public void testValidClientEmail() throws InterruptedException {
		String clientEmailTextbox = demoInputPageControlsAndValues.getProperty("clientEmailTextbox");
		String validClientEmail = demoInputPageControlsAndValues.getProperty("validClientEmail");
		String clientEmailBorderColor = demoInputPage.fillFieldAndReturnBorderColor(clientEmailTextbox,
				validClientEmail);
		assertFalse(clientEmailBorderColor.equals(errorLabelColor));
	}

	@Test
	public void testInvalidHourlyRateMin() throws InterruptedException {
		String hourlyRate = demoInputPageControlsAndValues.getProperty("hourlyRate");
		String invalidHourlyRate1 = demoInputPageControlsAndValues.getProperty("invalidHourlyRate1");
		String hourlyRateBorderColor = demoInputPage.fillFieldAndReturnBorderColor(hourlyRate, invalidHourlyRate1);
		assertTrue(hourlyRateBorderColor.equals(errorLabelColor));
		String hourlyRateValidationMessageLabel = demoInputPageControlsAndValues
				.getProperty("hourlyRateValidationMessageLabel");
		assertTrue(demoInputPage.getErrorMessage(hourlyRateValidationMessageLabel)
				.contains(demoInputPageControlsAndValues.getProperty("hourlyRateValidationMessage1")));
	}

	@Test
	public void testInvalidHourlyRateMax() throws InterruptedException {
		String hourlyRate = demoInputPageControlsAndValues.getProperty("hourlyRate");
		String invalidHourlyRate2 = demoInputPageControlsAndValues.getProperty("invalidHourlyRate2");
		String hourlyRateBorderColor = demoInputPage.fillFieldAndReturnBorderColor(hourlyRate, invalidHourlyRate2);
		assertTrue(hourlyRateBorderColor.equals(errorLabelColor));

		String hourlyRateValidationMessageLabel = demoInputPageControlsAndValues
				.getProperty("hourlyRateValidationMessageLabel");
		assertTrue(demoInputPage.getErrorMessage(hourlyRateValidationMessageLabel)
				.contains(demoInputPageControlsAndValues.getProperty("hourlyRateValidationMessage2")));
	}

	@Test
	public void testInvalidHourlyRateTooHigh() throws InterruptedException {
		String hourlyRate = demoInputPageControlsAndValues.getProperty("hourlyRate");
		String invalidHourlyRateTooHigh = demoInputPageControlsAndValues.getProperty("invalidHourlyRateTooHigh");
		String hourlyRateBorderColor = demoInputPage.fillFieldAndReturnBorderColor(hourlyRate,
				invalidHourlyRateTooHigh);
		assertTrue(hourlyRateBorderColor.equals(errorLabelColor));

		String hourlyRateValidationMessageLabel = demoInputPageControlsAndValues
				.getProperty("hourlyRateValidationMessageLabel");
		assertTrue(demoInputPage.getErrorMessage(hourlyRateValidationMessageLabel)
				.contains(demoInputPageControlsAndValues.getProperty("hourlyRateValidationMessage2")));
	}

	@Test
	public void testValidHourlyRate() throws InterruptedException {
		String hourlyRate = demoInputPageControlsAndValues.getProperty("hourlyRate");
		String validHourlyRate = demoInputPageControlsAndValues.getProperty("validHourlyRate");
		String hourlyRateBorderColor = demoInputPage.fillFieldAndReturnBorderColor(hourlyRate, validHourlyRate);
		assertFalse(hourlyRateBorderColor.equals(errorLabelColor));
	}

	@Test
	public void testExceededLimitBiography() throws InterruptedException {

		String biographyTextArea = demoInputPageControlsAndValues.getProperty("biographyTextArea");
		String exceededLimitBiography = demoInputPageControlsAndValues.getProperty("exceededLimitBiography");
		String BorderColor = demoInputPage.fillFieldAndReturnBorderColor(biographyTextArea, exceededLimitBiography);
		assertTrue(BorderColor.equals(errorLabelColor));
	}

	@Test
	public void testAllowedLimitBiography() throws InterruptedException {
		String biographyTextArea = demoInputPageControlsAndValues.getProperty("biographyTextArea");
		String allowedLimitBiography = demoInputPageControlsAndValues.getProperty("allowedLimitBiography");
		String BorderColor = demoInputPage.fillFieldAndReturnBorderColor(biographyTextArea, allowedLimitBiography);
		assertFalse(BorderColor.equals(errorLabelColor));
	}
	@Test
	public void testvalidPhoneNumber() throws InterruptedException {
		String phoneNumberTextbox = demoInputPageControlsAndValues.getProperty("phoneNumberTextbox");
		String validPhoneNumber = demoInputPageControlsAndValues.getProperty("validPhoneNumber");
		String BorderColor = demoInputPage.fillFieldAndReturnBorderColor(phoneNumberTextbox,
				validPhoneNumber);
		assertFalse(BorderColor.equals(errorLabelColor));
	}
	@Test
	public void testinvalidPhoneNumber() throws InterruptedException {
		String phoneNumberTextbox = demoInputPageControlsAndValues.getProperty("phoneNumberTextbox");
		String invalidPhoneNumber = demoInputPageControlsAndValues.getProperty("invalidPhoneNumber");
		String BorderColor = demoInputPage.fillFieldAndReturnBorderColor(phoneNumberTextbox,
				invalidPhoneNumber);
		assertTrue(BorderColor.equals(errorLabelColor), "PhoneNumber format validation not working");
	}
	@Test
	public void testvalidSsn() throws InterruptedException {
		String ssnTextbox = demoInputPageControlsAndValues.getProperty("ssnTextbox");
		String validssn = demoInputPageControlsAndValues.getProperty("validssn");
		String BorderColor = demoInputPage.fillFieldAndReturnBorderColor(ssnTextbox,
				validssn);
		assertFalse(BorderColor.equals(errorLabelColor));
	}
	@Test
	public void testinvalidSsn() throws InterruptedException {
		String ssnTextbox = demoInputPageControlsAndValues.getProperty("ssnTextbox");
		String invalidssn = demoInputPageControlsAndValues.getProperty("invalidssn");
		String BorderColor = demoInputPage.fillFieldAndReturnBorderColor(ssnTextbox,
				invalidssn);
		assertTrue(BorderColor.equals(errorLabelColor), "PhoneNumber format validation not working");
	}
}