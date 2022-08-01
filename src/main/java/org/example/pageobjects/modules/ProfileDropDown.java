package org.example.pageobjects.modules;

import org.example.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileDropDown extends BasePage {
    private WebElement userInformationLabel;
    protected ProfileDropDown(WebDriver webDriver) {
        super(webDriver);
    }
}
