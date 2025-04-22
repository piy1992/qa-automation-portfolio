package com.selenium.pages;
import com.selenium.reusables.ReusableFunctions;

public class HealthCheckPage {
    ReusableFunctions ru;
    public HealthCheckPage(String url, String Locator) throws Exception {
        ru = new ReusableFunctions();
        ru.navigateTo(url);
        ru.explicitWaitVisibility(Locator);
    }
}