package edu.qa.automation.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class AmazonDashboard extends BasePage{

    private By search = By.id("twotabsearchtextbox");

    public void enterSearch(String value){
        enterText(search, value);
    }

}
