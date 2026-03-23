package com.saucedemo.tasks;

import com.saucedemo.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class DismissPasswordPopup implements Task {

    public static DismissPasswordPopup ifPresent() {
        return Tasks.instrumented(DismissPasswordPopup.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (ProductsPage.PASSWORD_ALERT_ACCEPT_BUTTON.resolveFor(actor).isPresent()) {
            actor.attemptsTo(Click.on(ProductsPage.PASSWORD_ALERT_ACCEPT_BUTTON));
        }
    }
}
