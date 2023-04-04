package edu.qa.automation.configuration;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


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
            return new RemoteWebDriver(new URL (host), getCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private SafariOptions getSafariOptions(){
        SafariOptions safariOptions = new SafariOptions();
        return safariOptions;
    }

    private MutableCapabilities getCapabilities(){
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Safari");
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", "OS X");
        browserstackOptions.put("osVersion", "Snow Leopard");
        browserstackOptions.put("browserVersion", "5.1");
        browserstackOptions.put("local", "false");
        browserstackOptions.put("seleniumVersion", "2.45.0");
        capabilities.setCapability("bstack:options", browserstackOptions);
        return capabilities;
    }
}
