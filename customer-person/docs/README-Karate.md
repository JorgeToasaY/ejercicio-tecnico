# Pruebas de Integración – `cliente-persona-service` con Karate DSL

Este módulo contiene las pruebas de integración del microservicio `customer-person` utilizando [Karate DSL](https://github.com/karatelabs/karate) y JUnit 5.

## 📁 Archivos principales

src/test/ ├── java/ │ └── com/mibanco/accountmovement/karate │ └── CustomerTestRunner.java # Runner JUnit5 para las pruebas Karate ├── resources/ │ └── customers/ │ └── customer.feature # Escenarios de prueba para el API de clientes

## ✅ ¿Qué se prueba?

- Creación de clientes (POST /clientes).
- Consulta de clientes (GET /clientes, /clientes/{id}).
- Actualización y eliminación de clientes.
- Validación de campos requeridos y respuesta ante errores.

## ▶️ Ejecutar las pruebas

1. Asegúrate de que el microservicio `customer-person` esté corriendo en:

http://localhost:8080/api/clientes

2. Desde la raíz del proyecto, ejecuta:

bash
mvn test -Dtest=CustomerTestRunner

Visualiza el reporte generado en:
target/karate-reports/karate-summary.html
target/karate-reports/karate-summary.html
Abre ese archivo con tu navegador para ver los resultados detallados.

💡 Requisitos
Java 17+

Maven 3.8+

Microservicio cliente-persona-service activo

Base de datos PostgreSQL con datos de prueba


