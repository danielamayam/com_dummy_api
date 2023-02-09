package com.dummy.api.taks;

import com.dummy.api.interactions.ExecuteGet;
import com.dummy.api.interactions.ExecuteGetId;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumoGetId implements Task {

    private int id;

    public ConsumoGetId(int id){
        this.id = id;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecuteGetId.service(id)
        );
    }

    public static ConsumoGetId service(int id){
        return Tasks.instrumented(ConsumoGetId.class, id);
    }

}
