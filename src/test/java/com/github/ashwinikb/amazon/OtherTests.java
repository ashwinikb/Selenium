package com.github.ashwinikb.amazon;

import com.github.ashwinikb.DriverSetUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OtherTests {

    private static final Logger LOG = LogManager.getLogger(OtherTests.class);

    public WebDriver driver;

    @Parameters({"os", "browser", "url", "node"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        DriverSetUp setupTestDriver = new DriverSetUp(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }

    @Test(priority = 1)
    public void titleTest() {
        // validate page title test
        Assert.assertTrue(driver.getTitle().contentEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
        LOG.debug(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void urlTest() {
        // validate current url test
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
        LOG.debug(driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test(priority = 3)
    public void myAmazon() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)", "");
        driver.findElement(By.id("nav-your-amazon-text")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> allOptions = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div[2]/div[6]/ul/div[7]/li/span/span/div[1]/div[2]"));
        for (WebElement we : allOptions) {
            if (we.getText().contains("New Movie Releases in Amazon Video")) {
                driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[6]/ul/div[7]/li/span/span/div[2]")).click();
            }
        }
        Actions action1 = new Actions(driver);
        action1.moveToElement(driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[4]/ul/div[9]/div[2]/div/div[2]/div/div/div/ol/li[5]/div/div[1]/a/div[1]/img"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/Hotel-Transylvania-3-Bonus-Content/dp/B07FCW6RXT/ref=pd_ys_c_mepd_ys_sf_s_dnr_2858905011_4?_encoding=UTF8&pd_rd_i=B07FCW6RXT&pd_rd_r=QW103593ZSMP5EKYXMYD&pd_rd_w=vPDv1&pd_rd_wg=OnDWl&psc=1&refRID=VKN0Y2PDW17GFWKDTAY9"));

    }


    @Test(priority = 4)
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {

    }

}