package br.com.devdojo.awesome.endpoint;

import br.com.devdojo.awesome.error.CustomErrorType;
import br.com.devdojo.awesome.models.Student;
import br.com.devdojo.awesome.repository.StudentRepository;
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

    private final StudentRepository studentRepository;

    @Autowired
    public StudentEndpoint(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<?> listAll() {
        //System.out.println("-----------" + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/{id}")
    //@PathVariable("id") int id, pega atributos por separado
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        Student student = studentRepository.findById(id).get();
        if(student == null)
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }

    //Método que busca pelo nome
    //Tem que ser colocado o path pra ser executado com sucesso no Postman
    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable String name){
        return new ResponseEntity<>(studentRepository.findByNameIgnoreCaseContaining(name), HttpStatus.OK);

    }

        //Método pra enviar id e nome de um novo estudante
        //Dentro do @RequestBody tem que vir o objeto estudante
        //@RequestMapping(method = RequestMethod.POST)
         @PostMapping
         public ResponseEntity<?> save(@RequestBody Student student){
          return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
        }
     //Método pra eliminar um dado
    //@RequestMapping(method = RequestMethod.DELETE)
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
       studentRepository.deleteById(id);
        System.out.println("Dado deletado com sucesso");
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //Método pra atualizar um dado
    //@RequestMapping(method = RequestMethod.PUT)
    //Quando você pasa o long id, ao rodar o código ele sabe que deve salvar o objeto
    //Do contrário, sem o id, ele saba que deve atualizar um objeto
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student){
        studentRepository.save(student);
        System.out.println("Dado atualizado com sucesso");
        return new ResponseEntity<>(HttpStatus.OK);

    }

    }


