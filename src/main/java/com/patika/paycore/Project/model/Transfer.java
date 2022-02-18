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

 //   @NotNull(message = "Transfer type can not be null !")
    @Enumerated(EnumType.ORDINAL)
    private TransferType transferType;

//    @NotNull(message = "Amount type can not be null !")
//@Column(name="amount")
    private Float Amount;

 //   @NotNull(message = "Transfer date can not be null !")
    @Column(name="transfer_date")
    private Date transferDate;

 //   @NotNull(message = "Transfer description can not be null !")
    @Column(name="transfer_description")
    private String transferDescription;

    @Column(name = "is_success")
    private Boolean isSuccess;

 //   @NotNull(message = "User can not be null !")

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Customer userTransfer;

  //  @NotNull(message = "Recipient can not be null !")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private Recipient recipient;

}
