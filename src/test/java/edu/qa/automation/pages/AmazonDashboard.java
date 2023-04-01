package edu.qa.automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class AmazonDashboard extends BasePage{

    private By search = By.id("twotabsearchtextbox");
    @Step
    public void enterSearch(String value){
        enterText(search, value);
    }

}
