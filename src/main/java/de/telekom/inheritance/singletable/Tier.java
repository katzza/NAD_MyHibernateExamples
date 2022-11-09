package de.telekom.inheritance.singletable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="animal_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class Tier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int age;
    private String name;

    public Tier(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Tier() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
