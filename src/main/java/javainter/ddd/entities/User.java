package javainter.ddd.entities;

import javainter.ddd.valueobjects.Corpulance;

import java.time.LocalDate;
import java.util.Objects;

/*
Entity: possède une identité - un cycle de vie (état interne qui évolue)
Value Object: est une sorte d'objet non modifiable
 */
public class User {
    private int id;
    private String name;
    private int age;
    private Corpulance corpulance;



    public User() {
    }

    //2 entity sont égales si elles possèdent le mm id

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Corpulance getCorpulance() {
        return corpulance;
    }

}
