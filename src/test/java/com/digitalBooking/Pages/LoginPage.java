package com.digitalBooking.Pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

public class LoginPage extends BasePage {

    protected static final By inputEmail = By.id("email");
    protected static final By inputPassword = By.id("password");
    protected static final By btnEnviar = By.className("btn-primario");
    protected static final By iconoUsuario = By.className("icono-usuario");

    public WebDriverWait wait = new WebDriverWait(_driver, Duration.ofMillis(1000));

    public void completarInputs(String email, String pass){
        WebElement weMail = getWebElement(inputEmail);
        WebElement wePass = getWebElement(inputPassword);

        weMail.sendKeys(email);
        wePass.sendKeys(pass);
    }

    public void enviarLogin() {
        WebElement weBtn = getWebElement(btnEnviar);
        wait.until(ExpectedConditions.elementToBeClickable(weBtn));
        weBtn.click();
    }

    public void obtenerResultado(){
        wait.until(ExpectedConditions.urlToBe("http://fe.deitech.online/"));
        boolean exists = _driver.findElements(iconoUsuario).size() != 0;
        assertTrue(exists);
        System.out.println("Esta logueado?: " + exists);
        assertEquals(_driver.getCurrentUrl(), "http://fe.deitech.online/");
        System.out.println("URL actual: " + _driver.getCurrentUrl());
    }
}
