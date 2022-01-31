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
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "First Name can not be null !")
    private String firstName;

    @NotNull(message = "Last Name can not be null !")
    private String lastName;

    @NotNull(message = "Email can not be null !")
    @Email
    private String email;

    @NotNull(message = "Password can not be null !")
    private String password;

    @NotNull(message = "Phone can not be null !")
    private String phone;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Transaction> transactions;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Transfer> transfers;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Appointment> appointments;
}
