package pe.interbank.openbanking.actions.mainframe;

import mainframe.com.bdd.lib.EmulatorActions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PrintConsoleScreen extends EmulatorActions implements Interaction {


    @Step("{0} prints")
    @Override
    public <T extends Actor> void performAs(T actor) {
        getInstancia().imprimirPantallaConsola();
    }
}
