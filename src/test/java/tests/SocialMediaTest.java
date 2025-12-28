package tests;

import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class SocialMediaTest extends TestBase {


    @Test(priority = 1)
    public void testFacebookLink() {
        verifyLinkAttribute("facebook", "facebook.com");
    }

    @Test(priority = 2)
    public void testLinkedinLink() {
        verifyLinkAttribute("linkedin", "linkedin.com");
    }

    @Test(priority = 3)
    public void testInstagramLink() {
        verifyLinkAttribute("instagram", "instagram.com");
    }

    public void verifyLinkAttribute(String iconName, String expectedUrlPart) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        String xpath = "//a[contains(@href, '" + iconName + "')]";
        WebElement socialIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));


        String actualLink = socialIcon.getAttribute("href");
        Assert.assertTrue(actualLink.contains(expectedUrlPart), "لينك " + iconName );
    }
}