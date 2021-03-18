# Demo-camel
Poc uso do Apache Camel

## Subir a aplicação
Para inicializar a aplicação executar no terminal:

  `./mvnw spring-boot:run `

## Endpoints
As seguintes rotas foram criadas:

* route1: servlet:/api/bean?httpMethodRestrict=POST
* route2: servlet:/say/hello?httpMethodRestrict=GET
* route3: direct://hello

Ex: http://localhost:8060/camel/say/hello
