package com.selenium.reusables;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateWebDriver {
    WebDriver driver = null;
    public WebDriver getDriver(String browser) {
        if(browser.equalsIgnoreCase("Chrome")){
            //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
