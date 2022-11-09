package de.telekom.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
