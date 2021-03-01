package br.com.devdojo.awesome.start;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * Clase responsável por startar a aplicação Spring Boot
 */

//Anotação wue diz para o Spring que ele tem que configurar as dependências que tem no pom
@EnableAutoConfiguration
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }

}

