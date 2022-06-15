package com.digitalBooking.Tests;

import com.base.BasePage;
import com.digitalBooking.Pages.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class SearchTest {

    private WebDriver driver;
    //public WebDriverWait wait;

    @Before
    public void setUp() {
        BasePage _basePage = new BasePage();
        _basePage.openApp();
        driver = _basePage.getDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {
        SearchPage page = new SearchPage();
        page.buscarCiudad("punta del este");
        Thread.sleep(2000);
        page.buscar();
        Thread.sleep(2000);
        String res = page.getResultado();

        assertTrue(res.contains("Villa Kantounes Studio Ostria"));

        System.out.println("Resultado Card value: " + res);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
