package com.qa.mercurytours;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/mercury tours",
        glue = "com.qa.mercurytours.stepdefs"
)
public class MercuryToursTest {
}
