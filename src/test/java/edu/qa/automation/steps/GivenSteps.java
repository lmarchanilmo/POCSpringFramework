package edu.qa.automation.steps;

import edu.qa.automation.preconditions.RemoveExistingPerson;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Collections;

public class GivenSteps extends BaseStepDefinition{


    @Autowired
    RemoveExistingPerson removeExistingPerson;

    @Given("I Login into the application")
    public void iLoginIntoTheApplication() throws IOException {

        removeExistingPerson.resolve(Collections.singletonMap("criteria", "Camilo123"));

        login.enterUsername("angela.valbuena")
                .enterPassword("demo")
                .clickLogin();
    }

}
