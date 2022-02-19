package com.patika.paycore.Project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @NotNull(message = "First Name can not be null !")
    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String bankName;
}
