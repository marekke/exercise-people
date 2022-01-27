package com.wse.people;


import com.wse.people.actions.AddAction;
import com.wse.people.actions.ListAction;
import com.wse.people.actions.RemoveAction;
import com.wse.people.actions.SortAction;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PeopleDatabase db = new PeopleDatabase();
        Controller controller = new Controller(db, scanner);

        controller.registerAction(new ListAction(db, scanner))
            .registerAction(new SortAction(db, scanner))
            .registerAction(new AddAction(db, scanner))
            .registerAction(new RemoveAction(db, scanner));

        controller.run();
    }
}
