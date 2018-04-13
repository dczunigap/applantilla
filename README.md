# jwt-example


### SpringBoot + JPA + Rest API + Jwt + jQuery + Bootstrap 4

El proyecto esta diseñado para bloquear el acceso y pedir token de autenticación.
En esta rama, la autenticacion y consulta a los REST, se hace mediante **Postman**.
- No tiene interfaz de usuario.
- Usuarios y contraseñas no figuran en una base de datos.

#### Requisitos previos
- Postgresql 
- Liquibase
- Maven
- Ant
- Postman o cualquier otro.

#### Configuracion inicial de postgresql

- Configurar la base de datos de postgres con los siguientes parametros

```
    database:   plantilla_db
    user:       user_plantilla
    pass:       pass_plantilla
```

- Ejecutar la tarea de ant para iniciar la base de datos

```    
    ant 01-dbInit
```    
    
#### Ejecución del proyecto
- Para ejecutar el proyecto, colocar la siguiente linea:
    
```    
    mvn spring-boot:run
```

##### Obtener el token de autenticación
- Configurar en postman:
    
```   
    POST localhost:9001/jwt-example/login
```   
    
- En la opcion _`Body`_, seleccionar _`raw`_ y colocar lo siguiente:

```
    {"username":"user","password":"pass"}
```

- En el reponse obtendremos el token, 

##### Ver el listado de Entidades, via REST
- Configurar en postman:

```
    GET http://localhost:9001/jwt-example/api/entidad
```
    
- En la opcion _`Headers`_ colocar lo siguiente:

```
    Authorization: Baerer <TokenObtenido>
```  
- Si no especificas el token, mandara un error `403 Access Denied`

##### Se agrega interfaz de usuario, se puede acceder mediante:
```
    http://localhost:9001/jwt-example
```

#### Generating password hash for new users

I'm using [bcrypt](https://en.wikipedia.org/wiki/Bcrypt) to encode passwords. Your can generate your hashes with this simple tool: [Bcrypt Generator](https://www.bcrypt-generator.com)


### Créditos

Proyecto GitHub <https://github.com/auth0-blog/spring-boot-jwts>

Documentacion <https://auth0.com/blog/securing-spring-boot-with-jwts>

Documentacion: <https://www.linkedin.com/pulse/json-web-token-jwt-spring-security-real-world-example-boris-trivic>

Documentacion: <https://github.com/auth0/blog/blob/master/_posts/2017-08-10-implementing-jwt-authentication-on-spring-boot.markdown>

Documentarcion: <http://www.ingens-networks.com/blog/2015/02/26/oauth-2-bearer-token-conceptos-basicos/>