package bdd.page;

import bdd.webdriver.DOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuscarProductoPage extends DOM {
    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    protected WebElement txtBuscar;

    @FindBy(id = "nav-search-submit-button")
    protected WebElement btnBuscar;

    @FindBy(xpath = "//*[contains(text(),'Resultados')]")
    protected WebElement resultadoObtenido;


    public void iniciarNavegador(String url) {
        inciarNavegador(url);
    }

    public void hacerClickenBuscar() {
        onclick(txtBuscar);
    }

    public void escrbirProducto(String txtProducto) {
        type(txtBuscar, txtProducto);
    }

    public void clicBuscarProducto() {
        onclick(btnBuscar);
    }

    public String validarResultado() {
        return getText(resultadoObtenido);
    }

}
