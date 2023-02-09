package com.dummy.api.stepsdefinitions;

import com.dummy.api.models.EmpleadoModel;
import com.dummy.api.questions.ValidarRespuestaPost;
import com.dummy.api.taks.ConsumoPost;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostStepDefinition {

    @When("Se llama la API Post empleado")
    public void seLlamaLaAPIPostEmpleado(DataTable data) {
        theActorInTheSpotlight().attemptsTo(
               ConsumoPost.service(EmpleadoModel.setData(data).get(0))
        );
    }
    @Then("Válido el registro exitoso")
    public void válidoElRegistroExitoso() {
        theActorInTheSpotlight()
                .should(seeThat(
                        ValidarRespuestaPost.expected()
                        )
                );
    }
}
