package com.example.questions.web;

import com.example.userinterfaces.pages.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class LoginQuestion {

    public static Question<String> errorMessage(){
        return actor -> TextContent.of(LoginPage.ERROR_TEXT).answeredBy(actor);
    }
}
