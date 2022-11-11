package pe.interbank.openbanking.stepdefinitions;

import environment.ManageEnvironment;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import mainframe.com.bdd.generic.Constants;
import mainframe.com.bdd.lib.EmulatorActions;
import mainframe.com.bdd.util.UtilMainframe;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import pe.interbank.openbanking.abilities.ConnectToMainframe;
import pe.interbank.openbanking.actions.mainframe.Emulator;
import pe.interbank.openbanking.actions.mainframe.PrintConsoleScreen;
import pe.interbank.openbanking.actions.mainframe.WaitEmulator;
import pe.interbank.openbanking.actions.mainframe.WriteEmulator;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MainframeStepDefs extends EmulatorActions {

    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("instancio la sesión de mainframe")
    public void instancioLaSesiónDeMainframe() {
        scenario = UtilMainframe.getVariableOnSession(Constants.SCENARIO);

        //getInstancia().connectServer(ManageEnvironment.getEnvironment());
        theActorCalled("User").attemptsTo(
               WaitEmulator.withMiliseconds(2000),
                WriteEmulator.theValue("dd"),
               new PrintConsoleScreen(),
                Emulator.with(Emulator.Keys.PRINT)
        );
    }
}
