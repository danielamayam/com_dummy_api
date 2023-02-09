package com.dummy.api.stepsdefinitions;

import com.dummy.api.questions.ValidarRespuestaEstado;
import com.dummy.api.taks.ConsumoDelete;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteStepDefinition {

    @When("Se llama la API Delete empleado")
    public void seLlamaLaAPIDeleteEmpleado() {
        theActorInTheSpotlight().attemptsTo(
                ConsumoDelete.service()
        );
    }
    @Then("Debería ver el código {int}")
    public void deberíaVerElCódigo(Integer estatus) {
        theActorInTheSpotlight()
                .should(
                        seeThat(ValidarRespuestaEstado.expected(estatus))
                );
    }

}
