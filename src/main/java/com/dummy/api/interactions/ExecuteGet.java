package com.dummy.api.interactions;

import com.dummy.api.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;


public class ExecuteGet implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(Endpoints.URL_EMPLOYEES)
        );
        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            System.out.println("Error");
        }
    }

    public static ExecuteGet service(){
        return Instrumented.instanceOf(ExecuteGet.class).withProperties();
    }
}
