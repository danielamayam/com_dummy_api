package com.dummy.api.interactions;

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
        SerenityRest.reset();
        actor.attemptsTo(
                Delete.from(Endpoints.URL_EMPLOYEESDELETE + id)
        );
        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            System.out.println("Error");
        }
    }

    public static ExecuteDelete service(int randomNumber){
        return Instrumented.instanceOf(ExecuteDelete.class).withProperties(randomNumber);
    }
}
