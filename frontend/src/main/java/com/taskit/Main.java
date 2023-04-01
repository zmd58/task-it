package com.taskit;

import com.taskit.service.ConsoleService;
import com.taskit.service.TaskService;

public class Main {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private TaskService taskService = new TaskService();
    private ConsoleService consoleService = new ConsoleService();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        consoleService.printGreeting();
        mainMenu();
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                //View Your Task List
            } else if (menuSelection == 2) {
                taskMenu();
            } else if (menuSelection == 0) {
                break;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void taskMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printTaskMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                //Create new task
            } else if (menuSelection == 2) {
                editMenu();
            } else if (menuSelection == 3) {
                mainMenu();
            } else if (menuSelection == 0) {
                break;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void editMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printEditMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                //edit title
            } else if (menuSelection == 2) {
                //edit note
            } else if (menuSelection == 3) {
                //edit due date
            } else if (menuSelection == 4) {
                //edit status
            } else if (menuSelection == 5) {
                //delete task
            } else if (menuSelection == 6) {
                taskMenu();
            } else if (menuSelection == 7) {
                mainMenu();
            } else if (menuSelection == 0) {
                break;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }


}