package com.taskit;

import com.taskit.model.Task;
import com.taskit.service.ConsoleService;
import com.taskit.service.TaskService;

public class Main {

    private static final String API_BASE_URL = "http://localhost:8080/taskit/";

    private TaskService taskService = new TaskService(API_BASE_URL);
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
        while (true) {
            consoleService.printMainMenu();
            int menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                //View Your Task List
                test();
            } else if (menuSelection == 2) {
                taskMenu();
            } else if (menuSelection == 0) {
                System.exit(0);
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void taskMenu() {
        while (true) {
            consoleService.printTaskMenu();
            int menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                //Create new task
            } else if (menuSelection == 2) {
                editMenu();
            } else if (menuSelection == 3) {
                mainMenu();
            } else if (menuSelection == 0) {
                System.exit(0);
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void editMenu() {
        while (true) {
            consoleService.printEditMenu();
            int menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
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
                System.exit(0);
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    public void test() {
        Task[] tasks = taskService.getAllTasks();

        if (tasks == null) {
            System.out.println("No task found");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task.getId());
        }
    }

}