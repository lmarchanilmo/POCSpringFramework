package edu.qa.automation.steps;

import edu.qa.automation.utils.MainMenuItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WhenSteps extends BaseStepDefinition{

    @When("I navigate to {string} Module")
    public void iNavigateToModule(String option) {
        asideMenu.selectMenuItem(MainMenuItem.valueOf(option));
    }
}
