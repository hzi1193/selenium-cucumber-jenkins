package bdd.step;

import bdd.page.BuscarProductoPage;

public class BuscarProductoStep {

    public BuscarProductoPage buscarProductoPage() {
        return new BuscarProductoPage();
    }

    public void stepIniciarNavegador(String url) {
        buscarProductoPage().iniciarNavegador(url);
    }

    public void stepHacerClickenBuscar() {
        buscarProductoPage().hacerClickenBuscar();
    }

    public void stepEscrbirProducto(String txtProducto) {
        buscarProductoPage().escrbirProducto(txtProducto);
    }

    public void stepClicBuscarProducto() {
        buscarProductoPage().clicBuscarProducto();
    }

    public String stepValidarResultado() {
        return buscarProductoPage().validarResultado();
    }
}
