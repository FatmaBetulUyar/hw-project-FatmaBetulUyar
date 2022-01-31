package com.patika.paycore.Project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="recipients")
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "First Name can not be null !")
    private String firstName;

    @NotNull(message = "Last Name can not be null !")
    private String lastName;

    @Email
    private String email;

    @NotNull(message = "Phone can not be null !")
    private String phone;

    @NotNull(message = "Account number can not be null !")
    private String accountNumber;

    @JsonBackReference
    @OneToMany(mappedBy = "recipient", cascade = CascadeType.MERGE)
    private List<Transfer> transfers;

}
