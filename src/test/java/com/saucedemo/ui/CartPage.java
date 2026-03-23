package com.saucedemo.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final Target CART_TITLE = Target.the("titulo Your Cart")
            .located(By.cssSelector(".title"));

    public static final Target CHECKOUT_BUTTON = Target.the("boton checkout")
            .located(By.id("checkout"));

    public static final Target CART_ITEM = Target.the("producto {0} en el carrito")
            .locatedBy("//div[@class='cart_item']//div[@class='inventory_item_name' and normalize-space(text())='{0}']");
}
