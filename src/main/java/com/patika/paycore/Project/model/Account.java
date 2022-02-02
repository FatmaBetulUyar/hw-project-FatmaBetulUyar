package com.patika.paycore.Project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Account number can not be null !")
    private String accountNumber;

    @NotNull(message = "Balance can not be null !")
    private Float balance;

    /*@OneToOne(mappedBy = "account")
    private User user;*/

    @NotNull(message = "Bank can not be null !")
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bank_id",referencedColumnName = "id")
    private Bank bank;





}
