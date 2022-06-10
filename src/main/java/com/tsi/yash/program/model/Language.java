package com.tsi.yash.program.model;

import javax.persistence.*;

@Entity
@Table(name="language")
public class Language {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer language_id;
    private String name;

    //Constructor
    public Language(){

    }

    public Language(String name){
        this.name = name;
    }

    //Methods


    public Integer getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Integer language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Language{" +
                "language_id=" + language_id +
                ", name='" + name + '\'' +
                '}';
    }
}
