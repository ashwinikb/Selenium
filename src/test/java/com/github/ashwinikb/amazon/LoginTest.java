package com.github.ashwinikb.amazon;

import com.github.ashwinikb.Configuration;
import com.github.ashwinikb.DriverSetUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest {

    private static final Logger LOG = LogManager.getLogger(LoginTest.class);

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        DriverSetUp setupTestDriver = new DriverSetUp(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }

    @Test(priority = 1)
    public void SignIn() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
        driver.findElement(By.id("ap_email")).sendKeys(Configuration.getConfigurationValue("amazon_login_id"));
        driver.findElement(By.id("ap_password")).sendKeys(Configuration.getConfigurationValue("amazon_login_password"));
        driver.findElement(By.id("signInSubmit")).click();
        WebElement errorMessageBox = driver.findElement(By.id("auth-warning-message-box"));
        errorMessageBox.isDisplayed();
        driver.navigate().to("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
        driver.findElement(By.id("ap_email")).sendKeys(Configuration.getConfigurationValue("amazon_login_id"));
        driver.findElement(By.id("ap_password")).sendKeys(Configuration.getConfigurationValue("amazon_login_password"));
        driver.findElement(By.id("signInSubmit")).click();
    }

}
