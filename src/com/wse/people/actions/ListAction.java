package com.wse.people.actions;

import com.wse.people.PeopleDatabase;

import java.util.Scanner;

public class ListAction extends Action {

    public ListAction(PeopleDatabase database, Scanner scanner) {
        super(database, scanner);
    }

    @Override
    public int getCode() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "List";
    }

    @Override
    public void run() {
        this.database.getAll().forEach(System.out::println);
    }
}
