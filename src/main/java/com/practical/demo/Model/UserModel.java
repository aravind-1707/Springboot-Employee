package com.practical.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String firstName;
    private String LastName;
    private String email;

    private String password;
    private String matchingPassword;
}
