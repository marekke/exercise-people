package com.wse.people;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PeopleDatabase {
    private final Map<Long, Person> db;

    public PeopleDatabase() {
        this.db = new TreeMap<>();
        this.populateWithInitData();
    }

    public List<Person> getAll() {
        return new ArrayList<>(this.db.values());
    }


    public boolean addNewPerson(Person person) {
        if (this.existsByPesel(person.getPesel())) {
            return false;
        }

        this.db.put(person.getPesel(), person);
        return true;
    }

    public boolean removePersonByPesel(long pesel) {
        if (!this.existsByPesel(pesel)) {
            return false;
        }

        this.db.remove(pesel);
        return true;
    }

    public boolean existsByPesel(long pesel) {
        return this.db.containsKey(pesel);
    }

    private void populateWithInitData() {
        this.db.put(22222222L, new Person(22222222, "Jan", "Kowalski", "Bielsk"));
        this.db.put(33333333L, new Person(33333333, "Grażyna", "Cwana", "Radkowice"));
        this.db.put(11111111L, new Person(11111111, "Edward", "Sztacheta", "Łomża"));
    }
}
