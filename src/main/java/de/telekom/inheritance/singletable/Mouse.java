package de.telekom.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mouse")
@DiscriminatorValue("2")
public class Mouse extends Tier {

    @Column
    private String mouseBreed;

    public Mouse(int age, String name, String mouseBreed) {
        super(age, name);
        this.mouseBreed = mouseBreed;
    }

    public Mouse(){}

    public String getMouseBreed() {
        return mouseBreed;
    }

    public void setMouseBreed(String mouseBreed) {
        this.mouseBreed = mouseBreed;
    }
}
