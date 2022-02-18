package com.patika.paycore.Project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
    //gönderecek kişi
    private Integer user_id;

    private Float amount;
    //alıcak kişi
    private Integer recipient_id;

    private String description;


}
