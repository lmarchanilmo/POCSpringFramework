package edu.qa.automation.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;


@Component
@ConditionalOnProperty(name = "browser", havingValue = "chrome_remote")
@PropertySource({
        "classpath:config/${environment}.properties"
})
public class RemoteChromeDriverManager extends DriverManager{

    @Value("${remote.host}")
    String host;

    @Override
    protected WebDriver createDriver() {
        try {
            return new RemoteWebDriver(new URL (host), getChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--remote-allow-origins=*");
        return chromeOptions;
    }
}
