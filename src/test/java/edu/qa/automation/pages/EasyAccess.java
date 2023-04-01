package edu.qa.automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EasyAccess extends BasePage{

    private By administration = By.xpath("//div[self::div/button[.='Administration']]");

    private By table = By.xpath("(//table)[1]");
    @Step
    public void selectAdministration(String value){
        selectValueInDropdown(administration, value);
    }
    @Step
    public TableManagement getTableManager(Map<Object, String> criteria){
        return new TableManagement(table, criteria);
    }
}
