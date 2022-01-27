package com.wse.people.actions;

import com.wse.people.PeopleDatabase;
import com.wse.people.Person;

import java.util.Comparator;
import java.util.Scanner;

public class SortAction extends Action{
    public SortAction(PeopleDatabase database, Scanner scanner) {
        super(database, scanner);
    }

    @Override
    public int getCode() {
        return 2;
    }

    @Override
    public String getDescription() {
        return "List sorted";
    }

    @Override
    public void run() {
        System.out.print("Choose on which column to sort by: \n 1 - pesel \n 2 - name \n 3 - last name \n 4 - city \n");
        int column = this.scanner.nextInt();

        switch (column) {
            case 1:
                this.sortByPesel();
                break;
            case 2:
                this.sortByName();
                break;
            case 3:
                this.sortByLastName();
                break;
            case 4:
                this.sortByCity();
                break;
            default:
                System.out.println("Wrong column has been chosen.");
                break;
        }
    }

    private void sortByPesel() {
        this.database.getAll().forEach(System.out::println);
    }

    private void sortByName() {
        this.database.getAll().stream()
                .sorted(Comparator.comparing(Person::getName, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    private void sortByLastName() {
        this.database.getAll().stream()
                .sorted(Comparator.comparing(Person::getLastName, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    private void sortByCity() {
        this.database.getAll().stream()
                .sorted(Comparator.comparing(Person::getCity, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }
}
