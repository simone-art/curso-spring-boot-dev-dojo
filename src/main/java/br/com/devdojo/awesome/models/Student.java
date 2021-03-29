package br.com.devdojo.awesome.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

@Entity
public class Student extends AbstractEntity {

   @Column
   @NotNull
   @NotBlank(message = "O nome não pode ser vazio")
    private String name;

   @NotBlank(message = "O email não pode ser vazio")
   @Email
   private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
