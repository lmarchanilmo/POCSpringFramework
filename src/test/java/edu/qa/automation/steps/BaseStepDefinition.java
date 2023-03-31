package edu.qa.automation.steps;

import edu.qa.automation.config.Config;
import edu.qa.automation.pages.Aludoc;
import edu.qa.automation.pages.AsideMenu;
import edu.qa.automation.pages.EasyAccess;
import edu.qa.automation.pages.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Config.class)
public class BaseStepDefinition {

    @Autowired
    Login login;

    @Autowired
    AsideMenu asideMenu;

    @Autowired
    Aludoc aludoc;

    @Autowired
    EasyAccess easyAccess;
}
