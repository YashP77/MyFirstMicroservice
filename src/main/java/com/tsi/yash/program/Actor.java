package com.tsi.yash.program;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name="actor")
public class Actor {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    private String first_name;
    private String last_name;

    //Constructors
    public Actor(){
        toString();
    }

    public Actor(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }


    //Methods

    public int getActor_id() {
        return actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actor_id=" + getActor_id() +
                ", first_name='" + getFirst_name() + '\'' +
                ", last_name='" + getLast_name() + '\'' +
                '}';
    }
}
