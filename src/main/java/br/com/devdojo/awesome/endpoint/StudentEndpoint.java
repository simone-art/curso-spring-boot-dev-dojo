package br.com.devdojo.awesome.endpoint;

import br.com.devdojo.awesome.models.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Anotação do Spring MVC e a diferença do controller, e que o Controller adiciona o @ResponseBody
//Endpoint: o ponto final onde os usuários acessará a API
//@RequestMapping, anotação que permite acessar a URL


@RestController
@RequestMapping("students")
public class StudentEndpoint {

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public String listAll(){
        Student student = new Student();
        student.setName("Deku");
        Student student1 = new Student();
        student1.setName("Todoroku");
       return "/list";
    }


}
