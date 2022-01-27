package com.wse.people.actions;

import com.wse.people.PeopleDatabase;

import java.util.Scanner;

public class RemoveAction extends Action{
    public RemoveAction(PeopleDatabase database, Scanner scanner) {
        super(database, scanner);
    }

    @Override
    public int getCode() {
        return 4;
    }

    @Override
    public String getDescription() {
        return "Remove";
    }

    @Override
    public void run() {
        System.out.println("Giva a pesel: ");
        long pesel = this.scanner.nextLong();
        this.scanner.nextLine();

        if (this.database.removePersonByPesel(pesel)) {
            System.out.println("Successfully removed person.");
        } else {
            System.out.println("Person with specific pesel doesn't exists.");
        }
    }
}
