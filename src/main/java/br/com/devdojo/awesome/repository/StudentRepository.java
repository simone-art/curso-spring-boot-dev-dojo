package br.com.devdojo.awesome.repository;

import br.com.devdojo.awesome.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//<Student, Long> Student : Entity e o ID
//CrudRepository é uma interfase

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
    //Student findById(Long id);


}
