package pl.coderslab.runtest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/features", // względna ścieżka
        glue = {"pl.coderslab.stepdefinitions", "pl.coderslab.hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        publish = true
)
public class RunCucumberTest {
}