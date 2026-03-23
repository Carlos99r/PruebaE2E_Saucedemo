package com.saucedemo.tasks;

import com.saucedemo.models.CheckoutData;
import com.saucedemo.ui.CartPage;
import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Checkout implements Task {

    private final CheckoutData checkoutData;

    public Checkout(CheckoutData checkoutData) {
        this.checkoutData = checkoutData;
    }

    public static Checkout withInformation(CheckoutData checkoutData) {
        return Tasks.instrumented(Checkout.class, checkoutData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON),
                Enter.theValue(checkoutData.getFirstName()).into(CheckoutPage.FIRST_NAME_INPUT),
                Enter.theValue(checkoutData.getLastName()).into(CheckoutPage.LAST_NAME_INPUT),
                Enter.theValue(checkoutData.getPostalCode()).into(CheckoutPage.POSTAL_CODE_INPUT),
                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}
