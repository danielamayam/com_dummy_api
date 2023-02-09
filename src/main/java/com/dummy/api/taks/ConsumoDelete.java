package com.dummy.api.taks;

import com.dummy.api.interactions.ExecuteDelete;
import com.dummy.api.utils.utilidades.GenerarId;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumoDelete implements Task {

    private int id;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            ExecuteDelete.service(GenerarId.getRandomNumber())
        );
    }

    public static ConsumoDelete service(){
        return Tasks.instrumented(ConsumoDelete.class);
    }
}
