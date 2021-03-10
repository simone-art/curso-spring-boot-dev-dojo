package br.com.devdojo.awesome.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Student {
    private int id;

    private String name;

    //Criada lista static pra evitar instanciar objeto toda vez que se tem um dado novo
    //Então é melhor trabalhar com uma lista dinámica
    public static List<Student> studentList;

    //Bloco estático para chamar studentRepository
    static {
        studentRepository();
    }

    public Student(int id, String name) {
        this(name);
        this.id = id;

    }

    public Student(String name){
        this.name = name;
    }

    public Student() {
    }


    private static void studentRepository(){
        studentList = new ArrayList<>(asList(new Student(1, "Deku"), new Student(2, "Todoroki")));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
