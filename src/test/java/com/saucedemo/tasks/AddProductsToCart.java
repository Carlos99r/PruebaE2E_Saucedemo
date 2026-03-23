package com.saucedemo.tasks;

import com.saucedemo.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

public class AddProductsToCart implements Task {

    private final List<String> products;

    public AddProductsToCart(List<String> products) {
        this.products = products;
    }

    public static AddProductsToCart named(List<String> products) {
        return Tasks.instrumented(AddProductsToCart.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String product : products) {
            actor.attemptsTo(Click.on(ProductsPage.ADD_TO_CART_BUTTON.of(product)));
        }
    }
}
