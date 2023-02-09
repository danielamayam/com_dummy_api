package com.dummy.api.taks;

import com.dummy.api.interactions.ExecuteDelete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumoDelete implements Task {

    private int id;

    public ConsumoDelete(int id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            ExecuteDelete.service(id)
        );
    }

    public static ConsumoDelete service(int id){
        return Tasks.instrumented(ConsumoDelete.class, id);
    }
}
