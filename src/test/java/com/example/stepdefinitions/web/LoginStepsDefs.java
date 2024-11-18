package com.example.stepdefinitions.web;

import com.example.tasks.web.GoToProduct;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.example.questions.web.InventoryDisplayed;
import com.example.questions.web.LoginQuestion;
import com.example.tasks.web.Login;
import com.example.tasks.web.Logout;
import com.example.tasks.web.NavigateTo;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepsDefs {
    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario (Scenario scenario){
        this.scenario = scenario;
    }

    @Given("^que el (.*) se encuentra en la página SauceDemo$")
    public void queElClienteSeEncuentraEnLaPáginaSauceDemo(String actor) {
        theActorCalled(actor).attemptsTo(
                NavigateTo.sauceDemoPage()
        );
        screenShot();
    }


    @When("inicia sesión con las credenciales: {string}, {string}")
    public void iniciaSesiónConLasCredenciales(String user, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(user, password)
        );
        screenShot();
    }

    @When("inicia sesión con las credenciales")
    public void iniciaSesiónConLasCredenciales(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> user : data){
            theActorInTheSpotlight().attemptsTo(
                    Login.withCredentials(user.get("user"), user.get("password")),
                    new Logout()
            );
        }

        screenShot();
    }

    @Then("el login es satisfactorio")
    public void el_login_es_satisfactorio() {
        theActorInTheSpotlight().should(
                seeThat("El título products es visible", InventoryDisplayed.titleProducts(), equalTo(true))
        );
        screenShot();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @Then("se muestra el mensaje de error {string}")
    public void seMuestraElMensajeDeError(String message) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de error", LoginQuestion.errorMessage(), equalTo(message))
        );

    }


    @When("navegado al producto de ID {string}")
    public void navegadoAlProductoDeID(String idProduct) {
        theActorInTheSpotlight().attemptsTo(
                GoToProduct.with(idProduct)
        );
    }

}
