package com.example.tasks.apis;

import com.example.models.Mascota;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultaMascota implements Task {
    private final String id;

    ConsultaMascota(String id){
        this.id = id;
    }

    public static Performable with(String id){
        return instrumented(ConsultaMascota.class, id);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/pet/" + id).with(request -> request.log().all())
        );



        SerenityRest.then().log().all();

        Mascota pet = SerenityRest.lastResponse().as(Mascota.class);

        System.out.println("Pet Name: " + pet.getName());
        System.out.println("Category: " + pet.getCategory().getName());
    }
}
