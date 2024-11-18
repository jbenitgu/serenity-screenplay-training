package com.example.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToProduct implements Task {
    private String idProduct;

    public GoToProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public static Performable with(String idProduct){
        return instrumented(GoToProduct.class, idProduct);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/inventory-item.html?id=" + this.idProduct)
        );
    }

}
