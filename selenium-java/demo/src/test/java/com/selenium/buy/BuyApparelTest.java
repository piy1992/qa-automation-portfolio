package com.selenium.buy;

import java.util.Properties;
import java.util.ResourceBundle;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.selenium.pages.HealthCheckPage;
import com.selenium.pages.LoginPage;
import com.selenium.reusables.ReusableFunctions;
import com.selenium.utils.EnvLoader;
import com.selenium.utils.PropertiesReader;

import io.github.cdimascio.dotenv.Dotenv;

public class BuyApparelTest {
    LoginPage lg;
    Dotenv env = null;
    Properties locators = null;

    @BeforeSuite
    @Parameters("environment")
    public void BeforeSuiteSetup(String environment) throws Exception {
        PropertiesReader pr = new PropertiesReader();
        locators = pr.readPropertyFile("src/main/resources/locators/login-locators.properties");
        EnvLoader loader = new EnvLoader();
        env = loader.loadEnv(environment);
        HealthCheckPage hcp = new HealthCheckPage(env.get("BASE_URL"), locators.getProperty("username_xpath"));
    }

    @BeforeMethod
    public void initializeClasses() throws Exception {
        lg = new LoginPage();
    }

    @Test
    public void testBrowserInitialization() {
        lg.LoginToApplication(locators.getProperty("username_xpath"), locators.getProperty("password_xpath"),
                env.get("UI_USERNAME"), env.get("UI_PASSWORD"), env.get("BASE_URL"));
    }

    @AfterMethod
    public void afterMethod() {
        ReusableFunctions.killBrowsers();
    }

    @AfterSuite
    public void teardown_method() {
    }
}