package com.github.ashwinikb.amazon;

import com.github.ashwinikb.DriverSetUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DealsTest {

    private static final Logger LOG = LogManager.getLogger(DealsTest.class);

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        DriverSetUp setupTestDriver = new DriverSetUp(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }


    @Test(priority = 1)
    public void deals() {
        driver.findElement(By.linkText("Today's Deals")).click();
        driver.findElement(By.xpath("//*[@id=\"widgetFilters\"]/div[1]/div[2]/span[7]/div/label/input")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//*[@id=\"widgetFilters\"]/div[4]/span[1]/div/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"widgetFilters\"]/div[5]/span[1]/div/a")).click();
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"100_dealView_0\"]/div/div[2]/div/div/div[8]/div/span/span/span/button")).click();
        WebElement successMessageBox = driver.findElement(By.className("a-alert-content"));
        successMessageBox.isDisplayed();
    }

}
