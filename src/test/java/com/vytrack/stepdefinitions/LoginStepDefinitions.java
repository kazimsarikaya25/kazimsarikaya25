package com.vytrack.stepdefinitions;


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

public class LoginStepDefinitions {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Given("the user should be in the login page")
    public void the_user_should_be_in_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(3);
    }

    @When("the user should log in with {string} and {string}")
    public void theUserShouldLogInWithAnd(String username, String password) {
        loginPage.userName.sendKeys(username);
        BrowserUtils.waitFor(3);
        loginPage.password.sendKeys(password);
        BrowserUtils.waitFor(3);
        loginPage.submit.click();
        BrowserUtils.waitFor(3);
    }

    @Then("the user should land on the {string}")
    public void theUserShouldLandOnThe(String page) {

        String actualTitle = dashboardPage.getSubTitle();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(page,actualTitle);
        BrowserUtils.waitFor(3);
    }

    @When("the user should not log in with {string} and {string}")
    public void theUserShouldNotLogInWithAnd(String username, String password) {
        loginPage.userName.sendKeys(username);
        BrowserUtils.waitFor(3);
        loginPage.password.sendKeys(password);
        BrowserUtils.waitFor(3);
        loginPage.submit.click();
        BrowserUtils.waitFor(3);
    }

    @Then("user verify the allertmessage")
    public void userVerifyTheAllertmessage() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Then("the user should see {string} on the page")
    public void theUserShouldSeeOnThePage(String nameonpage) {
        Assert.assertEquals(nameonpage,dashboardPage.pageName.getText());
    }

    @Then("user can see the {string} message")
    public void userCanSeeTheMessage(String expectederrormessage) {
        Assert.assertEquals(expectederrormessage,loginPage.errorMessage.getText());
    }

    @When("user should click the forgot password button")
    public void userShouldClickTheForgotPasswordButton() {
        loginPage.forgotLink.click();
        BrowserUtils.waitFor(3);
    }

    @Then("user should land on the {string} page")
    public void userShouldLandOnThePage(String expectedtitle) {
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedtitle,actualTitle);
    }

    @When("user should see the {string} message")
    public void userShouldSeeTheMessage(String expectedmessage) {
        loginPage.rememberText.isDisplayed();
        Assert.assertEquals(expectedmessage,loginPage.rememberText.getText());
    }

    @Then("remember me message should be clickable")
    public void rememberMeMessageShouldBeClickable() {
        loginPage.rememberText.click();
        loginPage.rememberCheckbox.isSelected();
    }

    @And("remember me checbox should be clickable")
    public void rememberMeChecboxShouldBeClickable() {
        loginPage.rememberCheckbox.click();
        loginPage.rememberCheckbox.isSelected();
        BrowserUtils.waitFor(3);
        loginPage.rememberCheckbox.click();
    }

    @When("the user can click the enter button after write their {string}")
    public void theUserCanClickTheEnterButtonAfterWriteTheir(String username) {
        loginPage.userName.sendKeys(username);
        loginPage.userName.sendKeys(Keys.ENTER);
        BrowserUtils.waitFor(3);
    }

    @Then("the user can click the enter button after write their own {string}")
    public void theUserCanClickTheEnterButtonAfterWriteTheirOwn(String password) {
        loginPage.password.sendKeys(password);
        loginPage.password.sendKeys(Keys.ENTER);
    }

    @And("the user can click the enter button to log in the {string}")
    public void theUserCanClickTheEnterButtonToLogInThe(String page) {
        String actualtitle=dashboardPage.getSubTitle();
        Assert.assertEquals(page,actualtitle);
    }

    @When("the user should see the bullet sign writing own password")
    public void theUserShouldSeeTheBulletSignWritingOwnPassword() {
        loginPage.password.sendKeys("25");
        Assert.assertEquals("password",loginPage.password.getAttribute("type"));
    }
}
