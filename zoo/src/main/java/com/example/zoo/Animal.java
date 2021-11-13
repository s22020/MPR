package com.example.zoo;

import javax.persistence.*;

@Entity
@Table
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String specimen;
    @Column
    private Diet diet;
    @Column
    private Type type;
    @Column
    private boolean hunger;
    @Column
    private Health health;

    public Animal() {

    }

    public Animal(Integer id, String specimen, Diet diet, Type type, boolean hunger, Health health) {
        this.id = id;
        this.specimen = specimen;
        this.diet = diet;
        this.type = type;
        this.hunger = hunger;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isHunger() {
        return hunger;
    }

    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }


    public String toString() {
        return "Animal {id="+id+", specimen="+specimen+", diet="+diet+", type="+type+", hunger="+hunger+", health="+health+"}";
    }


}
