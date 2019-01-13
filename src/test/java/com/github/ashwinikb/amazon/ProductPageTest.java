package com.github.ashwinikb.amazon;

import com.github.ashwinikb.DriverSetUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ProductPageTest {

    private static final Logger LOG = LogManager.getLogger(HomePageTest.class);

    public WebDriver driver;

    @Parameters({"os", "browser", "url", "node"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        DriverSetUp setupTestDriver = new DriverSetUp(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }

    @Test(priority = 1)
    public void productSearchTest(){
        String homePage = "https://www.amazon.com";
        driver.get(homePage);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Echo");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
        searchButton.isDisplayed();
        searchButton.click();
    }

    @Test(priority = 2)
    public void productPageTest(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)", "");
        driver.findElement(By.xpath("//*[@id=\"result_5\"]/div/div[2]/div/div[2]/div[1]/div[1]/a/h2")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement upgrade = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"a-autoid-36-announce\"]/div/div[1]/span")));
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.isDisplayed();
        addToCart.click();
    }

    @Test(priority = 3)
    public void checkOutItemsOnCart(){
        driver.findElement(By.xpath("//*[@id=\"nav-cart\"]/span[3]")).click();
        WebElement checkOutButton = driver.findElement(By.name("proceedToCheckout"));
        checkOutButton.isDisplayed();
        checkOutButton.click();
    }

}
