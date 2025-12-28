package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CoursesPage {
    WebDriver driver;


    @FindBy(xpath = "//a[contains(text(),'جميع الدورات') or contains(text(),'دوراتنا') or contains(@href, 'courses')]")
    WebElement allCoursesLink;


    @FindBy(xpath = "(//div[contains(@class, 'course-card') or contains(@class, 'card')])[1]")
    WebElement firstCourseCard;


    @FindBy(xpath = "(//div[contains(@class, 'course-card') or contains(@class, 'card')])[1]//img")
    public WebElement courseImage;


    @FindBy(xpath = "(//div[contains(@class, 'course-card') or contains(@class, 'card')])[1]//h3 | (//div[contains(@class, 'course-card') or contains(@class, 'card')])[1]//h4")
    public WebElement courseTitle;


    @FindBy(xpath = "(//div[contains(@class, 'course-card') or contains(@class, 'card')])[1]//*[contains(text(),'د.') or contains(text(),'Mr') or contains(@class, 'instructor')]")
    public WebElement instructorName;


    @FindBy(xpath = "(//div[contains(@class, 'course-card') or contains(@class, 'card')])[1]//button | (//div[contains(@class, 'course-card') or contains(@class, 'card')])[1]//a[contains(text(),'شترك')]")
    public WebElement subscribeButton;

    @FindBy(xpath = "//*[contains(text(),'حول الدورة') or contains(text(),'About')]")
    WebElement aboutCourseSection;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void openCoursesPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(allCoursesLink));
            allCoursesLink.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", allCoursesLink);
        }
    }

    public void clickFirstCourse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstCourseCard));
        firstCourseCard.click();
    }

    public boolean isAboutSectionDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(aboutCourseSection));
            return aboutCourseSection.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}