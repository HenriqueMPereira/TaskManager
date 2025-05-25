package service;

import model.TimedTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar uma lista de Task
 * Permite adicionar, excluir completar e listar as tarefas.
 */
public class TaskManager {
    private List<TimedTask> task;

    /**
     * Construtor da classe TaskManager
     */
    public TaskManager(){
        this.task = new ArrayList<>();
    }

    /**
     * Método ara adicionar uma Task na lista de Task
     * @param sName      recebe do usuário o nome da task
     * @param iPriority  recebe do usuário a de prioridade
     */
    public void addTask(String sName, int iPriority, int iDurationTime){
        TimedTask newTask = new TimedTask(sName, iPriority, iDurationTime);
        task.add(newTask);
    }

    /**
     * Método para deletar uma Task da lista
     * @param x recebe o índice da Task a ser deletada
     */
    public void deleteTask(int x){
        if(isOnTheList(x)){
            task.remove(x);
        }
    }

    /**
     * Método para verificar se um indíce está dentro da lista de Task
     * @param x índice passado pelo usuário
     * @return {@code true} se índice está na lista, {@code false} caso contrário.
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
                TimedTask t = task.get(i);
                System.out.println("Name: " + t.getTaskName() + "; Priority: " + t.getPriority() + "; Time: " + t.getDurationTime() +
                        " minutes; Status: " + t.getCompleted());
            }
        }
    }

    /**
     * Método para marcar como feito uma task
     * @param iIndex  indíce da task passado pelo usuário
     */
    public void completingTask(int iIndex){
        TimedTask t = task.get(iIndex);
        t.completeTask();
    }


    /**
     * Método auxiliar para ver se uma tas foi concluída
     * @param iIndex índice da task passada pelo usuário
     */
    public void isTheTaskCompleted(int iIndex){
        TimedTask t = task.get(iIndex);
        t.isCompleted();
    }
}
