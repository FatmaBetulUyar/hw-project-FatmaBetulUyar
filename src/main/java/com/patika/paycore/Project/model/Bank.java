package com.patika.paycore.Project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bank")
public class Bank {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   private String name;
}
