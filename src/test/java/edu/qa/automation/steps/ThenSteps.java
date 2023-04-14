package edu.qa.automation.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.HashMap;
import java.util.Map;

public class ThenSteps extends BaseStepDefinition {

    @Then("I select the Administration Option {string} in ALUDOC")
    public void iSelectTheAdministrationOptionInAludoc(String option) {

        aludoc.selectAdministration(option);
    }

    @Then("I select the Administration Option {string} in EASY_ACCESS")
    public void iSelectTheAdministrationOptionInEasyAccess(String option) {

        easyAccess.selectAdministration(option);
    }

    @Then("I select the Controls Option {string} in ALUDOC")
    public void iSelectTheControlsOption(String option) {
        aludoc.selectControls(option);
    }


    @And("I check row for the following criteria")
    public void iCheckRowForTheFollowingCriteria(DataTable dataTable) {
        Map<Object, String> criteria = new HashMap<Object, String>(dataTable.asMaps().get(0));
        easyAccess.getTableManager(criteria).getRecord().checkRow();
    }
}
