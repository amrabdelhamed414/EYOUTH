package tests;

import org.example.pages.CoursesPage;
import org.example.pages.LoginPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends TestBase {

    @Test
    public void testEndToEndScenario() throws InterruptedException {

        driver.get("https://eyouthlearning.com/signin");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("amrabdelhamed413@gmail.com", "eyouth@123");


        Thread.sleep(3000);


        CoursesPage coursesPage = new CoursesPage(driver);
        if (!driver.getCurrentUrl().contains("courses")) {
            coursesPage.openCoursesPage();
            Thread.sleep(3000);
        }


        Actions actions = new Actions(driver);
        actions.moveToElement(coursesPage.subscribeButton).click().perform();


        Thread.sleep(3000);


        String currentUrl = driver.getCurrentUrl();
        System.out.println("إحنا دلوقتي في صفحة: " + currentUrl);


        boolean paymentPageOpened = currentUrl.contains("basket") ||
                currentUrl.contains("cart") ||
                currentUrl.contains("checkout") ||
                currentUrl.contains("payment");

        Assert.assertTrue(paymentPageOpened,
                "للأسف مرحناش صفحة الدفع، إحنا لسه في: " + currentUrl);
    }
}