package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;


    @FindBy(xpath = "//input[@type='search']")
    WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//a[contains(@href, 'facebook')]")
    public WebElement facebookIcon;

    @FindBy(xpath = "//a[contains(@href, 'linkedin')]")
    public WebElement linkedinIcon;

    @FindBy(xpath = "//a[contains(@href, 'instagram')]")
    public WebElement instagramIcon;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String keyword) {

        searchInput.sendKeys(keyword + "\n");
    }
}