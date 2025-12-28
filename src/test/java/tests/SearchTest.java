package tests;

import org.example.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test
    public void testSearch() {
        HomePage home = new HomePage(driver);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("Eyouth"));

        home.searchFor("كيف تنضم إلى البنك");

        System.out.println("العنوان الحقيقي للصفحة هو: " + driver.getTitle());

        Assert.assertTrue(driver.getTitle().contains("Eyouth"), "العنوان لا يحتوي على Eyouth");
    }
}