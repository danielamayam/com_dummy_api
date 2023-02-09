package com.dummy.api.taks;

import com.dummy.api.models.EmpleadoModel;
import com.dummy.api.utils.constants.Endpoints;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import static io.restassured.http.ContentType.JSON;
import org.apache.http.HttpStatus;

public class ConsumoUpdate implements Task {

    private EmpleadoModel empleadoModel;

    public ConsumoUpdate(EmpleadoModel empleadoModel){
        this.empleadoModel = empleadoModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println();
        actor.attemptsTo(
                Put.to(Endpoints.URL_EMPLOYEEUPDATE + empleadoModel.getId())
                        .with(request -> request
                                .contentType(JSON)
                                .body(empleadoModel.toString())
                                .relaxedHTTPSValidation()
                        )
        );
        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            System.out.println("Error");
        }
    }

    public static ConsumoUpdate service(EmpleadoModel empleadoModel){
        return Tasks.instrumented(ConsumoUpdate.class, empleadoModel);
    }
}
