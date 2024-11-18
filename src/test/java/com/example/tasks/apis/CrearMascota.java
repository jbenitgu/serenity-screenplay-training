package com.example.tasks.apis;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearMascota implements Task {

    private String nombreMascota;
    private String categoriaMascota;
    private String codigoMascota;

    public CrearMascota(String nombreMascota, String categoriaMascota, String codigoMascota) {
        this.nombreMascota = nombreMascota;
        this.categoriaMascota = categoriaMascota;
        this.codigoMascota = codigoMascota;
    }

    public static Performable with(String nombreMascota, String categoriaMascota, String codigoMascota){
        return instrumented(CrearMascota.class, nombreMascota, categoriaMascota, codigoMascota);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String bodyJson = "{\n" +
                "  \"id\": " + codigoMascota + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"" + categoriaMascota + "\"\n" +
                "  },\n" +
                "   \"name\": \"" +  nombreMascota + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        actor.attemptsTo(
                Post.to("/pet").with(requestSpecification -> requestSpecification.log().all().body(bodyJson))
        );

        SerenityRest.then().log().all();

    }
}
