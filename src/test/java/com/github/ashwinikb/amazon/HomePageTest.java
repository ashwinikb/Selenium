package com.github.ashwinikb.amazon;

import com.github.ashwinikb.DriverSetUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class HomePageTest {

    private static final Logger LOG = LogManager.getLogger(HomePageTest.class);

    public WebDriver driver;

    @Parameters({"os", "browser", "url", "node"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        DriverSetUp setupTestDriver = new DriverSetUp(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }

    @Test(priority = 1)
    public void titleTest() {
//        WebElement element = driver.findElement(By.tagName("title"));
        Assert.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
        LOG.debug(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void searchText() {
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(element.isEnabled());
    }

    @Test(priority = 3)
    public void checkPrivacyNotice() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[5]/ul/li[2]/a"));

        String href = element.getAttribute("href");
        String cssClass = element.getAttribute("class");
        String text = element.getText();

        Assert.assertEquals("nav_a", cssClass);
        Assert.assertEquals("Privacy Notice", text);

        element.isDisplayed();
        element.click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
    }
}

