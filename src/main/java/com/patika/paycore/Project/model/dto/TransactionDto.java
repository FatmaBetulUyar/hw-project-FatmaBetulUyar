package com.patika.paycore.Project.model.dto;

import com.patika.paycore.Project.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Integer user_id;

    private Float amount;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;
}
