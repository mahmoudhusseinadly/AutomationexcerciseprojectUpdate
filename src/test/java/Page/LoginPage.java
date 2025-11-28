package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

        /// ////////////////////////locaters////////////////////////////////
        WebDriver driver;
        By Email = By.xpath("//input[@data-qa='login-email']");
        By Password_input = By.xpath("//input[@name=\"password\"]");
        By Login_button = By.xpath("//button[@type=\"submit\"]");
        By message = By.xpath("//input[@type=\"password\"]");


        /// ////////////////constructor//////////////////////////
        public LoginPage(WebDriver driver) {
            this.driver=driver;
        }

        /// /////////////////////Actions//////////////////////////
        public void login(String mail, String password){
            driver.findElement(Email).sendKeys(mail);
            driver.findElement(Password_input).sendKeys(password);
            driver.findElement(Login_button).click();
        }


        public void Navigatee(){
            driver.get("https://automationexercise.com/login");
        }

        /// //////////////////////////////Assertion///////////////////
        public void AssertionforInvalidlogin(){
            Assert.assertTrue(driver.findElement(By.xpath("//p[@style=\"color: red;\"]")).isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
            Assert.assertTrue(driver.findElement(message).isDisplayed());
        }

        public void AssertForEmptyEmailForLogin() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean submitted = (boolean) js.executeScript("return window.formSubmitted;");
            Assert.assertFalse(submitted);
        }

        public void Assertforvalidlogout(){
            Assert.assertTrue(driver.findElement(Email).isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
            Assert.assertTrue(driver.getTitle().equals("Automation Exercise - Signup / Login"));
        }


}
