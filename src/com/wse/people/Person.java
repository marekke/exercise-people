package com.wse.people;

public class Person {
    private final long pesel;
    private String name;
    private String lastName;
    private String city;

    public Person(long pesel, String name, String lastName, String city) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person: [" + pesel + " | " + name + " | " + lastName + " | " + city + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return pesel == person.pesel;
    }

    @Override
    public int hashCode() {
        return (int) (pesel ^ (pesel >>> 32));
    }

    public long getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }
}
