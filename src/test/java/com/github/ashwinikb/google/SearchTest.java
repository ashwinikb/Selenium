package com.github.ashwinikb.google;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchTest {

	@Test
	void searchTest() throws InterruptedException, MalformedURLException {

		// create a Chrome Web Driver
		URL local = new URL("http://localhost:9515");
		WebDriver driver = new RemoteWebDriver(local, DesiredCapabilities.chrome());

		// open the browser and go to https://www.google.com
		driver.get("https://www.google.com");

		driver.findElement(By.name("q")).sendKeys("Selenium");

		Thread.sleep(2000);

		driver.findElement(By.name("btnK")).click();

		Thread.sleep(2000);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Selenium - Google Search";

		assertEquals(expectedTitle, actualTitle);

	}
}