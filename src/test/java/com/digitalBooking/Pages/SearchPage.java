package com.digitalBooking.Pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {

    //public WebDriverWait wait = new WebDriverWait(_driver, Duration.ofMillis(1000));

    protected static final String ciudadID = "ciudad";
    protected static final String botonBuscar = "btn-buscador";
    protected static final String resultadoID = "card-list";
    protected static final String botonLogin = "login";

    public void buscarCiudad(String ciudad) throws InterruptedException {
        WebElement searchBox = getWebElement(By.id(ciudadID));
        searchBox.clear();
        searchBox.sendKeys(ciudad);
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.textToBePresentInElement(searchBox, ciudad));
        searchBox.sendKeys(Keys.ENTER);
    }

    public String getResultado() {
        WebElement resultado = getWebElement(By.className(resultadoID));
        return resultado.getText();
    }

    public void buscar() {
        WebElement buscar = getWebElement(By.id(botonBuscar));
        buscar.click();
    }

    public void irALogin() throws InterruptedException{
        WebElement login = getWebElement(By.xpath("//a[@href='/login']"));
        Thread.sleep(1000);
        login.click();
    }
}
