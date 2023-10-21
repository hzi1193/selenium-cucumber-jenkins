
Feature: Buscar Producto

  @PRUEBA1
  Scenario: Buscar Producto de Libros para Selenium
    Given ingreso a la pagina web de amazon "https://www.amazon.com/-/es/"
    When ingreso en texto "Libros de Selenium"
    And le doy click al boton buscar
    Then valido que me muestre el valor "Resultados"


