package sessionTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Dependencies {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("before suite");
    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("before Test");
    }
    @BeforeMethod
    public void setUp ()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void registerTC ()
    {
//        System.out.println("registerTC");
        Assert.fail();
    }

    @Test (dependsOnMethods = "registerTC" , alwaysRun = true)
    public void loginTC ()
    {
        System.out.println("loginTC");
    }

    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
