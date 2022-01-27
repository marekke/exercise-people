package com.wse.people.actions;

import com.wse.people.PeopleDatabase;

import java.util.Scanner;

abstract class Action implements IAction {
    protected PeopleDatabase database;
    protected Scanner scanner;

    public Action (PeopleDatabase database, Scanner scanner) {
        this.database = database;
        this.scanner = scanner;
    }
}
