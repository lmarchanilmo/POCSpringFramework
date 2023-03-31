package edu.qa.automation.steps;

import edu.qa.automation.utils.MainMenuItem;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.devtools.v85.runtime.model.RemoteObject;
import org.openqa.selenium.devtools.v89.runtime.model.ObjectPreview;

import java.util.HashMap;
import java.util.Map;

public class ThenSteps extends BaseStepDefinition{

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
