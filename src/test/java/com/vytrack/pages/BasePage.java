package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage{
    @FindBy(className = "oro-subtitle")
    public WebElement subTitle;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement pageName;

    @FindBy(xpath = "//a[@href='/user/logout']")
    public WebElement logoutBtn;

    @FindBy(xpath = "(//div[@class='loader-frame'])[3]")
    public WebElement loaderMask;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String getSubTitle() {
        return subTitle.getText();
    }
}
