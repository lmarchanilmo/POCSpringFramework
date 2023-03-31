package edu.qa.automation.utils;


import org.openqa.selenium.By;

public enum MainMenuItem {

    EASY_ACCESS(By.xpath("//span[.='EasyAccess']")),
    ALUDOC(By.xpath("//span[.='Aludoc']")),
    TIKAS(By.xpath("//span[.='Tikas']")),
    MUSTERING(By.xpath("//span[.='Mustering']")),
    ACCESS_CONTROL(By.xpath("//span[.='Access Control']")),
    USERS(By.xpath("//span[.='Users']")),
    REPORTS(By.xpath("//span[.='Reports']")),
    MAPS(By.xpath("//span[.='Maps']")),
    SETTINGS(By.xpath("//span[.='Settings']"));

    private By locator;

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    MainMenuItem(By locator){
        this.locator = locator;
    }
}
