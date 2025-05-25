package model;

public class Task {
    private String sTaskName;
    private boolean bCompleted;
    private int iPriority;

    public Task(String sTaskName, int iPriority){
        this.sTaskName = sTaskName;
        this.bCompleted = false;
        this.iPriority = iPriority;
    }

    /**
     * Método que retorna a descrição da Task
     */
    public String getTaskName(){
        return sTaskName;
    }

    /**
     * Método que retorna true se a Task foi cumprida e false se ainda não
     */
    public boolean getCompleted(){
        return bCompleted;
    }

    /**
     * Método simples para retornar a prioridade da Task
     * @return int prioridade da Task
     */
    public int getPriority(){
        return iPriority;
    }

    /**
     * Método que marca como completa uma Task
     */
    public void completeTask(){
        this.bCompleted = true;
    }
}
