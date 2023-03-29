#  Task-It Java Application

This is a simple to-do Java application that allows users to create, read, update, and delete tasks. The application uses the command-line interface (CLI) to interact with the user and stores the tasks in a database.

## Getting Started

### Prerequisites

To run this application, you need to have Java Development Kit (JDK) installed on your machine. You can download the latest version of JDK from the official website: https://www.oracle.com/java/technologies/javase-downloads.html

### Installing

1. Clone the repository or download the ZIP file and extract it to a folder.
2. Open the terminal or command prompt and navigate to the folder containing the application.
3. Compile the Java files by running the following command: javac -d bin -cp src src/com/todo/*.java
4. Run the application by running the following command: java -cp bin com.todo.App

### Usage

The application provides the following commands:

#### Create a task

To create a new task, run the following command:

[Insert Screen Shot of Code] create <task description>

Example: **_****'create Buy groceries****_**'

#### Read all tasks

To read all the tasks, run the following command:

[Insert Screen Shot of Code] read

#### Read a specific task

To read a specific task, run the following command:

[Insert Screen Shot of Code] read <task id>

Example: **_'read 1'_**

#### Update a task

To update a task, run the following command:

[Insert Screen Shot of Code] update <task id> <new task description>

Example: **_'update 1 Buy milk'_**

#### Delete a task

To delete a task, run the following command:

[Insert Screen Shot of Code] delete <task id>

Example: **_'delete 1'_**

#### Exit the application

To exit the application, run the following command:

[Insert Screen Shot of Code] exit

### Project Ownership

This project was designed and implemented by Zoe Dang and Jacqueline Rhea.

