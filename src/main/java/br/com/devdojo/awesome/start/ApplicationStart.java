package br.com.devdojo.awesome.start;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 * Clase responsável por startar a aplicação Spring Boot
 */

//Anotação que diz para o Spring que ele tem que configurar as dependências que tem no pom
@EnableAutoConfiguration
//Anotação que define o pacote onde está seu endpoint
@ComponentScan(basePackages = "br.com.devdojo.awesome.endpoint")

//@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }

}

