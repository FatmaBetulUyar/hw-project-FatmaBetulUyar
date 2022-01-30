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
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private enum TransferType{
        BETWEENACCOUNTS,
        TOSOMEONE
    }

    private Float Amount;
    private Date transferDate;
    private String transferDescription;

}
