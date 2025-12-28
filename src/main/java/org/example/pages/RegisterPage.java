package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    WebDriver driver;


    @FindBy(xpath = "//a[contains(text(),'انضم لنا')] | //button[contains(text(),'انضم لنا')]")
    public WebElement joinUsButton;


    @FindBy(xpath = "(//input[not(@type='hidden') and not(@type='submit')])[1]")
    WebElement firstNameField;

    @FindBy(xpath = "(//input[not(@type='hidden') and not(@type='submit')])[2]")
    WebElement lastNameField;
    @FindBy(xpath = "(//input[not(@type='hidden') and not(@type='submit')])[3]")
    WebElement emailOrUserField;

    @FindBy(xpath = "(//input[not(@type='hidden') and not(@type='submit')])[4]")
    WebElement extraField;


    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement passwordField;


    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPasswordField;


    @FindBy(xpath = "//button[contains(text(), 'انشاء') or @type='submit']")
    WebElement createAccountButton;


    @FindBy(xpath = "//*[contains(@class, 'error') or contains(@class, 'alert') or contains(text(), 'مطلوب')]")
    WebElement validationMessage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void clickJoinUs() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(joinUsButton));
            joinUsButton.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", joinUsButton);
        }
    }

    public void registerUser(String fName, String lName, String username, String email, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstNameField));


        if (!fName.isEmpty()) firstNameField.sendKeys(fName);


        try { if (!lName.isEmpty()) lastNameField.sendKeys(lName); } catch (Exception e) {}


        try { if (!email.isEmpty()) emailOrUserField.sendKeys(email); } catch (Exception e) {}


        try { if (!email.isEmpty()) extraField.sendKeys(email); } catch (Exception e) {}

        if (!password.isEmpty()) {
            passwordField.sendKeys(password);
            try { confirmPasswordField.sendKeys(password); } catch (Exception e) {}
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", createAccountButton);
    }

    public boolean isErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(validationMessage));
            return validationMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}