package Test;

import Page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


        @Test
        public void Login_with_valid_username_password(){
            loginPage.login("mahmoudhusseinadly1@gmail.com","Test@1632");
            homePage.Assertionforvalidlogin();
        }
        @Test
        public void Login_with_invalid_username_valid_password(){
            loginPage = new LoginPage(driver);
            loginPage.login("mahmoudhussein@gmail.com","Test@1632");
            loginPage.AssertionforInvalidlogin();
        }
        @Test
        public void Login_with_valid_username_invalid_password(){
            loginPage = new LoginPage(driver);
            loginPage.login("mahmoudhusseinadly1@gmail.com","Test@1234");
            loginPage.AssertionforInvalidlogin();
                    
        }

        @Test
        public void Login_with_invalid_username_invalid_password(){
            loginPage = new LoginPage(driver);
            loginPage.login("mahmoud@gmail.com","Test@1234");
            loginPage.AssertionforInvalidlogin();


    }
        @Test
        public void Empty_filed_Login_click(){
            loginPage = new LoginPage(driver);
            WebElement form = driver.findElement(By.xpath("//form[@action='/login']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "window.formSubmitted = false;" +
                            "arguments[0].addEventListener('submit', function(e) {" +
                            "  window.formSubmitted = true;" +
                            "});", form
            );
            loginPage.login("     ", "secret_sauce");
            loginPage.AssertForEmptyEmailForLogin();
        }

}
