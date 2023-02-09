package com.dummy.api.taks;

import com.dummy.api.interactions.ExecutePost;
import com.dummy.api.models.EmpleadoModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumoPost implements Task {

    private EmpleadoModel empleadoModel;

    public ConsumoPost(EmpleadoModel empleadoModel) {
        this.empleadoModel = empleadoModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecutePost.service(empleadoModel)
        );
    }

    public static ConsumoPost service(EmpleadoModel empleadoModel) {
        return Tasks.instrumented(ConsumoPost.class, empleadoModel);
    }
}
