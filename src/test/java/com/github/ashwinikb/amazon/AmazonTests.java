package com.github.ashwinikb.amazon;

import com.github.ashwinikb.DriverSetUp;
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

public class AmazonTests {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        DriverSetUp setupTestDriver = new DriverSetUp(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }

    @Test(priority = 1)
    public void titleTest() {
        // validate page title test
        Assert.assertTrue(driver.getTitle().contentEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test(priority = 2)
    public void urlTest() {
        // validate current url test
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 3)
    public void searchTextBox() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Toys");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchButton = driver.findElement(By.cssSelector("input[type = 'submit']"));
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().back();
    }

    @Test(priority = 4)
    public void SignIn() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
        driver.findElement(By.id("ap_email")).sendKeys("ashwini.ash87@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("ashwini");
        driver.findElement(By.id("signInSubmit")).click();
        WebElement errorMessageBox = driver.findElement(By.id("auth-warning-message-box"));
        errorMessageBox.isDisplayed();
        driver.navigate().to("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
        driver.findElement(By.id("ap_email")).sendKeys("rosijohny1@gmail.com");
        driver.findElement(By.id("ap_password")).sendKeys("shopping");
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Test(priority = 5)
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

    @Test(priority = 6)
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


    @Test(priority = 6)
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {

    }

}