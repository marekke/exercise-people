package com.wse.people.actions;

import com.wse.people.PeopleDatabase;
import com.wse.people.Person;

import java.util.Scanner;

public class AddAction extends Action{
    public AddAction(PeopleDatabase database, Scanner scanner) {
        super(database, scanner);
    }

    @Override
    public int getCode() {
        return 3;
    }

    @Override
    public String getDescription() {
        return "Add";
    }

    @Override
    public void run() {
        System.out.println("Giva a pesel: ");
        long pesel = this.scanner.nextLong();
        this.scanner.nextLine();

        System.out.println("Giva a name: ");
        String name = this.scanner.nextLine();

        System.out.println("Giva a last name: ");
        String lastName = this.scanner.nextLine();

        System.out.println("Giva a city: ");
        String city = this.scanner.nextLine();

        Person person = new Person(pesel, name, lastName, city);

        if (this.database.addNewPerson(person)) {
            System.out.println("Successfully added new person.");
        } else {
            System.out.println("Given person already exists in system.");
        }
    }
}
