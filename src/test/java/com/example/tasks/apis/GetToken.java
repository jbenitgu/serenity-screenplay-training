package com.example.tasks.apis;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import com.example.utils.WebServiceEndpoints;

public class GetToken implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(WebServiceEndpoints.GENERATE_TOKEN.getPath()).with(
                        requestSpecification -> requestSpecification
                                .auth().basic("vFaCse3R9RDoJUGU", "zPf8h48xwqgB4yzT")
                                .contentType("application/x-www-form-urlencoded")
                                .header("Ocp-Apim-Subscription-Key", "332a09a749cd4b0eb2d760af339d569f")
                                .body("grant_type=client_credentials&scope=token:application")
                )
        );

    }
}
