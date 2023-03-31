package edu.qa.automation.pages;

import edu.qa.automation.utils.MainMenuItem;
import org.springframework.stereotype.Component;

@Component
public class AsideMenu extends BasePage {

    public void selectMenuItem(MainMenuItem mainMenuItem) {
        clickElement(mainMenuItem.getLocator());
    }
}
