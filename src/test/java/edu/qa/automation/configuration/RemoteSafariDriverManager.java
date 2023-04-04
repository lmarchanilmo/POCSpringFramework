package edu.qa.automation.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;


@Component
@ConditionalOnProperty(name = "browser", havingValue = "safari_remote")
@PropertySource({
        "classpath:config/${environment}.properties"
})
public class RemoteSafariDriverManager extends DriverManager{

    @Value("${remote.host}")
    String host;

    @Override
    protected WebDriver createDriver() {
        try {
            return new RemoteWebDriver(new URL (host), getSafariOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private SafariOptions getSafariOptions(){
        SafariOptions safariOptions = new SafariOptions();
        return safariOptions;
    }
}
