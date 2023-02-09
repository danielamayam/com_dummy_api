package com.dummy.api.interactions;

import com.dummy.api.exceptions.AssertionsServices;
import com.dummy.api.exceptions.ErrorServicesException;
import com.dummy.api.models.EmpleadoModel;
import com.dummy.api.utils.constants.Constantes;
import com.dummy.api.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;
import static io.restassured.http.ContentType.JSON;

public class ExecutePost implements Interaction {

    private EmpleadoModel empleadoModel;

    public ExecutePost(EmpleadoModel empleadoModel){
        this.empleadoModel = empleadoModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       try {
           SerenityRest.reset();
           actor.attemptsTo(
                   Post.to(Endpoints.URL_EMPLOYEECREATE)
                           .with(request -> request
                                   .contentType(JSON)
                                   .body(empleadoModel.toString())
                                   .relaxedHTTPSValidation())
           );
           if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
               throw new ErrorServicesException(AssertionsServices.EL_CODIGO_DE_RESPUESTA_ES_DIFERENTE_AL_APROPIADO);
           }
       }catch (RuntimeException ex){
           throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_EXECUTEPOST), ex);
       }
    }

    public static ExecutePost service(EmpleadoModel empleadoModel){
        return Instrumented.instanceOf(ExecutePost.class).withProperties(empleadoModel);
    }
}
