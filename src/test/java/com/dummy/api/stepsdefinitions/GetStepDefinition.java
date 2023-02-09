package com.dummy.api.stepsdefinitions;

import com.dummy.api.exceptions.AssertionsServices;
import com.dummy.api.questions.ValidarRetornoDatos;
import com.dummy.api.questions.ValidarSchema;
import com.dummy.api.taks.ConsumeGet;
import com.dummy.api.taks.ConsumoGetId;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.dummy.api.questions.ValidarRespuestaEstado;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetStepDefinition {

    @When("Se llama la API Get empleados")
    public void seLlamaLaAPIGetEmpleados() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service()
        );
    }

    @When("Se llama la API GetId empleados {string}")
    public void seLlamaLaAPIGetIdEmpleados(String id) {
        theActorInTheSpotlight().attemptsTo(
                ConsumoGetId.service(Integer.parseInt(id))
        );
    }

    @Then("Debería ver el código de estado {int}")
    public void deberíaVerElCódigoDeEstado(int codigo) {
        theActorInTheSpotlight()
                .should(seeThat(ValidarRespuestaEstado.expected(codigo))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.NO_SE_ESPERA_LA_RESPUESTA_DE_LOS_SERVICIOS_DE_CÓDIGO_DE_ESTADO)
                );
    }

    @Then("Valido el esquema de la respuesta {string}")
    public void validoElEsquemaDeLaRespuesta(String GetJsonSchema) {
        theActorInTheSpotlight()
                .should(seeThat(
                        ValidarSchema.expected(GetJsonSchema))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.EL_ESQUEMA_DE_LA_RESPUESTA_NO_ES_EL_CORRECTO)
                );
    }

    @Then("Valido que la busqueda sea correcta {string}")
    public void validoQueLaBusquedaSeaCorrecta(String nombre) {
        theActorInTheSpotlight()
                .should(seeThat(
                        ValidarRetornoDatos.expected(nombre))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.LOS_DATOS_DE_LA_RESPUESTA_NO_SON_LOS_CORRECTOS)
                );
    }

}
