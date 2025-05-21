package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> task;

    public TaskManager(){
        this.task = new ArrayList<>();
    }

    public void addTask(String sName, int iPriority){
        Task newTask = new Task(sName, iPriority);
        task.add(newTask);

    }

    public void showTasks(){
        if(task.isEmpty()){
            System.out.println("Nenhuma task cadastrada");
        }
        else{
            System.out.println("List of task:");
            for(int i = 0; i < task.size(); i++){
                Task t = task.get(i);
                System.out.println("Description: " + t.getDescription() + "; Priority: " + t.getPriority());
            }
        }
    }

    public boolean deleteTask(int x){
        if(x >= task.size()){
            return false;
        }
        else{
            task.remove(x);
            return true;
        }
    }

    public int getTaskListSize(){
        return task.size();
    }

    public void completingTask(int iIndex){
        Task t = task.get(iIndex);
        t.completeTask();
    }

}
