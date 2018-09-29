package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	public static void date() throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/datepicker");
	
		WebElement datePic = driver.findElement(By.id("datepicker"));
		Thread.sleep(2000);
		datePic.sendKeys("5/5/2019");
		Thread.sleep(2000);
		datePic.sendKeys(Keys.RETURN);
	}

}
