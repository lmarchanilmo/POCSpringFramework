package edu.qa.automation.steps.support;

import edu.qa.automation.configuration.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource({
        "classpath:config/${environment}.properties"
})
public class Hooks {

    @Autowired
    DriverManager driverManager;

    @Value("${baseUrl}")
    String baseUrl;

    @Before
    public void setup(){
        driverManager.getDriver().get(baseUrl);
    }

    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driverManager.quitDriver();
    }
}
