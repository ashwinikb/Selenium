package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
	public static void buttons() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/checkbox");
		
		WebElement checkBox1 = driver.findElement(By.id("checkbox-1"));
		checkBox1.click();
		Thread.sleep(2000);
		WebElement checkBox2 = driver.findElement(By.id("checkbox-2"));
		checkBox2.click();
		Thread.sleep(2000);
		WebElement checkBox3 = driver.findElement(By.id("checkbox-3"));
		checkBox3.click();
	}
}
