package com.github.ashwinikb.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void file() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/fileupload");

		WebElement file = driver.findElement(By.id("file-upload-field"));
		file.sendKeys("DSC_0048 copy.jpg");
	}
}
