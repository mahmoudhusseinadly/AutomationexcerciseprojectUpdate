package Test;

import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {


        WebDriver driver;
        LoginPage loginPage;
        HomePage homePage;

        @BeforeMethod
        public void precondetions(){
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            options.addArguments("--incognito");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            homePage =new HomePage(driver);
            loginPage = new LoginPage(driver);
            loginPage.Navigatee();
        }
        @AfterMethod
        public void Tier_Down(){
            driver.quit();
        }



}
