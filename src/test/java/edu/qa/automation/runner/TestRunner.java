package edu.qa.automation.runner;


import edu.qa.automation.config.Config;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(
        plugin = {"pretty", "json:build/reports/cucumber.json"},
        features = "classpath:features",
        glue = {"edu.qa.automation"},
        tags = "not @manual"
)
@SpringBootTest(classes = Config.class)
public class TestRunner {
}
