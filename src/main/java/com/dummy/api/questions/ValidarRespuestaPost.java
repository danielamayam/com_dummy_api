package com.dummy.api.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.apache.http.HttpStatus;

public class ValidarRespuestaPost implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                ResponseConsequence.seeThatResponse("Código de estado de la respuesta de la API del servicio",
                        response -> response
                                .statusCode(HttpStatus.SC_OK)
                )
        );
        return true;
    }

    public static ValidarRespuestaPost expected(){
        return new ValidarRespuestaPost();
    }
}
