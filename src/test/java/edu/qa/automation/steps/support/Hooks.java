package edu.qa.automation.steps.support;

import edu.qa.automation.configuration.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

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
    public void teardown(){
        //driverManager.quitDriver();
    }
}
