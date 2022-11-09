package de.telekom.inheritance.singletable;

import javax.persistence.*;

@Entity
@Table(name = "cat")
@DiscriminatorValue("1")
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
