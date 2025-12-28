package tests;

import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    // الاختبار الأول: بيانات غلط
    @Test(priority = 1)
    public void testInvalidLogin() {
        driver.get("https://eyouthlearning.com/signin");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wronguser@test.com", "wrongpass123");

        // نتأكد إننا لسه في صفحة الـ signin
        Assert.assertTrue(driver.getCurrentUrl().contains("signin"), "دخل بالغلط المفروض يفضل بره!");
    }

    // الاختبار التاني: حقول فاضية (الجديد)
    @Test(priority = 2)
    public void testEmptyLogin() {
        driver.get("https://eyouthlearning.com/signin");
        LoginPage loginPage = new LoginPage(driver);

        // هندوس دخول علطول من غير ما نكتب حاجة (بنبعت نص فاضي "")
        loginPage.login("", "");

        // نتأكد إننا لسه في صفحة الـ signin
        Assert.assertTrue(driver.getCurrentUrl().contains("signin"), "الموقع قبل يدخل بحقول فاضية!");

        // أو ممكن نتأكد من ظهور رسالة خطأ لو ظهرت
        // System.out.println("رسالة الخطأ: " + loginPage.getErrorMessage());
    }
}