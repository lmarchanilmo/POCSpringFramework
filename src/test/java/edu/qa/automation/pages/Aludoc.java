package edu.qa.automation.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class Aludoc extends BasePage{

    private By administration = By.xpath("//div[self::div/button[.='Administration']]");
    private By controls = By.xpath("//div[self::div/button[.='Controls']]");


    public Aludoc selectAdministration(String value){
        selectValueInDropdown(administration, value);
        return this;
    }

    public Aludoc selectControls(String value){
        selectValueInDropdown(controls, value);
        return this;
    }
}
