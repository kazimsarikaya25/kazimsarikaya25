package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotLink;

    @FindBy(css = ".alert.alert-error")
    public WebElement errorMessage;

    @FindBy(css = ".custom-checkbox__text")
    public WebElement rememberText;

    @FindBy(css = ".custom-checkbox__icon")
    public WebElement rememberCheckbox;



}
