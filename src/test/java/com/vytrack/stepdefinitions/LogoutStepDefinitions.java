package com.vytrack.stepdefinitions;


import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutStepDefinitions  {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Then("the user should log out after clicking the log out button")
    public void the_user_should_log_out_after_clicking_the_log_out_button()  {
    BrowserUtils.waitFor(10);
    dashboardPage.pageName.click();
    dashboardPage.logoutBtn.click();
    }

    @And("the user should land on the {string} page")
    public void the_user_should_land_on_the_page(String logintitle) {
        String actualtitle = Driver.get().getTitle();
        Assert.assertEquals(logintitle,actualtitle);
    }

    @And("the user should click the back button")
    public void theUserShouldClickTheBackButton() {
        Driver.get().navigate().back();
    }

    @And("verify the user is on the {string} page")
    public void verifyTheUserIsOnThePage(String page) {
        Assert.assertEquals(page,Driver.get().getTitle());
    }

    @Then("the user should close the page")
    public void theUserShouldCloseThePage() {
        Driver.closeDriver();
    }




}
