package pl.coderslab.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pl.coderslab.driver.DriverManager;
import pl.coderslab.pages.LoginPage;

public class LoginSteps {

    private WebDriver driver = DriverManager.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("I'm on the login page")
    public void iMOnTheLoginPage() {
        loginPage.open();
    }

    @When("I log in with email {string} and password {string}")
    public void iLogInWithEmailAndPassword(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("I should be on the account page")
    public void iShouldBeOnTheAccountPage() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("my-account"), "User is not on the account page");
    }
}




