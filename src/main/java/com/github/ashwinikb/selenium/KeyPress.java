package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPress  {
	
	public static void keyPressForm() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/keypress");
		
		
		WebElement name = driver.findElement(By.id("name"));
		name.click();
		name.sendKeys("Ashwini");
		
		WebElement button = driver.findElement(By.id("button"));
		button.click();
		
		driver.quit();
		

	
}
}
