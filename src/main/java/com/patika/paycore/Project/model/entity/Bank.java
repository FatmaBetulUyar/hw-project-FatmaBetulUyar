package com.patika.paycore.Project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bank")
public class Bank {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  //  @NotNull(message = "Name can not be null !")
   private String name;
}
