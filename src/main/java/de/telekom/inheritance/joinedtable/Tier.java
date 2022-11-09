package de.telekom.inheritance.joinedtable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@org.hibernate.annotations.NamedQuery(name = "findByAge",
        query = "from Tier where age = :age")
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
