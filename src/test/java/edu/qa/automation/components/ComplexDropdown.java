package edu.qa.automation.components;

import edu.qa.automation.configuration.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static edu.qa.automation.utils.WaitingProcess.setTime;

public class ComplexDropdown {

    private By wrapper;
    private By expandButton = By.xpath("./button");
    private String item = ".//li[self::li/parent::ul and .='%s']";

    public ComplexDropdown(By wrapper){
        this.wrapper=wrapper;
        setTime(ExpectedConditions.visibilityOfElementLocated(this.wrapper));
    }

    public void selectOption(String value){
        ((WebElement)setTime(ExpectedConditions.presenceOfNestedElementLocatedBy(this.wrapper, expandButton))).click();
        ((WebElement)setTime(ExpectedConditions.presenceOfNestedElementLocatedBy(this.wrapper, By.xpath(String.format(item, value))))).click();
    }
}
