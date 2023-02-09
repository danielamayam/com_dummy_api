package com.dummy.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class ValidarRetornoDatos implements Question<Boolean> {

    private String nombre;

    public ValidarRetornoDatos(String nombre){
        this.nombre = nombre;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.should(
                ResponseConsequence.seeThatResponse("Los valores optenidos de la respuesta de la api existe",
                        response -> response
                                .assertThat()
                                .and().body("data.employee_name", Matchers.equalTo(nombre)))
        );
        return true;
    }

    public static ValidarRetornoDatos expected(String nombre){
        return new ValidarRetornoDatos(nombre);
    }
}
