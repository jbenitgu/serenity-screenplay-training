package com.example.questions.web;

import com.example.userinterfaces.pages.InventoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

public class InventoryDisplayed {

    public static Question<Boolean> titleProducts(){
        return actor -> Visibility.of(InventoryPage.PRODUCTS_TITLE).answeredBy(actor).booleanValue();
    }

    public static Question <String> text(){
        return actor -> Text.of(InventoryPage.PRODUCTS_TITLE.of("").called("")).answeredBy(actor);
    }
}
