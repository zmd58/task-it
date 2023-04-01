package com.taskit.service;

import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println();
        System.out.println("******************************************************************************************************");
        System.out.println("WELCOME TO");
        System.out.println("\n" +
                "$$$$$$$$$$\\     $$\\       $$$$$$$$$$\\  $$ |   $$ |            $$$$$$$$$$$$\\    $$$$$$$$$$\\  \n" +
                "\\__$$  ___|    $$  \\      $$  ______|  $$ |  $$ /             \\___ $$  ___|    \\__$$  ___| \n" +
                "   $$ |       $$    \\     $$ |         $$ | $$ /                   $$ |           $$ |      \n" +
                "   $$ |      $$$$$$$$\\    $$$$$$$$$ |  $$ $$$ \\    $$$$$$$$\\       $$ |           $$ |      \n" +
                "   $$ |     $$ _____  \\   \\____  $$ |  $$ | $$ \\   \\_______|       $$ |           $$ |      \n" +
                "   $$ |    $$ |    $$  \\       | $$ |  $$ |  $$ \\                  $$ |           $$ |      \n" +
                "   $$ |   $$  |     $$  \\ $$$$$$$$$ |  $$ |   $$ \\            $$$$$$$$$$$$\\       $$ |      \n" +
                "   \\__|   \\___|     \\___| \\________/   \\__|    \\__|           \\___________|       \\__|      \n");
        System.out.println("******************************************************************************************************");
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("MAIN MENU");
        System.out.println("1: View Your Task List");
        System.out.println("2: Go To Task Menu");
        System.out.println("0: Exit");
        System.out.println();
        System.out.println("******************************************************************************************************");
    }

    public void printTaskMenu() {
        System.out.println();
        System.out.println();
        System.out.println("******************************************************************************************************");
        System.out.println("TASK MENU");
        System.out.println("******************************************************************************************************");
        System.out.println("1: Create New Task");
        System.out.println("2: Edit Existing Task");
        System.out.println("3: Return To The Main Menu");
        System.out.println("0: Exit");
        System.out.println();
        System.out.println("******************************************************************************************************");
        System.out.println();
    }

    public void printEditMenu() {
        System.out.println();
        System.out.println();
        System.out.println("******************************************************************************************************");
        System.out.println("EDIT MENU");
        System.out.println("******************************************************************************************************");
        System.out.println("1: Edit Title");
        System.out.println("2: Edit Note");
        System.out.println("3: Edit Due Date");
        System.out.println("4: Edit Status");
        System.out.println("5: Delete Task");
        System.out.println("6: Return To Task Menu");
        System.out.println("7: Return To The Main Menu");
        System.out.println("0: Exit");
        System.out.println();
        System.out.println("******************************************************************************************************");
        System.out.println();
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

}
