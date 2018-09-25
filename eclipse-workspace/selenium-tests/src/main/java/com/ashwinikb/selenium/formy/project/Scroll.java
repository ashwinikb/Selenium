package com.ashwinikb.selenium.formy.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scroll {
	public static void scrollFill() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/scroll");
		
		WebElement name = driver.findElement(By.id("name"));
		//To Scroll down.
		Actions action = new Actions(driver);
		action.moveToElement(name);
		name.sendKeys("Ashwini");
		WebElement date = driver.findElement(By.id("date"));
		date.sendKeys("5/5/2018");
		driver.quit();
		
	}

}
