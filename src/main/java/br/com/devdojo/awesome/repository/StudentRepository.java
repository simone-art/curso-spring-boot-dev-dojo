package br.com.devdojo.awesome.repository;

import br.com.devdojo.awesome.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//<Student, Long> Student : Entity e o ID
//CrudRepository é uma interfase

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    List<Student> findByNameIgnoreCaseContaining(String name);
    //Student findById(Long id);


}
