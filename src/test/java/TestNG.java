import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import java.lang.System;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Epic("First Test")
@Feature("Login Test")
public class TestNG {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver and navigate to the website (runs before each test)
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com.tr/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Close the browser and perform cleanup (runs after each test)
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin() {
        // Login test steps
        WebElement WriteGmail = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        WriteGmail.sendKeys("Gmail");
        WriteGmail.sendKeys(Keys.ENTER);

        WebElement findGmail = driver.findElement(By.xpath("//*[@class='LC20lb MBeuO DKV0Md']"));
        findGmail.click();

        WebElement signInButton = driver.findElement(By.xpath("//*[@data-action='sign in']"));
        signInButton.click();

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", "image/png", Arrays.toString(screenshot), "png");
    }




}
