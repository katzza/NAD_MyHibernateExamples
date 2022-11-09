package de.telekom.inheritance.joinedtable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mouse")
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
