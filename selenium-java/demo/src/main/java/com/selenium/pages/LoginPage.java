package com.selenium.pages;
import com.selenium.reusables.ReusableFunctions;

public class LoginPage {
    ReusableFunctions ru;

    public LoginPage() throws Exception {
        ru = new ReusableFunctions();
    }

 public void LoginToApplication(String LocatorUsername,String LocatorPassword, String Username, String Password, String url){
    ru.navigateTo(url);
    ru.inputText(LocatorUsername,Username);
   ru.inputText(LocatorPassword,Password);
}
}