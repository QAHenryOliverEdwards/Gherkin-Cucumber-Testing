package com.qa.teasite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/tea site",
        glue = "com.qa.teasite.stepdefs"
)
public class TeaSiteTest {
}
