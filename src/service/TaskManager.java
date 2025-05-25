package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar uma lista de Task
 * Permite adicionar, excluir completar e listar as tarefas.
 */
public class TaskManager {
    private List<Task> task;

    public TaskManager(){
        this.task = new ArrayList<>();
    }

    /**
     * Método ara adicionar uma Task na lista de Task
     * @param sName: recebe do usuário o nome da task
     * @param iPriority: recebe do usuário a de prioridade
     */
    public void addTask(String sName, int iPriority){
        Task newTask = new Task(sName, iPriority);
        task.add(newTask);
    }

    /**
     * Método para deletar uma Task da lista
     * @param x: recebe o índice da Task a ser deletada
     */
    public void deleteTask(int x){
        if(isOnTheList(x)){
            task.remove(x);
        }
    }

    /**
     * Método para verificar se um indíce está dentro da lista de Task
     * @param x: índice passado pelo usuário
     * @return false se não pertence à lista; true se pertence à lista
     */
    public boolean isOnTheList(int x){
        if(x >= task.size()){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Método para verificar quantas tasks tem na lista
     * @return retorna o tamanho da lista de task
     */
    public int getTaskListSize(){
        return task.size();
    }

    /**
     * Método para mostrar ao usuário todas as Tasks na lista
     */
    public void showTasks(){
        if(task.isEmpty()){
            System.out.println("Nenhuma task cadastrada");
        }
        else{
            System.out.println("List of task:");
            for(int i = 0; i < task.size(); i++){
                Task t = task.get(i);
                System.out.println("Name: " + t.getTaskName() + "; Priority: " + t.getPriority() + "; Status: " + t.getCompleted());
            }
        }
    }

    /**
     * Método para marcar como feito uma task
     * @param iIndex: indíce da task passado pelo usuário
     */
    public void completingTask(int iIndex){
        Task t = task.get(iIndex);
        t.completeTask();
    }

}
