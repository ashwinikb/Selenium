package com.ashwinikb.selenium.formy.project;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form {
	static WebDriver driver = new ChromeDriver();

	public static void formFill() throws InterruptedException {

		driver.get("http://formy-project.herokuapp.com/form");

		submitForm(driver);
		alertBanner(driver);
		// wait for page to load;
		Assert.assertEquals("The form was successfully submitted!", alertText(driver));

	}

	public static void submitForm(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("first-name")).sendKeys("Ashwini");
		driver.findElement(By.id("first-name")).sendKeys("Basava");
		driver.findElement(By.id("job-title")).sendKeys("Quality Engineer");
		driver.findElement(By.id("radio-button-3")).click();
		driver.findElement(By.cssSelector("option[value='1']")).click();
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		Thread.sleep(1000);
		datePicker.sendKeys("4/27/1990");
		Thread.sleep(1000);
		datePicker.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();

	}

	public static void alertBanner(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("alert"))));
	}

	public static String alertText(WebDriver driver) {
		String alertText = driver.findElement(By.className("alert")).getText();
		return alertText;
	}
}
