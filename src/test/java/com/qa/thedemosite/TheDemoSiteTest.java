package com.qa.thedemosite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/thedemosite", glue = "com.qa.thedemosite.stepdefs")
public class TheDemoSiteTest {
}
