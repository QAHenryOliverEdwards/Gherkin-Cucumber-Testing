package com.qa.kittens;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/google", glue = "com.qa.kittens.stepdefs")
public class GoogleTest {
}
