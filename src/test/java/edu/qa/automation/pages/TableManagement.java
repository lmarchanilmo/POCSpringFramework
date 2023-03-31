package edu.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

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

    public TableManagement getRecord(){

        row = getRow(table, criteria);
        return this;
    }

    public TableManagement checkRow(){
        ((WebElement)setTime(ExpectedConditions.presenceOfNestedElementLocatedBy(row, check))).click();
        return this;
    }


}
