# Cash-OnlineAPI
Examen Cash Online

Herramientas necesarias:

- GIT     
- Maven   
- Java    (1.8)
- Eclipse (opcional)

Descargando el repositorio:

- git clone git@gitlab.tecso.coop:tecso-public/test-spring-boot-level-1.git

Para ejecutar la aplicacion utilizando Maven:

mvn clean install  (instalar dependencias)

mvn spring-boot:run (levantar aplicacion, revisar que el puerto 8080 no este siendo usado)

Proyecto:

Es una api rest desarrollada con spring boot. Tiene su base de datos embebida. Y al inicializar la aplicacion se crea un usuario con dos prestamos.

Dado un ID de usuario devuelve informacion del mismo. Ademas de una busqueda paginada de prestamos por id de usuario opcional.

Tambien tiene una busqueda paginada para los prestamos (recordar que comienza desde la pagina 0).



Cuenta con los servicios:

USUARIOS: 

POST (ALTA DE USUARIO)

http://localhost:8080/users


BODY EJEMPLO:

{
    "email": "jorge@test.com",
    "firstName": "jorge",
    "lastName": "prueba"
}

DELETE (BAJA DE USUARIO)

http://localhost:8080/users/1      (DONDE 1 ES EL ID DEL USUARIO A ELIMINAR SI EL USUARIO NO EXISTE LA APLICACION DEVOLVERA LA RAZON)

GET (OBTENER USUARIO POR ID) 

http://localhost:8080/users/1 (DONDE 1 ES EL ID DEL USUARIO A OBTENER SI EL USUARIO NO EXISTE LA APLICACION DEVOLVERA LA RAZON)

EJEMPLO RESPONSE:

{
    "id": 1,
    "email": "jorge@rolon.com",
    "firstName": "JORGE",
    "lastName": "ROLON",
    "loans": [
        {
            "id": 2,
            "total": 3400.15,
            "userId": 1
        },
        {
            "id": 3,
            "total": 7800,
            "userId": 1
        }
    ]
}

PRESTAMOS BUSQUEDA PAGINADA:

GET (BUSQUEDA PAGINADA DE PRESTAMOS SIN ID USUARIO)

http://localhost:8080/loans?page=0&size=5  (BUSQUEDA SIN ID USUARIO)


RESPONSE EJEMPLO:

{
    "paging": {
        "total": 2,
        "size": 1,
        "page": 0
    },
    "items": [
        {
            "id": 2,
            "total": 3400.15,
            "userId": 1
        },
        {
            "id": 3,
            "total": 7800,
            "userId": 1
        }
    ]
}

GET (BUSQUEDA PAGINADA DE PRESTAMOS CON ID USUARIO)

http://localhost:8080/loans?page=0&size=5&user_id=1

RESPONSE EJEMPLO:

{
    "paging": {
        "total": 2,
        "size": 1,
        "page": 0
    },
    "items": [
        {
            "id": 2,
            "total": 3400.15,
            "userId": 1
        },
        {
            "id": 3,
            "total": 7800,
            "userId": 1
        }
    ]
}


* INCLUYE TEST UNITARIOS AUNQUE ME FALTO AGREGAR TEST UNITARIOS DE LOS CONTROLLERS POR CUESTION DE TIEMPO NO PUDE LLEGAR.
