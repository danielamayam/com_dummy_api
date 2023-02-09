package com.dummy.api.stepsdefinitions;

import com.dummy.api.exceptions.AssertionsServices;
import com.dummy.api.models.EmpleadoModel;
import com.dummy.api.questions.ValidarRespuestaEstado;
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
    @Then("Válido el registro exitoso {int}")
    public void válidoElRegistroExitoso(Integer estatus) {
        theActorInTheSpotlight()
                .should(
                        seeThat(ValidarRespuestaEstado.expected(estatus))
                                .orComplainWith(AssertionsServices.class,
                                        AssertionsServices.NO_SE_ESPERA_LA_RESPUESTA_DE_LOS_SERVICIOS_DE_CÓDIGO_DE_ESTADO)
                );
    }
}
