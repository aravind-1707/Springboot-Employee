package com.practical.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer stuid;
    @NotBlank(message =  "Please Enter the Student name")
    private String stuname;

    private int phonenumber;


    public Student() {
    }


}
