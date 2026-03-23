package com.saucedemo.tasks;

import com.saucedemo.ui.SauceDemoHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LogIn implements Task {

    private final String username;
    private final String password;

    public LogIn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LogIn withCredentials(String username, String password) {
        return Tasks.instrumented(LogIn.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(SauceDemoHomePage.USERNAME_INPUT),
                Enter.theValue(password).into(SauceDemoHomePage.PASSWORD_INPUT),
                Click.on(SauceDemoHomePage.LOGIN_BUTTON)
        );
    }
}
