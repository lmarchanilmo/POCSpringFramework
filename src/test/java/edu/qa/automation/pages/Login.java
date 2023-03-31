package edu.qa.automation.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class Login extends BasePage{

    private By username = By.xpath("//*[@data-test-id='login_username']");
    private By password = By.xpath("//*[@data-test-id='login_password']");
    private By login = By.xpath("//*[@data-test-id='login_button']");

    public Login enterUsername(String value){
        enterText(username, value);
        return this;
    }

    public Login enterPassword(String value){
        enterText(password, value);
        return this;
    }

    public void clickLogin(){
        clickElement(login);
    }

}
