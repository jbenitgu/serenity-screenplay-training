package com.example.stepdefinitions.apis;

import com.example.questions.apis.ResponseCode;
import com.example.tasks.apis.ConsultaMascota;
import com.example.tasks.apis.CrearMascota;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetStoreStepDef {
    EnvironmentVariables environmentVariables;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^el (.*) accede a la tienda$")
    public void elUsuarioAccedeALaTienda(String actor) {
        theActorCalled(actor)
                .whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));
    }

    @When("consulta una mascota de ID {string}")
    public void consultaUnaMascotaDeID(String idMascota) {
        theActorInTheSpotlight().attemptsTo(
            ConsultaMascota.with(idMascota)
        );
    }



    @Then("la respuesta es correcta")
    public void laRespuestaEsCorrecta() {
        theActorInTheSpotlight().should(
                seeThat("El código de respuesta", new ResponseCode(), equalTo(200))
        );
    }


    @When("crea una nueva mascota {string} en {string} con codigo {string}")
    public void creaUnaNuevaMascotaEn(String nombreMascota, String categoriaMascota, String codigoMascota) {
        theActorInTheSpotlight().attemptsTo(
                CrearMascota.with(nombreMascota, categoriaMascota, codigoMascota)
                //new CrearMascota(nombreMascota, categoriaMascota, codigoMascota)
        );


    }


}
