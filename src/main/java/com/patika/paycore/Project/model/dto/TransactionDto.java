package com.patika.paycore.Project.model.dto;

import com.patika.paycore.Project.model.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    @NotNull(message = "User id can not be null !")
    private Integer user_id;

    @NotNull(message = "Amount can not be null !")
    private Float amount;

    @NotNull(message = "Transaction type can not be null !")
    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;
}
