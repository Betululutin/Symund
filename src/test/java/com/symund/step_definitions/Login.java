package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }
    @When("user enters valid username")
    public void user_enters_valid_username() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("validUsername"));
    }
    @When("user enters valid password")
    public void user_enters_valid_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("validPassword"));

    }
    @When("user clicks on login Button")
    public void user_clicks_on_login_button() {
        loginPage.Btn.click();
    }
    @Then("user should land on the dashboard page")
    public void user_should_land_on_the_dashboard_page() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("dashboard"));

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }

    @When("user enters invalid username")
    public void user_enters_invalid_username() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("invalidUsername"));
    }
    @When("user enters invalid password")
    public void user_enters_invalid_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("invalidPassword"));
    }


    @Then("Wrong username or password should be displayed for invalid credentials")
    public void wrong_username_or_password_should_be_displayed_for_invalid_credentials() {
      loginPage.warningMsg.isDisplayed();

    }
    @When("username input box left blank")
    public void username_input_box_left_blank() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("blank"));
    }

    @Then("{string} message should be displayed if the password or username is empty")
    public void message_should_be_displayed_if_the_password_or_username_is_empty(String string) {
        Assert.assertTrue(loginPage.usernameInput.getTagName().equals("input"));
        BrowserUtils.sleep(2);
        System.out.println(loginPage.usernameInput.getAttribute("validationMessage"));
        Assert.assertEquals("Please fill out this field.",loginPage.
                usernameInput.getAttribute("validationMessage"));

    }

    @Then("User can see the password in form of dots")
    public void user_can_see_the_password_in_form_of_dots() {
        loginPage.togglePassword.isDisplayed();
    }


    @Then("User can see the password explicitly")
    public void user_can_see_the_password_explicitly() {
        loginPage.togglePassword.click();
    }

    @When("user clicks on the Forgot password link")
    public void user_clicks_on_the_forgot_password_link() {
        loginPage.ForgotPassword.click();
    }
    @Then("user can see the Reset password button on the next page after clicking on forget password link")
    public void user_can_see_the_reset_password_button_on_the_next_page_after_clicking_on_forget_password_link() {
         loginPage.ResetBtn.isDisplayed();
    }

    @Then("User is able to see valid placeholders on Username and Password fields")
    public void user_is_able_to_see_valid_placeholders_on_username_and_password_fields() {
        loginPage.PlaceHolders.isDisplayed();
    }




}
