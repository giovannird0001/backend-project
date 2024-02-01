package com.sthore.msOperador.models;



import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.Entity;

import jakarta.persistence.Table;


@Entity
@Table(name = "Categorias")
public class Categorias {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 50)
    private String name;

  

    @Column(length = Integer.MAX_VALUE)
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return name;
    }

    public void setImageUrl(String name) {
        this.name = name;
    }
    /* Id: int primary key
Name: varchar(50)
Image: varchar(max)
creationAt: Datetime por default
updatedAt: Datetime
 */
}
