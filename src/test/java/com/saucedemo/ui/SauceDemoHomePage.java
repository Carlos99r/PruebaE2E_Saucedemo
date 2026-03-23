package com.saucedemo.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/")
public class SauceDemoHomePage extends PageObject {

    public static final Target USERNAME_INPUT = Target.the("campo de usuario")
            .located(By.id("user-name"));

    public static final Target PASSWORD_INPUT = Target.the("campo de password")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("boton de login")
            .located(By.id("login-button"));
}
