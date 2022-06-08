package com.tsi.yash.program.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="language")
public class Language {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer language_id;
    private String name;

    @LastModifiedDate
    private LocalDateTime lastUpdate;

    //Constructor
    public Language(){

    }

    public Language(String name){
        this.name = name;
        this.lastUpdate = LocalDateTime.now();
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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Language{" +
                "language_id=" + language_id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
