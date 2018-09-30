package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

	public static void switchwindows() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/switch-window");
		WebElement newtab = driver.findElement(By.id("new-tab-button"));
		newtab.click();

		String originalHandle = driver.getWindowHandle();
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		driver.switchTo().window(originalHandle);
		driver.quit();
	}

}
