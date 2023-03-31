package edu.qa.automation.configuration;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class DriverManager {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    protected abstract WebDriver createDriver();

    public void quitDriver(){
        if(null != drivers.get()){
            drivers.get().quit();
            drivers.remove();
        }
    }

    public WebDriver getDriver(){
        if(null == drivers.get()){
            drivers.set(this.createDriver());
        }
        drivers.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        return drivers.get();
    }

}
