package com.patika.paycore.Project.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Transaction type can not be null !")
    private enum transactionType{
        WITHDRAW,
        DEPOSIT
    }

    @NotNull(message = "Amount can not be null !")
    private Float amount;

    @NotNull(message = "Transaction date can not be null !")
    private Date transactionDate;

    @NotNull(message = "Transaction description can not be null !")
    private String transactionDescription;

    @NotNull(message = "User can not be null !")
    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userTransaction;

}
