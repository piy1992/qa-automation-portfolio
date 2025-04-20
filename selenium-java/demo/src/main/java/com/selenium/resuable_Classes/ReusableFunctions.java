package com.selenium.resuable_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ReusableFunctions extends CreateWebDriver {
    public void navigateTo(String url){
        driver.get(url);
    }
    public void clickElement(String Locator){
        driver.findElement(By.xpath(Locator)).click();;
    }
    public String gettext(String Locator){
        return driver.findElement(By.xpath(Locator)).getText();
    }
    public void selectOption(String Locator, String text){
        Select select = new Select(driver.findElement(By.xpath(Locator)));
        select.selectByVisibleText(text);
    }
}
