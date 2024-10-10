package sessionTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ParameterClass {
    private WebDriver driver;

    @Parameters(value = {"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        switch (browser) {
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Parameters(value = {"username", "password"})
    @Test
    public void validLoginTestCase(@Optional("admin") String username, @Optional("admin") String password) {
        driver.findElement(By.id("inputUsername")).sendKeys(username);
        driver.findElement(By.id("inputPassword")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
