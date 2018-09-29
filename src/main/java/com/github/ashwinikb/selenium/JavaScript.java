package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {
	
	public static void javascriptExec() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/modal");
		
		WebElement modalButton = driver.findElement(By.id("modal-button"));
		modalButton.click();
		
		WebElement closeButton = driver.findElement(By.id("close-button"));
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", closeButton);
	}

}
