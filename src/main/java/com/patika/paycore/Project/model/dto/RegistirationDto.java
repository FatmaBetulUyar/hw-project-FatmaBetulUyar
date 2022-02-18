package com.patika.paycore.Project.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class RegistirationDto {

    private String username;

    @Email(message = "Email not valid")
    private String email;

    private String password;




}
