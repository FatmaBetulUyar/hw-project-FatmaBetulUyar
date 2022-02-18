package com.patika.paycore.Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  //  @NotNull(message = "Account number can not be null !")
    @Column(name = "account_number")
    private String accountNumber;

  //  @NotNull(message = "Balance can not be null !")
 // @Column(name = "balance")
    private Float balance;
//
//    @JsonIgnore
//    @OneToOne(mappedBy = "account")
//    private Recipient recipient;

    @JsonIgnore
    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private Customer customer;

  //  @NotNull(message = "Bank can not be null !")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id",referencedColumnName = "id")
    private Bank bank;





}
