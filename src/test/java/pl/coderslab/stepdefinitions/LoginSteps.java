package pl.coderslab.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.LoginPage;
import pl.coderslab.pages.AccountPage;

import java.time.Duration;

public class LoginSteps {

    // Statyczny WebDriver współdzielony między krokami
    public static WebDriver driver;

    // Obiekty stron wykorzystywane w testach
    private LoginPage loginPage;
    private AccountPage myAccountPage;

    // Metoda przed każdym scenariuszem
    @Before
    public void setUp() {
        // Inicjalizacja przeglądarki Chrome i konfiguracja
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Inicjalizacja obiektów stron
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

    // Krok: otwiera stronę logowania
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.open();
    }

    // Krok: wykonuje logowanie na podstawie podanego email i hasła
    @And("the user logs in with email {string} and password {string}")
    public void theUserLogsInWithEmailAndPassword(String email, String password) {
        loginPage.login(email, password);
    }
}
