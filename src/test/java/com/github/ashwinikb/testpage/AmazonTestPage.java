package com.github.ashwinikb.testpage;

import com.github.ashwinikb.driver.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
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

    @Test(priority = 1)
    public void googleTitleTest() {
        // validate page title test
        Assert.assertTrue(driver.getTitle().contentEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

    }

    @Test(priority = 2)
    public void googleUrlTest() {
        // validate current url test
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test(priority = 3)
    public void amazonSearchTextBox(){
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Toys");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement searchButton = driver.findElement(By.cssSelector("input[type = 'submit']"));
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.navigate().back();
    }

    @Test(priority = 4)
    public void SignIn(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
        driver.findElement(By.id("ap_email")).sendKeys("ashwini.ash87@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("ashwini");
        driver.findElement(By.id("signInSubmit")).click();
        WebElement errorMessageBox = driver.findElement(By.id("auth-warning-message-box"));
        errorMessageBox.isDisplayed();

    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){

    }

}