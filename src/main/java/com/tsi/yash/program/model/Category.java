package com.tsi.yash.program.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="category")
public class Category {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer category_id;
    private String name;


    // Constructor
    public Category(){

    }

    public Category(Integer category_id, String name){
        this.category_id = category_id;
        this.name=name;
    }

    // Methods


    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
