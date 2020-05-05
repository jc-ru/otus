package ru.otus;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        tags = {"@Test"}
        )
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
