package edu.qa.automation.utils;


import org.openqa.selenium.By;

public enum EasyAccessFloatingMenuItem {

    NEW_PERSON(By.xpath("//div[@id=\"SpeedDial-actions\"]//button[1]")),
    NEW_EVENT(By.xpath("//div[@id=\"SpeedDial-actions\"]//button[2]")),
    NEW_COMPANY(By.xpath("//div[@id=\"SpeedDial-actions\"]//button[3]")),
    NEW_STATUS(By.xpath("//div[@id=\"SpeedDial-actions\"]//button[4]"));

    private By locator;

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    EasyAccessFloatingMenuItem(By locator){
        this.locator = locator;
    }
}
