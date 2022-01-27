package com.wse.people;

import com.wse.people.actions.IAction;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Controller implements Runnable{
    private PeopleDatabase database;
    private final Scanner scanner;
    private final Map<Integer, IAction> actions;
    private String menuText;

    public Controller(PeopleDatabase database, Scanner scanner) {
        this.database = database;
        this.scanner = scanner;

        this.actions = new TreeMap<>();
    }

    public Controller registerAction(IAction action) {
        this.actions.put(action.getCode(), action);
        return this;
    }

    @Override
    public void run() {
        this.generateMenuText();
        int selectedOption = -1;

        do {
            System.out.print(this.menuText);

            try {
                selectedOption = this.scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nWrong character has been provided.\n");
                scanner.nextLine();
                continue;
            }

            if (!this.actions.containsKey(selectedOption)) {
                System.out.println("\nWrong option has been selected.\n");
                continue;
            }

            this.runCommand(selectedOption);
        } while (selectedOption != 0);
    }

    private void generateMenuText() {
        this.menuText = "People database menu \n";
        this.menuText += "-----------------------\n";

        for (Map.Entry<Integer, IAction> entry : this.actions.entrySet()) {
            this.menuText += entry.getKey() + " - " + entry.getValue().getDescription() + "\n";
        }

        this.menuText += "0 - Exit \n";
        this.menuText += "Please select option: ";
    }

    private void runCommand(int selectedOption) {
        System.out.println("");
        this.actions.get(selectedOption).run();
        System.out.println("\n");
    }
}
