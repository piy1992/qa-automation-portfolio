package com.restassured;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import projectname.api.config.ConfigManager;

public class BaseTest {
    protected ConfigManager cm;

    @BeforeSuite
    public void setup(){
        //LogUtils.initLogging();
    }
    @BeforeClass
    public void setupClass(){
        cm = new ConfigManager();
    }
    @Parameters({"environment"})
    @BeforeMethod
    public void setupMethod(String env) {
        if(env!=null && !env.isEmpty()){
            System.setProperty("environment", env);
        }
    }
}
