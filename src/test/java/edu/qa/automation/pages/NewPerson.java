package edu.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import static edu.qa.automation.utils.WaitingProcess.setTime;

@Component
public class NewPerson extends BasePage{

    private By name = By.xpath("//*[@data-test-id='newperson_lastname']");
    private By lastName = By.xpath("//*[@data-test-id='newperson_name']");
    private By document = By.xpath("//*[@data-test-id='newperson_document']");
    private By addPerson = By.xpath("//*[@data-test-id='newperson_create']");

    public NewPerson enterName(String value){
        enterText(name, value);
        return this;
    }

    public NewPerson enterLastname(String value){
        enterText(lastName, value);
        return this;
    }

    public NewPerson enterDocument(String value){
        enterText(document, value);
        return this;
    }

    public NewPerson clickAddPerson(){
        clickElement(addPerson);
        setTime(ExpectedConditions.invisibilityOfElementLocated(addPerson));
        return this;
    }

}
