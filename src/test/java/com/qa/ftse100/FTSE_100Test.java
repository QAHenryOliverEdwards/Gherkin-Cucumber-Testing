package com.qa.ftse100;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/FTSE-100",
        glue = "com.qa.ftse100.stepdefs"
)
public class FTSE_100Test {
}
