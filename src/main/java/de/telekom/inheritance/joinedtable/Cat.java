package de.telekom.inheritance.joinedtable;

import javax.persistence.*;

@Entity
@Table(name = "cat")
@PrimaryKeyJoinColumn(name = "petId")
public class Cat extends Tier {
    @Column
    private String color;

    public Cat (){}
    public Cat(int age, String name, String color) {
        super(age, name);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
