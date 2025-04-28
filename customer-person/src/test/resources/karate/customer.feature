Feature: Pruebas de Customer API

  Background:
    * url 'http://localhost:8080/api/clientes'
    * header Content-Type = 'application/json'

  Scenario: Crear un nuevo cliente
    Given request { customerId: 'CUST000012', name: 'Jose Lema', gender: 'Masculino', age: 30, identification: '1234567005', address: 'Otavalo sn y principal', phone: '098254785', password: '1234', state: true }
    When method POST
    Then status 200
    And match response.name == 'Jose Lema'

  Scenario: Obtener un cliente por customerId
    Given url 'http://localhost:8080/api/clientes/CUST000012'
    When method GET
    Then status 200
    And match response.customerId == 'CUST000012'
