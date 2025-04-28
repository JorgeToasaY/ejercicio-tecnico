📁 Archivos principales

src/test/
├── java/
│   └── com/mibanco/accountmovement/karate
│       └── MovementTestRunner.java    # Runner JUnit5 para las pruebas Karate
├── resources/
│   └── movements/
│       └── movement.feature           # Escenarios de prueba para el API de movimientos
✅ ¿Qué se prueba?
Registro de movimientos (retiros, depósitos).

Validación de saldos insuficientes.

Actualización de saldo en cuenta después de cada transacción.

Manejo de errores como “Saldo no disponible”.

▶️ Ejecutar las pruebas
Asegúrate de que el microservicio account-movement esté corriendo en:

http://localhost:8085/api/movimientos
Desde la raíz del proyecto, ejecuta:

mvn test -Dtest=MovementTestRunner
Visualiza el reporte generado en:

target/karate-reports/karate-summary.html
Abre ese archivo con tu navegador para ver los resultados detallados.

💡 Requisitos
Java 17+

Maven 3.8+

Microservicio account-movement activo

Base de datos PostgreSQL con datos de prueba