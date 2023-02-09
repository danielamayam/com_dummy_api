package com.dummy.api.stepsdefinitions;

import com.dummy.api.exceptions.AssertionsServices;
import com.dummy.api.questions.ValidarRespuestaEstado;
import com.dummy.api.taks.ConsumoDelete;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteStepDefinition {

    @When("Se llama la API Delete empleado {string}")
    public void seLlamaLaAPIDeleteEmpleado(String id) {
        theActorInTheSpotlight().attemptsTo(
                ConsumoDelete.service(Integer.parseInt(id))
        );
    }
    @Then("Debería ver el código {int}")
    public void deberíaVerElCódigo(Integer estatus) {
        theActorInTheSpotlight()
                .should(
                        seeThat(ValidarRespuestaEstado.expected(estatus))
                                .orComplainWith(AssertionsServices.class,
                                        AssertionsServices.NO_SE_ESPERA_LA_RESPUESTA_DE_LOS_SERVICIOS_DE_CÓDIGO_DE_ESTADO)
                );
    }

}
