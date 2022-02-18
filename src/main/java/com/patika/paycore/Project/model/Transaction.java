package com.patika.paycore.Project.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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

 //   @NotNull(message = "Transaction type can not be null !")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
  //  @NotNull(message = "Amount can not be null !")

 // @Column(name="amount")
    private Float amount;

  //  @NotNull(message = "Transaction date can not be null !")
    @Column(name="transaction_date")
    private Date transactionDate;

 //   @NotNull(message = "Transaction description can not be null !")
    @Column(name="transaction_description")
    private String transactionDescription;

    @Column(name = "is_success")
  private Boolean isSuccess;

 //   @NotNull(message = "User can not be null !")
    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Customer userTransaction;

}
