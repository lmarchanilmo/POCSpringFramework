package edu.qa.automation.steps;

import edu.qa.automation.pages.Login;
import edu.qa.automation.utils.MainMenuItem;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class GivenSteps extends BaseStepDefinition{

    @Given("I Login into the application")
    public void iLoginIntoTheApplication() {

        login.enterUsername("angela.valbuena")
                .enterPassword("demo")
                .clickLogin();
    }

}
