package com.github.ashwinikb.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class FormTest {
	static WebDriver driver = new ChromeDriver();

	@Test
	void testFormFill() {

		driver.get("http://formy-project.herokuapp.com/form");

		try {
			Form.submitForm(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Form.alertBanner(driver);
		// wait for page to load;
		assertEquals("The form was successfully submitted!", Form.alertText(driver));

	}

	@Test
	void testSubmitForm() {
		fail("Not yet implemented");
	}

	@Test
	void testAlertBanner() {
		fail("Not yet implemented");
	}

	@Test
	void testAlertText() {
		fail("Not yet implemented");
	}

}
