package bdd.stepdefinition;

import bdd.step.BuscarProductoStep;
import bdd.webdriver.DOM;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BuscarProductoStepDefinition {

    private final BuscarProductoStep buscarProductoStep = new BuscarProductoStep();
    private final DOM dom = new DOM();

    private Scenario scenario;


    @After
    public void afterScenario(Scenario scenario) {
        this.scenario = scenario;
        dom.takeScreenShot(scenario);
        dom.quitDriver();
    }

    @Given("ingreso a la pagina web de amazon {string}")
    public void ingreso_a_la_pagina_web_de_amazon(String url) {
        buscarProductoStep.stepIniciarNavegador(url);
    }

    @When("ingreso en texto {string}")
    public void ingreso_en_texto(String txtProducto) {
        buscarProductoStep.stepHacerClickenBuscar();
        buscarProductoStep.stepEscrbirProducto(txtProducto);
    }

    @And("le doy click al boton buscar")
    public void le_doy_click_al_boton_buscar() {
        buscarProductoStep.stepClicBuscarProducto();
    }

    @Then("valido que me muestre el valor {string}")
    public void valido_que_me_muestre_el_valor(String txtResultadoEsperado) {
        Assertions.assertEquals(txtResultadoEsperado, buscarProductoStep.stepValidarResultado());
    }
}
