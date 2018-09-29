package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
	public static void buttons() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/radiobutton");

		WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
		radioButton1.click();
		Thread.sleep(2000);
		WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
		radioButton2.click();
		Thread.sleep(2000);
		WebElement radioButton3 = driver.findElement(By.cssSelector("input[value='option3']"));
		radioButton3.click();
	}
}
