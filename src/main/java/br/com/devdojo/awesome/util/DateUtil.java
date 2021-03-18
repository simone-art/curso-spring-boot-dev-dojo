package br.com.devdojo.awesome.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Tem que ser colocado o bean @Component porque gera um erro na hora de buildar
//@Component, diz para a classe que vai ser escaneada pelo @ComponentScan
@Component
public class DateUtil {

    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
