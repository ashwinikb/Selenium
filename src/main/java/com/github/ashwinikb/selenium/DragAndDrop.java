package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void image() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/dragdrop");
		Thread.sleep(1000);

		WebElement image = driver.findElement(By.id("image"));
		
		WebElement box = driver.findElement(By.id("box"));
		
		Actions actions = new Actions(driver);
		Thread.sleep(1000);
		actions.dragAndDrop(image, box).build().perform();
		Thread.sleep(1000);

	}

}
