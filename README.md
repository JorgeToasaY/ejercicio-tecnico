
# 🏦 Microservicio Banca - Despliegue con Docker y Docker Compose

Este proyecto contiene dos microservicios desarrollados con **Java Spring Boot**:

- `customer-person`
- `account-movement`

Además, se utiliza **PostgreSQL** como base de datos y **RabbitMQ** como broker de mensajería para comunicación asincrónica entre servicios.

---

## 📦 Requisitos Previos

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## 🧱 Estructura del Proyecto

```
ejercicio-tecnico/
│
├── customer-person/
│   ├── Dockerfile
│   ├── target/customer-person-0.0.1-SNAPSHOT.jar
│   └── ...
│
├── account-movement/
│   ├── Dockerfile
│   ├── target/account-movement-0.0.1-SNAPSHOT.jar
│   └── ...
│
├── BaseDatos.sql
├── docker-compose.yml
├── docker-compose.sh
├── Plan De Pruebas.docx
├── Microservicios_MiBanco_Postman_Collection.json
└── README.md
```

---

## 🚀 Pasos para Desplegar

### 1. Compilar los microservicios y levantar contenedores

## Ejecutar el archivo docker-compose.sh
### Paso 1. Abrir PowerShell como administrador 
### Paso 2. Dirigirse al directorio raiz del proyecto \ejercicio-tecnico
### Paso 3. Copiar la intrucción: & "C:\Program Files\Git\bin\bash.exe" -c "./docker-compose.sh"
### Paso 4. Presionar la tecla Enter
```bash
cd customer-person
mvn clean package -DskipTests
# Verificar si la compilación fue exitosa
if [ $? -ne 0 ]; then
  echo "Error en la compilación. Abortando..."
  exit 1
fi
cd ../account-movement
mvn clean package -DskipTests
# Verificar si la compilación fue exitosa
if [ $? -ne 0 ]; then
  echo "Error en la compilación. Abortando..."
  exit 1
fi
cd ..

docker-compose build
docker-compose up
```

---

## 🌐 Endpoints Disponibles

| Servicio         | URL                                   | Puerto        |
|------------------|---------------------------------------|---------------|
| Customer/Person  | http://localhost:8080/api/clientes    | 8080          |
| Account/Movement | http://localhost:8085/api/cuentas     | 8085          |
| Account/Movement | http://localhost:8085/api/movimientos | 8085          |
| RabbitMQ UI      | http://localhost:15672                | guest / guest |

---

## 🐘 PostgreSQL

- **Host:** `localhost`
- **Puerto:** `5432`
- **Usuario:** `postgres`
- **Contraseña:** `admin`
- **Base de datos:** `banco`
- Script inicial cargado: `BaseDatos.sql`

---

## 🔁 Comunicación Asíncrona

Este sistema implementa comunicación asíncrona con RabbitMQ:

- El microservicio `customer-person` publica eventos al crear un `Customer`.
- El microservicio `account-movement` los consume mediante listeners.
