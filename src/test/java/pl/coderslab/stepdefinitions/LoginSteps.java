package pl.coderslab.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.LoginPage;
import pl.coderslab.pages.AccountPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    // Statyczny WebDriver współdzielony między krokami
    public static WebDriver driver;

    // Obiekty stron
    private LoginPage loginPage;
    private AccountPage myAccountPage;

    // Metoda przed każdym scenariuszem
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
        myAccountPage = new AccountPage(driver);
    }

    // Metoda zamyka przeglądarkę
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Otwiera stronę logowania
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        System.out.println("🌐 Otwieram stronę logowania");
        loginPage.open();
    }

    // Wykonuje logowanie na podstawie podanego email i hasła
    @And("the user logs in with email {string} and password {string}")
    public void theUserLogsInWithEmailAndPassword(String email, String password) {
        System.out.println("🔑 Loguję się jako: " + email);
        loginPage.login(email, password);

        //  Sprawdzamy obecność przycisku "Sign out"
        boolean isSignOutVisible = myAccountPage.isSignOutVisible();
        Assertions.assertTrue(isSignOutVisible, "❌ Nie znaleziono przycisku 'Sign out' — logowanie mogło się nie powieść.");
        System.out.println("✅ Zalogowano poprawnie — przycisk 'Sign out' widoczny.");
    }
}
