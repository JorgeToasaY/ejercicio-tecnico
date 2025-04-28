
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
project-root/
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
└── README.md
```

---

## 🚀 Pasos para Desplegar

### 1. Compilar los microservicios y levantar contenedores


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
