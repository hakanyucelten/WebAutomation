package StepDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    private WebDriver driver;


    @Before
    public void setUp() {
        // Initialize WebDriver (ChromeDriver in this example)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Optionally, you can maximize the browser window or set other configurations
        driver.manage().window().maximize();
        driver.get("http://www.google.com.tr");
    }

    @Given("user is on the Google homepage")
    public void userIsOnGoogleHomepage() {

        // This step is used for navigation and is handled in @Before method
    }

    @When("user searches for {string}")
    public void userSearchesFor(String searchQuery) {
        WebElement WriteGmail = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        WriteGmail.sendKeys(searchQuery);
        WriteGmail.sendKeys(Keys.ENTER);
    }

    @And("user clicks on the {string} link")
    public void userClicksOnLink(String linkText) {
        WebElement link = driver.findElement(By.xpath("//*[@class='LC20lb MBeuO DKV0Md' and contains(text(),'" + linkText + "')]"));
        link.click();
    }

    @And("user clicks on the sign-in button")
    public void userClicksOnSignInButton() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@data-action='sign in']"));
        signInButton.click();
    }

    @Then("user should be on the Gmail sign-in page")
    public void userShouldBeOnSignInPage() {
        // Add assertions or verifications for the sign-in page
        // For example, you can verify the title of the page or a unique element on the sign-in page
        // Assert.assertTrue(driver.getTitle().contains("Gmail"));
    }


}
