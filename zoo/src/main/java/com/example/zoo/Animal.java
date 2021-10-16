package com.example.zoo;

public class Animal {
    private int id;
    private String specimen;
    private Diet diet;
    private Type type;
    private boolean hunger;
    private Health health;

    public Animal(int id, String specimen, Diet diet, Type type, boolean hunger, Health health) {
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

    public String getSpecimen() {
        return specimen;
    }

    public Diet getDiet() {
        return diet;
    }

    public Type getType() {
        return type;
    }

    public boolean getHunger() {
        return hunger;
    }

    public Health getHealth() {
        return health;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public String toString() {
        return "Animal {id="+id+", specimen="+specimen+", diet="+diet+", type="+type+", hunger="+hunger+", health="+health+"}";
    }


}
