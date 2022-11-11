package pe.interbank.openbanking.actions.mainframe;

import net.serenitybdd.screenplay.Performable;

import java.util.Locale;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Emulator {

    public enum Keys{
        PRINT, WAIT
    }

    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }

    public static Performable with(Keys keys){
    switch (keys){
        case PRINT:
            return instrumented(PrintConsoleScreen.class);
        case WAIT:
            return instrumented(WaitEmulator.class);
        default:
        throw new UnsupportedOperationException("Unsopported " + keys);
    }

    }

}
