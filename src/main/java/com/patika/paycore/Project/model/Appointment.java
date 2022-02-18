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
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

 //   @NotNull(message = "Date can not be null !")
    @Column(name="appointment_date")
    private Date appointmentDate;

 //   @NotNull(message = "Description can not be null !")
   // @Column(name="description")
    private String description;

 //   @NotNull(message = "Location can not be null !")
    private String location;

   // @JsonManagedReference
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Customer userAppointment;
}
