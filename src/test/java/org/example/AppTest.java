package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Test
    public void testLoginGitHub(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Srinag_Amalapurapu\\IdeaProjects\\test_ui\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.id("login_field"));
        login.sendKeys("srinag_amalapurapu@epam.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("srinagvvit23");

        ;WebElement sighInButton = driver.findElement(By.name("commit"));
        sighInButton.click();

        WebElement profileDropDownButton = driver.findElement(By.xpath("//summary[@class=\"Header-link\"]/img"));
        profileDropDownButton.click();

        WebElement userInformationLabel = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()=\"srinag_amalapurapu\"]")));
        Assert.assertEquals(userInformationLabel.getText(), "srinag_amalapurapu", "user should be srinag_amalapurapu");

        // WebElement userInformationLabel = driver.findElement(By.xpath("//strong[text()=\"srinag_amalapurapu\"]"));
    }
    @DataProvider(name = "wrongCredentials")
    public Object[][] wrongCredentials() {
        return new Object[][] {
                {"qwerty", "srinagvvit23"},
                {"srinag_amalapurapu@epam.com", "qwerty"},
                {"qwerty", "qwerty"}
        };
    }

    @Test(dataProvider = "wrongCredentials")
    public void gitHubLoginNegativeTest(String login, String pass) {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Srinag_Amalapurapu\\IdeaProjects\\test_ui\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/login");

        WebElement loginField = driver.findElement(By.id("login_field"));
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(pass);

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

        WebElement errorLabel = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("js-flash-container")));

        Assert.assertEquals("Incorrect username or password.", errorLabel.getText());

        driver.quit();
    }
}
