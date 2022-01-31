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
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Transfer type can not be null !")
    private enum transferType{
        BETWEENACCOUNTS,
        TOSOMEONE
    }
    @NotNull(message = "Amount type can not be null !")
    private Float Amount;

    @NotNull(message = "Transfer date can not be null !")
    private Date transferDate;

    @NotNull(message = "Transfer description can not be null !")
    private String transferDescription;

    @NotNull(message = "User can not be null !")
    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotNull(message = "Recipient can not be null !")
    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private Recipient recipient;

}
