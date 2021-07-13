### Skeleton JAVA

Esse é o projeto padrão para aplicações que utilizarão backend em JAVA. Ele já vem configurado com alguns recursos do springboot, dentre eles:

1. spring-boot-starter-actuator
2. spring-boot-starter-web
3. spring-boot-starter
4. spring-boot-starter-data-jpa
5. spring-boot-devtools
6. spring-boot-starter-test
7. spring-boot-maven-plugin
8. springfox-swagger2
9. springfox-swagger-ui

Configuramos outros pacotes para auxílio no desenvolvimento:

1. com.h2database
2. org.projectlombok
3. junit

Para iniciar, configure o local da sua base de dados h2. 
Edite o arquivo src\main\resources\application.properties e modifique a propriedade spring.datasource.url

Configuramos os arquivos Docker para levantar o projeto. 
Para isso utilize os comandos abaixo, na raiz do projeto:
```
// exlcuir a imagem java caso já possua para compilar novamente
$ docker rmi -f java 

// compilar a imagem com parametros atuais
$ docker build --rm --network host -t java .

// levantar aplicação
$ docker-compose down && docker-compose up -d

// visualizar logs
# docker logs -f skeleton-java
```
