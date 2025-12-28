package tests;

import org.example.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {

    @Test(priority = 1)
    public void testOpenRegisterPage() {
        RegisterPage registerPage = new RegisterPage(driver);


        registerPage.clickJoinUs();


        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after click: " + currentUrl);


        boolean isRegisterPage = currentUrl.contains("signup") || currentUrl.contains("register") || currentUrl.contains("signin");

        Assert.assertTrue(isRegisterPage, ": " + currentUrl);
    }

    @Test(priority = 2)
    public void testRegisterWithEmptyUsername() {
        RegisterPage registerPage = new RegisterPage(driver);

        if (!driver.getCurrentUrl().contains("signup") && !driver.getCurrentUrl().contains("register")) {
            registerPage.clickJoinUs();
        }


        registerPage.registerUser("Test", "User", "", "testuser@example.com", "Pass@12345");

        Assert.assertTrue(registerPage.isErrorDisplayed());
    }
}