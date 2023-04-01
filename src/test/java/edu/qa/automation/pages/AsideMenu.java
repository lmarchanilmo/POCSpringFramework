package edu.qa.automation.pages;

import edu.qa.automation.utils.MainMenuItem;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class AsideMenu extends BasePage {
    @Step
    public void selectMenuItem(MainMenuItem mainMenuItem) {
        clickElement(mainMenuItem.getLocator());
    }
}
