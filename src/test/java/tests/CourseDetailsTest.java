package tests;

import org.example.pages.CoursesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CourseDetailsTest extends TestBase {


    @Test
    public void testOpenCourseDetails() {
        CoursesPage coursesPage = new CoursesPage(driver);


        if (!driver.getCurrentUrl().contains("courses")) {
            coursesPage.openCoursesPage();
        }

        coursesPage.clickFirstCourse();


        Assert.assertTrue(coursesPage.isAboutSectionDisplayed(), "صفحة التفاصيل مفتحتش (قسم حول الدورة مش موجود)!");
    }
}