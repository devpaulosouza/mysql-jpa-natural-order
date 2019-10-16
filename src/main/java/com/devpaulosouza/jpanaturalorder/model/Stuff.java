package com.devpaulosouza.jpanaturalorder.model;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Stuff implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   @SortNatural
   private String name;


   public Long getId() {
       return this.id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public String getName() {
       return this.name;
   }


   public void setName(String name) {
    this.name = name;
    }

}