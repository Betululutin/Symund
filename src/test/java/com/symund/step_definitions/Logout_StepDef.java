package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.pages.LogoutPage;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;

public class Logout_StepDef {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage= new LogoutPage();

    @Given("user is on the dashboardpage")
    public void user_is_on_the_dashboardpage() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("validUsername"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("validPassword"));
        loginPage.Btn.click();
    }
    @When("user clicks on the log out button")
    public void user_clicks_on_the_log_out_button() {
        logoutPage.UserNameDashBtn.click();
        logoutPage.LogOutBtn.click();
    }
    @Then("user should land on the log in page")
    public void user_should_land_on_the_log_in_page() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("login"));

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));

    }
    @Then("user cannot go back by clicking log out")
    public void user_cannot_go_back_by_clicking_log_out() {
        Driver.getDriver().navigate().back();

        String actualTitle = Driver.getDriver().getTitle();

        System.out.println(actualTitle);

        Assert.assertEquals("Symund - QA", actualTitle);
    }





}
