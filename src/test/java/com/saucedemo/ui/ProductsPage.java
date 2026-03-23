package com.saucedemo.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {

    public static final Target PRODUCTS_TITLE = Target.the("titulo Products")
            .located(By.cssSelector(".title"));

    public static final Target SHOPPING_CART_LINK = Target.the("icono del carrito")
            .located(By.cssSelector("[data-test='shopping-cart-link']"));

    public static final Target PASSWORD_ALERT_ACCEPT_BUTTON = Target.the("boton aceptar de alerta emergente")
            .locatedBy("//button[normalize-space()='Aceptar']");

    public static final Target ADD_TO_CART_BUTTON = Target.the("boton agregar al carrito para {0}")
            .locatedBy("//div[contains(@class,'inventory_item')][.//div[contains(@class,'inventory_item_name') and normalize-space(text())='{0}']]//button");
}
