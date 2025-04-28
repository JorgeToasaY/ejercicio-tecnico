Feature: Pruebas de Movement API

  Background:
    * url 'http://localhost:8085/api/movimientos'
    * header Content-Type = 'application/json'

  Scenario: Registrar un retiro
    Given request { accountNumber: '12345001', movementType: 'RETIRO', amount: 100 }
    When method POST
    Then status 201
    And match response.movementType == 'RETIRO'

  Scenario: Registrar un depósito
    Given request { accountNumber: '12345001', movementType: 'DEPOSITO', amount: 500 }
    When method POST
    Then status 201
    And match response.amount == 500
