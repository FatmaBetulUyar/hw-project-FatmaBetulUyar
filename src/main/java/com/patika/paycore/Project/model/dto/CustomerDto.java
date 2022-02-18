package com.patika.paycore.Project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String bankName;
}
