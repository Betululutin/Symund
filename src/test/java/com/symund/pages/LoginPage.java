package com.symund.pages;

import com.symund.utilities.Driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    public LoginPage() { //helps me connect page with my driver
        PageFactory.initElements(Driver.getDriver(), this);//this keyword says this page
    }

    @FindBy(id = "user")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;


    @FindBy(id = "submit-form")
    public WebElement Btn;

    @FindBy  (xpath = "//p[@class= 'warning wrongPasswordMsg']")
    public WebElement warningMsg;

    @FindBy (xpath = "//img[@alt='Toggle password visibility']")
    public WebElement togglePassword;

    @FindBy(id = "lost-password")
    public WebElement ForgotPassword;

    @FindBy(id ="reset-password-submit" )
    public WebElement ResetBtn;

    @FindBy( id="user")
    public WebElement PlaceHolders;
//commit



    public void login(String username, String password) {

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        Btn.click();
    }
}


