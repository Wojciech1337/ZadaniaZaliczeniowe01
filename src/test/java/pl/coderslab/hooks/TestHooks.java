package pl.coderslab.hooks;

import io.cucumber.java.After;
import pl.coderslab.driver.DriverManager;

public class TestHooks {


    @After
    public void tearDownWithDelay() {


        System.out.println("Test zakończony – zamykam przeglądarkę");
        DriverManager.quitDriver();
    }
}

