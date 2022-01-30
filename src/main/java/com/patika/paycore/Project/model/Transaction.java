package com.patika.paycore.Project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private enum transactionType{
        WITHDRAW,
        DEPOSIT
    }

    private Float amount;

    private Date transactionDate;

    private String transactionDescription;


}
