package br.com.devdojo.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/***
 * Clase responsável por startar a aplicação Spring Boot
 */

//Anotação que diz para o Spring que ele tem que configurar as dependências que tem no pom
@EnableAutoConfiguration
//Anotação que define o pacote onde está seu endpoint
//@ComponentScan(basePackages = "br.com.devdojo.awesome.endpoint") //Não precisa mas desta anotação porque
//


@ComponentScan
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }

}

