package edu.qa.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedConditions {

    public static ExpectedCondition<Boolean> minimumTableCapacity(By table, By rows){

        int rowAmount = 11;
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElement(table).findElements(rows).size() == rowAmount;
            }
            @Override
            public String toString(){
                return String.format("Expecting for Table to have: %s rows", rowAmount);
            }
        };
    }
}
