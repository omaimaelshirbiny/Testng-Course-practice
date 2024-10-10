package sessionTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Assertions {

    //  public Logger LOGGER = LogManager.getLogger();
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1, groups = {"regrission", "broken"})
    public void validLoginTestCase() {
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.id("loginButton")).click();
//        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

        boolean x = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        Assert.assertTrue(x);
    }

    @Test(priority = 7, groups = {"regrission"})
    public void hardInValidLoginTestCase() {
        //  LOGGER.info("testcase stararted");
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        //    LOGGER.info("username is written");
        driver.findElement(By.id("inputPassword")).sendKeys("aa");
        //    LOGGER.info("password is written");
        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().alert().accept();
//        Thread.sleep(5000);
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

        boolean x = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        Assert.assertFalse(x, "in invalid senario expected and actual result are not equal");//added message
    }

    @Ignore
    @Test
    public void softInValidLoginTestCase() {

        softAssert = new SoftAssert();
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("aa");
        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().alert().accept();
//        Thread.sleep(5000);
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

        boolean x = driver.getCurrentUrl().equals("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        softAssert.assertFalse(x, "in invalid senario expected and actual result are not equal");//added message
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
