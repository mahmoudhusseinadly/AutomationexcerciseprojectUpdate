package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class Registration
{
        WebDriver Page = new ChromeDriver();
        By First_Name = By.xpath("//input[@id='input-firstname']"); //Add xpath of the first name field
        By Last_Name = By.xpath("//input[@id='input-lastname']"); //Add xpath of the last name field
        By Email = By.xpath("//input[@id='input-email']"); //Add the xpath of the email field
        By Password = By.xpath("//input[@id='input-password']"); //Add the xpath of the password field
        By News_Letter = By.xpath("//input[@id='input-newsletter']"); //Add the xpath of the newsletter switch button
        By Privacy_Policy = By.xpath("//input[@name='agree']"); //Add the xpath of the privacy policy switch button
        By Continue_Button = By.xpath("//button[@type='submit']"); //Add the xpath of the continue button
        By Registration_Message = By.xpath("//*[@id=\"content\"]/h1");//Add the xpath of the message that appears after successful register
        By FirstName_ErrorMessage = By.xpath("//*[@id=\"error-firstname\"]");// Add the xpath of the message that appears when the first name field is left empty
        By LastName_ErrorMessage = By.xpath("//*[@id=\"error-lastname\"]"); //Add the xpath of the message that appears when the last name field is empty
        By Email_ErrorMessage = By.xpath("//*[@id=\"error-email\"]"); //Add the xpath of the message that appears when the Email field is empty
        By Password_ErrorMessage = By.xpath("//*[@id=\"error-password\"]"); //Add the xpath of the message that appears when the password field is empty
        By PrivacyPolicy_ErrorMessage = By.xpath("//*[@id=\"alert\"]"); //Add the xpath of the message that appears when the privacy policy field is not switched on

        @BeforeMethod
        public void preconditions()
        {
            Page.get("https://demo.opencart.com/en-gb?route=account/register"); //add the url of the register page
            Page.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test//Valid Register
        public void Valid_Register()
        {
            Page.findElement(First_Name).sendKeys("Omar");
            Page.findElement(Last_Name).sendKeys("Ossama");
            Page.findElement(Email).sendKeys("omarossama802@gmail.com");
            Page.findElement(Password).sendKeys("123456");
            Page.findElement(News_Letter).click();
            Page.findElement(Privacy_Policy).click();
            Page.findElement(Continue_Button).click();
            Assert.assertEquals(Page.getCurrentUrl(), "https://demo.opencart.com/en-gb?route=account/success&customer_token=fdfa809b3dbe53a440eddc60e7");//Add the url of the page that appears after the successful registration
            Assert.assertTrue(Page.findElement(Registration_Message).isDisplayed());
        }

        @Test
        public void Empty_FirstName()
        {
            Page.findElement(Last_Name).sendKeys("Ossama");
            Page.findElement(Email).sendKeys("lordofstorm12@gmail.com");
            Page.findElement(Password).sendKeys("123456");
            Page.findElement(News_Letter).click();
            Page.findElement(Privacy_Policy).click();
            Page.findElement(Continue_Button).click();
            Assert.assertTrue(Page.findElement(FirstName_ErrorMessage).isDisplayed());
        }

        @Test
        public void Empty_LastName()
        {
            Page.findElement(First_Name).sendKeys("Omar");
            Page.findElement(Email).sendKeys("lordofstorm12@gmail.com");
            Page.findElement(Password).sendKeys("123456");
            Page.findElement(News_Letter).click();
            Page.findElement(Privacy_Policy).click();
            Page.findElement(Continue_Button).click();
            Assert.assertTrue(Page.findElement(LastName_ErrorMessage).isDisplayed());
        }

        @Test
        public void Empty_Email()
        {
            Page.findElement(First_Name).sendKeys("Omar");
            Page.findElement(Last_Name).sendKeys("Ossama");
            Page.findElement(Password).sendKeys("123456");
            Page.findElement(News_Letter).click();
            Page.findElement(Privacy_Policy).click();
            Page.findElement(Continue_Button).click();
            Assert.assertTrue(Page.findElement(Email_ErrorMessage).isDisplayed());
        }
        @Test
         public void Empty_Password()
        {
            Page.findElement(First_Name).sendKeys("Omar");
            Page.findElement(Last_Name).sendKeys("Ossama");
            Page.findElement(Password).sendKeys("123456");
            Page.findElement(News_Letter).click();
            Page.findElement(Privacy_Policy).click();
            Page.findElement(Continue_Button).click();
            Assert.assertTrue(Page.findElement(Password_ErrorMessage).isDisplayed());
        }
        @Test
        public void NewsLetter_Off()
        {
            Page.findElement(First_Name).sendKeys("Omar");
            Page.findElement(Last_Name).sendKeys("Ossama");
            Page.findElement(Email).sendKeys("");
            Page.findElement(Password).sendKeys("123456");
            Page.findElement(Privacy_Policy).click();
            Page.findElement(Continue_Button).click();
            Assert.assertTrue(Page.findElement(Registration_Message).isDisplayed());
            Assert.assertEquals(Page.getCurrentUrl(), "https://demo.opencart.com/en-gb?route=account/success&customer_token=fdfa809b3dbe53a440eddc60e7");
        }
        @Test
        public void PrivacyPolicy_Off()
        {
            Page.findElement(First_Name).sendKeys("Omar");
            Page.findElement(Last_Name).sendKeys("Ossama");
            Page.findElement(Email).sendKeys("");
            Page.findElement(Password).sendKeys("123456");
            Page.findElement(Continue_Button).click();
            Assert.assertTrue(Page.findElement(PrivacyPolicy_ErrorMessage).isDisplayed());
        }


    @AfterMethod
        public void Close_Page()
        {
            Page.quit();
        }

}
