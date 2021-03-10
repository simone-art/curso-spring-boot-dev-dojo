package br.com.devdojo.awesome.endpoint;

import br.com.devdojo.awesome.error.CustomErrorType;
import br.com.devdojo.awesome.models.Student;
import br.com.devdojo.awesome.util.DateUtil;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

//Anotação do Spring MVC e a diferença do controller, e que o RestController adiciona o @ResponseBody
//Endpoint: o ponto final onde os usuários acessará a API
//@RequestMapping, anotação que permite acessar a URL
// @Autowired faz parte do framework de injecão de dependências do Spring e instância objetos


@RestController
@RequestMapping("students")
public class StudentEndpoint {

    @Autowired
    private DateUtil dateUtil;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        //System.out.println("-----------" + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    //@PathVariable("id") int id, pega atributos por separado
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id){
        Student student = new Student();
        student.setId(id);
        int index = Student.studentList.indexOf(student);
        if(index == -1)
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
        }

        //Método pra enviar id e nome de um novo estudante
        //Dentro do @RequestBody tem que vir o objeto estudante
        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<?> save(@RequestBody Student student){
          Student.studentList.add(student);
          return new ResponseEntity<>(student, HttpStatus.OK);
        }
     //Método pra eliminar um dado
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Student student){
        Student.studentList.remove(student);
        System.out.println("Dado deletado com sucesso");
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //Método pra atualizar um dado
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Student student){
        Student.studentList.remove(student);
        Student.studentList.add(student);
        System.out.println("Dado atualizado com sucesso");
        return new ResponseEntity<>(HttpStatus.OK);

    }

    }


