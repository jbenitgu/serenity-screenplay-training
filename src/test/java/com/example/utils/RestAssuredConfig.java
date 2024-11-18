package com.example.utils;


import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import net.serenitybdd.rest.SerenityRest;

public class RestAssuredConfig {


    public static void configRestAssured() {
        System.out.println("Config Rest Assured");
        RestAssured.config = RestAssured.config()
                .sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());

        SerenityRest.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
    }
}
