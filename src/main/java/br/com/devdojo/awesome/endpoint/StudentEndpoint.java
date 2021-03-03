package br.com.devdojo.awesome.endpoint;

import br.com.devdojo.awesome.models.Student;
import br.com.devdojo.awesome.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

//Anotação do Spring MVC e a diferença do controller, e que o RestController adiciona o @ResponseBody
//Endpoint: o ponto final onde os usuários acessará a API
//@RequestMapping, anotação que permite acessar a URL
// @Autowired faz parte do framework de injecão de dependências do Spring e instância objetos


@RestController
@RequestMapping("student")
public class StudentEndpoint {

    @Autowired
    private DateUtil dateUtil;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Student> listAll() {
        System.out.println("-----------" + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return asList(new Student("Deku"), new Student("Todoroki"));
    }
}
