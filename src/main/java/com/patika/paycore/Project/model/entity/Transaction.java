package com.patika.paycore.Project.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Float amount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="transaction_date")
    private Date transactionDate;

    @Column(name="transaction_description")
    private String transactionDescription;

    @Column(name = "is_success")
  private Boolean isSuccess;

 //   @NotNull(message = "User can not be null !")

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
