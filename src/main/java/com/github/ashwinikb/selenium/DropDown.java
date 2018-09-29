package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown {
	public static void menu() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/dropdown");
		
		WebElement menu = driver.findElement(By.id("dropdownMenuButton"));
		menu.click();
		Thread.sleep(2000);
		WebElement datePicker = driver.findElement(By.xpath("/html/body/div/div/div/a[4]"));
		datePicker.click();
	}
}
