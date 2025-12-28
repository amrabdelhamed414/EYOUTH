package tests;

import org.example.pages.CoursesPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseUITest extends TestBase {


    @Test
    public void testCourseCardUI() {
        CoursesPage coursesPage = new CoursesPage(driver);


        coursesPage.openCoursesPage();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(coursesPage.courseImage));


        Assert.assertTrue(coursesPage.courseImage.isDisplayed(), "صورة الكورس مش ظاهرة!");

        Assert.assertTrue(coursesPage.courseTitle.isDisplayed(), "عنوان الكورس مش ظاهر!");

        Assert.assertTrue(coursesPage.subscribeButton.isDisplayed(), "زرار الاشتراك مش ظاهر!");
    }
}