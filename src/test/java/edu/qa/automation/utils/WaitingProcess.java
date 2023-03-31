package edu.qa.automation.utils;

import edu.qa.automation.configuration.DriverManager;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;


@Component
public class WaitingProcess {

    @Autowired
    DriverManager driverManager;


    static DriverManager dmStatic;
    @PostConstruct
    private void postConstruct(){
        dmStatic = driverManager;
    }

    static int TIMEOUT = 20;
    static int POLLING_EVERY = 1;

    static List<Class<? extends Throwable>> IGNORED_EXCEPTIONS=Arrays.asList(NoSuchElementException.class, StaleElementReferenceException.class, InvalidElementStateException.class);

    public static <R> R setTime(ExpectedCondition<R> expectedCondition, int timeout, int polling_every, List<Class<? extends Throwable>> ignoredException){
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(dmStatic.getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling_every))
                .ignoreAll(ignoredException);

        return (R)fluentWait.until(expectedCondition);
    }

    public static <R> R setTime(ExpectedCondition<R> expectedCondition){
        return setTime(expectedCondition, TIMEOUT, POLLING_EVERY, IGNORED_EXCEPTIONS);
    }

    public static <R> R setTime(ExpectedCondition<R> expectedCondition, int timeout){
        return setTime(expectedCondition, timeout, POLLING_EVERY, IGNORED_EXCEPTIONS);
    }

    public static <R> R setTime(ExpectedCondition<R> expectedCondition, int timeout, int pooling_every){
        return setTime(expectedCondition, timeout, pooling_every, IGNORED_EXCEPTIONS);
    }
}
