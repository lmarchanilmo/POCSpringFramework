package edu.qa.automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static edu.qa.automation.utils.WaitingProcess.setTime;



public class TableManagement extends BasePage{

    private By table;
    private WebElement row;
    private Map<Object, String> criteria;

    private By check = By.xpath(".//input[@type='checkbox']");

    public TableManagement(By table, Map<Object, String> criteria){
        this.table = table;
        this.criteria = criteria;
    }
    @Step
    public TableManagement getRecord(){

        row = getRow(table, criteria);
        return this;
    }
    @Step
    public TableManagement checkRow(){
        ((WebElement)setTime(ExpectedConditions.presenceOfNestedElementLocatedBy(row, check))).click();
        return this;
    }


}
