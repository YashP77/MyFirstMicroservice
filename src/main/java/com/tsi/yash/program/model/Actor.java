package com.tsi.yash.program.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="actor")
public class Actor {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actor_id;
    @Basic private String first_name;
    @Basic private String last_name;

    @LastModifiedDate
    @Basic private LocalDateTime lastUpdate;

    //Constructors
    public Actor(){
    }

    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
        this.lastUpdate = LocalDateTime.now();
    }

    public Actor(Integer id, String first_name, String last_name){
        this.actor_id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.lastUpdate = LocalDateTime.now();
    }

    //Methods
    public Integer getActor_id() {
        return actor_id;
    }

    public void setActor_id(Integer actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actor_id=" + actor_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
