package com.saucedemo.questions;

import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class PurchaseConfirmation {

    public static Question<String> message() {
        return actor -> Text.of(CheckoutPage.COMPLETE_HEADER).viewedBy(actor).asString();
    }
}
