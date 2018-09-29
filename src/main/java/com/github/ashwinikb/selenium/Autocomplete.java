package com.github.ashwinikb.selenium;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomplete {
	
	public static void autoCompleteForm() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://formy-project.herokuapp.com/autocomplete");
		
		WebElement address = driver.findElement(By.cssSelector("input[type='text']"));
		address.sendKeys("4312 albany Dr, san jose, CA");
		Thread.sleep(1000);

		WebElement autocompleteresult = driver.findElement(By.className("pac-item"));
		autocompleteresult.click();
		
		driver.quit();

		   }       
		
		
	}


