package me.minomi.wildcard;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 03/11/2018.
 */
public class Person {
    protected String name;

    Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "님";
    }
}
