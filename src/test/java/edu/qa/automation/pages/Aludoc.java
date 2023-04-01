package edu.qa.automation.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import io.qameta.allure.Step;

@Component
public class Aludoc extends BasePage{

    private By administration = By.xpath("//div[self::div/button[.='Administration']]");
    private By controls = By.xpath("//div[self::div/button[.='Controls']]");

    @Step
    public Aludoc selectAdministration(String value){
        selectValueInDropdown(administration, value);
        return this;
    }
    @Step
    public Aludoc selectControls(String value){
        selectValueInDropdown(controls, value);
        return this;
    }
}
