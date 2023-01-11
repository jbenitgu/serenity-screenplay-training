package com.example.stepdefinitions.mobile;

import com.example.tasks.mobile.Search;
import com.example.userinterfaces.screens.LoginScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import com.example.questions.mobile.SearchResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

public class AirbnbSearchStepsDefs {
    @Given("^que el (.*) se encuentra en el login de Airbnb$")
    public void queElUsuarioSeEncuentraEnElLoginDeAirbnb(String actor) {
      //  theActorCalled(actor).whoCan(BrowseTheWeb.with(hooks.hisMobileDevice));
        theActorCalled(actor).attemptsTo(
                Click.on(LoginScreen.BTN_CLOSE)
        );
    }

    @When("busca {string}")
    public void busco(String place) {
        theActorInTheSpotlight().attemptsTo(
                Search.withPlace(place)
        );

    }
    @Then("muestra el texto {string}")
    public void muestra_el_texto(String text) {
        theActorInTheSpotlight().should(
                seeThat("El texto del resultado de búsqueda", SearchResult.resultText(), equalTo(text))
        );

    }

}

