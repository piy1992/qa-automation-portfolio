package com.selenium.reusables;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.utils.PropertiesReader;

public class ReusableFunctions extends CreateWebDriver {
    Duration waittime = Duration.ofSeconds(10);

    public ReusableFunctions() throws Exception {
        PropertiesReader pr = new PropertiesReader();
        Properties config = pr.readPropertyFile("src/main/resources/config/configdevelopment.properties");
        waittime = Duration.ofSeconds(Integer.parseInt(config.getProperty("global.wait.duration")));
        this.driver = getDriver("Chrome");
        System.out.println("Browser initialized successfully");
    }

    public void explicitWaitVisibility(String Locator){
        WebDriverWait wait = new WebDriverWait(driver, waittime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator)));
    }

    public void navigateTo(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(waittime);
    }

    public void clickElement(String Locator) {
        driver.findElement(By.xpath(Locator)).click();
    }

    public String gettext(String Locator) {
        return driver.findElement(By.xpath(Locator)).getText();
    }
    public void closeDriver() {
        driver.quit();
    }

    public void selectOption(String Locator, String text) {
        Select select = new Select(driver.findElement(By.xpath(Locator)));
        select.selectByVisibleText(text);
    }

    public void inputText(String Locator, String text) {
        driver.findElement(By.xpath(Locator)).sendKeys(text);
    }
    public static void killBrowsers() {
        String os = System.getProperty("os.name").toLowerCase();
        
        try {
            if (os.contains("mac")) {
                // Kill Chrome on macOS
                ProcessBuilder chromePB = new ProcessBuilder("pkill", "-f", "Google Chrome");
                chromePB.start().waitFor();
                
                // Kill ChromeDriver on macOS
                ProcessBuilder driverPB = new ProcessBuilder("pkill", "-f", "chromedriver");
                driverPB.start().waitFor();
                
            } else if (os.contains("windows")) {
                ProcessBuilder chromePB = new ProcessBuilder("cmd", "/c", "taskkill", "/F", "/IM", "chrome.exe");
                chromePB.start().waitFor();
                
                ProcessBuilder driverPB = new ProcessBuilder("cmd", "/c", "taskkill", "/F", "/IM", "chromedriver.exe");
                driverPB.start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
