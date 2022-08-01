package org.example.pageobjects.pages;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "login_field")
    private WebElement login;
    @FindBy(id = "password")
    private WebElement pass;
    @FindBy(name = "commit")
    private WebElement sighInButton;

    protected LoginPage(WebDriver webDriver) {
        super(webDriver);
    }//constructor

    public HomePage login(String login, String  pass){
        this.login.sendKeys();
        this.pass.sendKeys();
        this.sighInButton.click();



        return new HomePage(webDriver);

    }
}