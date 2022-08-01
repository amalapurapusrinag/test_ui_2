package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver){ //constructor
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }
}