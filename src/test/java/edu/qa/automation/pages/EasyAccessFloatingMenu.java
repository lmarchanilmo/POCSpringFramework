package edu.qa.automation.pages;

import edu.qa.automation.utils.EasyAccessFloatingMenuItem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class EasyAccessFloatingMenu extends BasePage {

    private By plusButton = By.xpath("//button[@aria-label='SpeedDial']");

    @Step
    public void selectMenuItem(EasyAccessFloatingMenuItem easyAccessFloatingMenuItem) {
        clickElement(plusButton);
        clickElement(easyAccessFloatingMenuItem.getLocator());
    }
}
