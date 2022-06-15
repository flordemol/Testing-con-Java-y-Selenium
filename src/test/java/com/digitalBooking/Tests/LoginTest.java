package com.digitalBooking.Tests;

import com.base.BasePage;
import com.digitalBooking.Pages.LoginPage;
import com.digitalBooking.Pages.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        BasePage _basePage = new BasePage();
        _basePage.openApp();
        driver = _basePage.getDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {
        SearchPage searchPage = new SearchPage();
        LoginPage loginPage = new LoginPage();
        searchPage.irALogin();
        loginPage.completarInputs("florenciademollein@gmail.com", "cuentadb");
        loginPage.enviarLogin();
        loginPage.obtenerResultado();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
