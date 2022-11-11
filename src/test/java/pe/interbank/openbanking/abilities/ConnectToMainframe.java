package pe.interbank.openbanking.abilities;

import mainframe.com.bdd.lib.EmulatorActions;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class ConnectToMainframe extends EmulatorActions implements Ability {

    private final environment.EnvironmentVariables environmentVariables;

    public ConnectToMainframe(EnvironmentVariables environmentVariables) {
        this.environmentVariables = (environment.EnvironmentVariables) environmentVariables;
    }

    public static ConnectToMainframe as(Actor actor){
        return  (ConnectToMainframe)actor.abilityTo(ConnectToMainframe.class);
    }

    public void connectServer(EnvironmentVariables environmentVariables){
        getInstancia().connectServer((environment.EnvironmentVariables) environmentVariables);
    }
}
