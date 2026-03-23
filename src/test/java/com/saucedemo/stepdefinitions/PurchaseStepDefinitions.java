package com.saucedemo.stepdefinitions;

import com.saucedemo.models.CheckoutData;
import com.saucedemo.questions.PurchaseConfirmation;
import com.saucedemo.tasks.AddProductsToCart;
import com.saucedemo.tasks.Checkout;
import com.saucedemo.tasks.DismissPasswordPopup;
import com.saucedemo.tasks.LogIn;
import com.saucedemo.tasks.OpenCart;
import com.saucedemo.tasks.OpenTheApplication;
import com.saucedemo.ui.CartPage;
import com.saucedemo.ui.ProductsPage;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class PurchaseStepDefinitions {

    private static final String ACTOR_NAME = "Carlos";
    private static final List<String> PRODUCTS = Arrays.asList(
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light"
    );

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario inicia sesion en SauceDemo")
    public void queElUsuarioIniciaSesionEnSauceDemo() {
        OnStage.theActorCalled(ACTOR_NAME).attemptsTo(
                OpenTheApplication.onHomePage(),
                LogIn.withCredentials("standard_user", "secret_sauce")
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(ProductsPage.PRODUCTS_TITLE).text().isEqualTo("Products")
        );
    }

    @Cuando("agrega dos productos al carrito y completa la compra")
    public void agregaDosProductosAlCarritoYCompletaLaCompra() {
        CheckoutData checkoutData = new CheckoutData("Carlos", "Reinado", "170150");

        OnStage.theActorInTheSpotlight().attemptsTo(
                DismissPasswordPopup.ifPresent(),
                AddProductsToCart.named(PRODUCTS),
                OpenCart.view(),
                Ensure.that(CartPage.CART_TITLE).text().isEqualTo("Your Cart"),
                Ensure.that(CartPage.CART_ITEM.of(PRODUCTS.get(0))).isDisplayed(),
                Ensure.that(CartPage.CART_ITEM.of(PRODUCTS.get(1))).isDisplayed(),
                Checkout.withInformation(checkoutData)
        );
    }

    @Entonces("debe visualizar la confirmacion de compra exitosa")
    public void debeVisualizarLaConfirmacionDeCompraExitosa() {
        Serenity.recordReportData()
                .withTitle("Motivo de la comparacion final")
                .andContents("La validacion final es estricta y debe encontrar exactamente el texto "
                        + "'THANK YOU FOR YOUR ORDER'. Si la aplicacion muestra una variante como "
                        + "'Thank you for your order!', la prueba debe fallar porque no cumple con "
                        + "el valor esperado definido por el criterio de aceptacion.");

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(PurchaseConfirmation.message(), equalTo("THANK YOU FOR YOUR ORDER"))
        );
    }
}
