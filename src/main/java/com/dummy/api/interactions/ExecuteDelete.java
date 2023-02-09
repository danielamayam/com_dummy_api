package com.dummy.api.interactions;

import com.dummy.api.exceptions.AssertionsServices;
import com.dummy.api.exceptions.ErrorServicesException;
import com.dummy.api.utils.constants.Constantes;
import com.dummy.api.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.apache.http.HttpStatus;

public class ExecuteDelete implements Interaction {

    private int id;

    public ExecuteDelete(int id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Delete.from(Endpoints.URL_EMPLOYEESDELETE + id )
            );
            if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
                throw new ErrorServicesException(AssertionsServices.EL_CODIGO_DE_RESPUESTA_ES_DIFERENTE_AL_APROPIADO);
            }
        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_EXECUTEDELETE), ex);
        }
    }

    public static ExecuteDelete service(int randomNumber){
        return Instrumented.instanceOf(ExecuteDelete.class).withProperties(randomNumber);
    }
}
