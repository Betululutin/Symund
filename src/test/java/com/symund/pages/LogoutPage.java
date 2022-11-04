package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage() { //helps me connect page with my driver
        PageFactory.initElements(Driver.getDriver(), this);//this keyword says this page
    }


    @FindBy (xpath = "//img[@src='/core/img/actions/logout.svg?v=b8729556']")
    public WebElement LogOutBtn;

    @FindBy(id = "user") //commit adding new changes
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;


    @FindBy(id = "submit-form")
    public WebElement Btn;


    @FindBy  (xpath = "//span[@title='Betul']")
    public WebElement UserNameDash;

    @FindBy  (xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement UserNameDashBtn;








}
