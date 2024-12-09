package com.sio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Création de la liste des taches
    private static ArrayList<String> tasks = new ArrayList<>();

    //Creation de la liste des status
    private static ArrayList<Boolean> status = new ArrayList<>();

    //Création du scanner
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Déclaration du menu
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1: addTask(); break;
                case 2: completeTask(); break;
                case 3: deleteTask(); break;
                case 4: displayTasks(); break;
                case 5: System.exit(0); break;
                default: System.out.println("Invalid choice!"); break;
            }
        }
    }

    //Méthode pour ajouter une tache
    private static void addTask() {
        // Demander à l'utilisateur le nom de la tâche
        System.out.print("Enter task: ");
        // Recupérer la tache
        String task = scanner.nextLine();
        // Faire les vérifications d'usages
        if (task.isEmpty()) {
            System.err.println("ERROR - Task cannot be empty!");
            return;
        }
        // Ajouter la tache à la liste
        tasks.add(task);
        status.add(false);
    }

    //Méthode pour afficher les taches
    private static void displayTasks(){
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                //System.out.println((i + 1) + ". " + tasks.get(i));
                System.out.println((i + 1) + ". " + tasks.get(i) + " [" + (status.get(i) ? "Complete" : "Incomplete") + "]");
            }
        }
    }

    //Méthode pour supprimer une tache
    private static void deleteTask(){
        System.out.print("Enter task number to delete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            status.remove(taskNumber - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    //Méthode pour mettre à jour le status d'une tache
    private static void completeTask(){
        System.out.print("Enter task number to complete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            status.set(taskNumber - 1, true);
            System.out.println("Task completed successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }
}