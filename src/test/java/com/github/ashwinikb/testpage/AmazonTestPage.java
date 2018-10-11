package com.github.ashwinikb.testpage;

import com.github.ashwinikb.driver.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AmazonTestPage{
    public  WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        DriverSetUp setupTestDriver = new DriverSetUp(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }

    @Test
    public void googleTitleTest() {
        // validate page title test
        Assert.assertTrue(driver.getTitle().contentEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
    }

    @Test
    public void googleUrlTest() {
        // validate current url test
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
    }

    @Test
    public void amzonSearchTextBox(){
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Toys");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement searchButton = driver.findElement(By.cssSelector("input[type = 'submit']"));
        searchButton.click();
        driver.navigate().back();
    }


    @AfterClass(alwaysRun = true)
    public void closeBrowser(){

    }

}