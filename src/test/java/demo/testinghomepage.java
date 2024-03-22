package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testinghomepage {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path for ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\TY 6TH SEM\\DEVOPS\\chromedriver-win64\\chromedriver.exe");
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to the application's homepage URL
        driver.get("http://127.0.0.1:5500/New%20folder/admin.html");
    }

    @Test(priority = 1)
    public void testHomePageLoad() {
        // Verify if Home Page loads successfully
        Assert.assertTrue(driver.getTitle().contains("Admin Page"), "Home Page did not load successfully.");
    }

    @Test(priority = 3)
    public void testNavigationLinks() {
        // Click on the Login link
        WebElement loginLink = driver.findElement(By.xpath("/html/body/nav/a[4]"));
        loginLink.click();
        // Verify redirection to Login Page
        Assert.assertTrue(driver.getCurrentUrl().contains("http://127.0.0.1:5500/New%20folder/login.html"), "Did not redirect to Login Page.");
    }

        // Navigate back to Home Page
     
    @Test(priority = 2)
    public void testEssentialInformation() {
        // Check for essential information on the Home Page
        WebElement essentialInfoElement = driver.findElement(By.xpath("/html/body/header/h1"));
        // Verify if essential information is displayed
        Assert.assertTrue(essentialInfoElement.isDisplayed(), "Essential information is not displayed on the Home Page.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser window
        driver.quit();
    }
}
