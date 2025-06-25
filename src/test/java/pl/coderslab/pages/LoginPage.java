package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.id("submit-login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    public void open() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }
}
