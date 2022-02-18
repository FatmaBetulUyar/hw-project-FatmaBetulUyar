package com.patika.paycore.Project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="recipient")
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  //  @NotNull(message = "First Name can not be null !")
    @Column(name="firstname")
    private String firstName;

//    @NotNull(message = "Last Name can not be null !")
    @Column(name="lastname")
    private String lastName;

    @Email
    @Column(name="email")
    private String email;

 //   @NotNull(message = "Phone can not be null !")
 //@Column(name="phone")
    private String phone;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "recipient", cascade = CascadeType.MERGE)
    private List<Transfer> transfers;

}
