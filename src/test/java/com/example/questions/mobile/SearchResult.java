package com.example.questions.mobile;

import com.example.userinterfaces.screens.SearchScreen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class SearchResult {

    public static Question<String> resultText(){
        return actor -> Text.of(SearchScreen.RESULT_TEXT).answeredBy(actor);
    }
}
