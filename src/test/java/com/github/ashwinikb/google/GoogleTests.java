package com.github.ashwinikb.google;

import com.github.ashwinikb.DriverSetUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class GoogleTests {

    private static final Logger LOG = LogManager.getLogger(GoogleTests.class);

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        DriverSetUp setupTestDriver = new DriverSetUp(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }

    @Test(priority = 1)
    public void search() {
        driver.get("https://www.google.com");
        driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
        driver.findElement(By.name("btnK")).click();
        driver.manage().window().maximize();
    }

}
