package Test;


import org.testng.annotations.Test;

public class LogoutTest extends TestBase {



    @Test
    public void ValidateLogoutSucceffuly() {
        loginPage.login("mahmoudhusseinadly1@gmail.com", "Test@1632");
        homePage.Logout();
        loginPage.Assertforvalidlogout();

    }
}


