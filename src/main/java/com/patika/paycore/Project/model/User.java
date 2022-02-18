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
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  //  @NotNull(message = "First Name can not be null !")
    @Column(name = "firstname")
    private String firstName;

//    @NotNull(message = "Last Name can not be null !")
    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String userName;

  //  @NotNull(message = "Email can not be null !")
    @Email
    //@Column(name="email")
    private String email;

   // @NotNull(message = "Password can not be null !")
  // @Column(name="password")
    private String password;

  //  @NotNull(message = "Phone can not be null !")
 // @Column(name="phone")
    private String phone;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "userTransaction", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @JsonIgnore
    @OneToMany(mappedBy = "userTransfer", cascade = CascadeType.ALL)
    private List<Transfer> transfers;

    @JsonIgnore
    @OneToMany(mappedBy = "userAppointment", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;
}
