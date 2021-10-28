package com.gmail.pages;

import com.gmail.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[text()='İleri']")
    public WebElement forwardButton;

    @FindBy(id = "identifierId")
    public WebElement userNameBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(css = ".ahT6S >span")
    public WebElement warningMessage;

    @FindBy(xpath = "//span[text()='Tekrar dene']")
    public WebElement tryAgainButton;

    @FindBy(xpath = "//*[text()='Google Hesabınız bulunamadı']")
    public WebElement notFoundMessage;

    @FindBy(css = "a[aria-label='Gelen Kutusu']")
    public WebElement inboxButton;

    @FindBy(xpath = "//*[text()='Şifre yanlış. Tekrar deneyin veya \"Şifrenizi mi unuttunuz?\"u tıklayarak şifreyi sıfırlayın.']")
    public WebElement passwordWarning;

    @FindBy(xpath = "//*[text()='Bir e-posta adresi veya telefon numarası girin']")
    public WebElement emptyUsernameWarning;

    @FindBy(xpath = "//*[text()='Bir şifre girin']")
    public WebElement emptyPasswordWarning;

    @FindBy(xpath = "//*[text()='Şifreyi göster']   ")
    public WebElement showPasswordButton;





}
