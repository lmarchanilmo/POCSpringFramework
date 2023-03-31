package edu.qa.automation.pages;


import edu.qa.automation.components.ComplexDropdown;
import edu.qa.automation.components.GenericTable;
import edu.qa.automation.configuration.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static edu.qa.automation.utils.WaitingProcess.setTime;


@Component
public class BasePage {

    @Autowired
    DriverManager driverManager;
    public BasePage(){

    }

    protected void enterText(By locator, String value){
        ((WebElement)setTime(ExpectedConditions.visibilityOfElementLocated(locator))).sendKeys(value);
    }

    protected void clickElement(By locator){
        ((WebElement)setTime(ExpectedConditions.visibilityOfElementLocated(locator))).click();
    }

    protected WebElement getRow(By locator, Map<Object, String> criteria){
        GenericTable genericTable = new GenericTable(locator);
        return genericTable.findRow(criteria);
    }

    protected void selectValueInDropdown(By locator, String value){
        ComplexDropdown complexDropdown = new ComplexDropdown(locator);
        complexDropdown.selectOption(value);

    }


}
