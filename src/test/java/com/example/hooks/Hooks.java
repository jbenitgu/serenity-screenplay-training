package com.example.hooks;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
//import org.junit.Before;
import io.cucumber.java.Before;

import static com.example.utils.RestAssuredConfig.configRestAssured;

public class Hooks {
    @Before(order = 1)
    public void actorCanBrowseTheMobileApp(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 0)
    public void setUp() {
        configRestAssured();
    }
}
