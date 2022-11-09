package de.telekom.inheritance.mappedsuperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cat")
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
