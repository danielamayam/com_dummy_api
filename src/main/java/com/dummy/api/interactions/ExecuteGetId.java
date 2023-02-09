package com.dummy.api.interactions;

import com.dummy.api.utils.constants.Endpoints;
import com.dummy.api.utils.resource.WebServiceEndPoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;

public class ExecuteGetId implements Interaction {

    private int id;

    public ExecuteGetId(int id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(Endpoints.URL_EMPLOYEEID + id)
        );
        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            System.out.println("Error");
        }
    }

    public static ExecuteGetId service(int id){
        return Instrumented.instanceOf(ExecuteGetId.class).withProperties(id);
    }
}
