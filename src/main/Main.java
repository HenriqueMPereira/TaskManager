package main;

import model.User;
import model.Task;

public class Main {
    public static void main(String[] args) {
        User pessoa1 = new User("Henrique", 28);
        Task tarefa1 = new Task("Fazer janta", 1);

        tarefa1.taskProprerty();
        tarefa1.completeTask();
        tarefa1.taskProprerty();

    }
}