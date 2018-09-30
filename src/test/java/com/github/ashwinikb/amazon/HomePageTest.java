package com.github.ashwinikb.amazon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePageTest {

	static URL local = null;
	static WebDriver driver = null;

	@BeforeAll
	public static void setup() {
		// create a Chrome Web Driver
		try {
			local = new URL("http://localhost:9515");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver = new RemoteWebDriver(local, DesiredCapabilities.chrome());

	}

	@Test
	void pageload() throws InterruptedException, MalformedURLException {

		// open the browser and go to https://www.google.com
		driver.get("https://www.amazon.com");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

		assertEquals(expectedTitle, actualTitle);

	}

	@Test
	void search() throws InterruptedException, MalformedURLException {

		// open the browser and go to https://www.google.com
		driver.get("https://www.amazon.com");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("book");

		Thread.sleep(2000);

		driver.findElement(By.className("nav-input")).click();

		Thread.sleep(2000);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com: book: Books";

		assertEquals(expectedTitle, actualTitle);

	}

}
