package com.saucedemo.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target FIRST_NAME_INPUT = Target.the("campo first name")
            .located(By.id("first-name"));

    public static final Target LAST_NAME_INPUT = Target.the("campo last name")
            .located(By.id("last-name"));

    public static final Target POSTAL_CODE_INPUT = Target.the("campo postal code")
            .located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON = Target.the("boton continue")
            .located(By.id("continue"));

    public static final Target FINISH_BUTTON = Target.the("boton finish")
            .located(By.id("finish"));

    public static final Target COMPLETE_HEADER = Target.the("mensaje de confirmacion")
            .located(By.cssSelector(".complete-header"));
}
