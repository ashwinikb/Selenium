package com.ashwinikb.selenium.formy.project;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUp {
	
	public static void alertPop() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/switch-window");
		
		WebElement alertButton = driver.findElement(By.id("alert-button"));
		alertButton.click(); 
		
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		
		driver.quit();
		
	}

}
