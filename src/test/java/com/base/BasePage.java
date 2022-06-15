package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public static WebDriver _driver;
    protected static final String URL = "http://fe.deitech.online/";

    public BasePage() {
        if (_driver == null) {
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
            _driver = new ChromeDriver();
            _driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver() {
        return _driver;
    }

    public void openApp() {
        _driver.get(URL);
    }

    public WebElement getWebElement(By locator) {
        WebElement elem = null;
        try
        {
            elem = _driver.findElement(locator);
        }
        catch(Exception e)
        {
            System.out.println("There is no an Element: " + locator);
            System.out.println("Exception message: " + e);
        }
        return elem;
    }
}
