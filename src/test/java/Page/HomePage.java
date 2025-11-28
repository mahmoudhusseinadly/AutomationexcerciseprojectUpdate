package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {


        WebDriver driver;
        //////////////////////////Construcor//////////////////////////
        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        //////////////////////////locaters //////////////////////////

        By Delete_Account = By.xpath("//a[@href='/delete_account']");
        By Logout_Button = By.xpath("//a[@href='/logout']");

        //////////////////////////Actions//////////////////////////
        public void Logout(){
            driver.get("https://automationexercise.com/");
            driver.findElement(Logout_Button).click();
        }
        //////////////////////////Assertion//////////////////////////

        public void Assertionforvalidlogin(){
            Assert.assertTrue(driver.findElement(Delete_Account).isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
            Assert.assertTrue(driver.findElement(Logout_Button).isDisplayed());
        }


}
