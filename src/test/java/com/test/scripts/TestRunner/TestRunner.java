package com.test.scripts.TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"src/test/resources/Features"},
        glue={"com.demo.scripts.pom","com.test.scripts.StepDefs","com.demo.scripts.TestContext"},
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports"}
        , tags = "@MyDemo",dryRun = false)

public class TestRunner {
}
