package model;

public class Task {
    private String sDescription;
    private boolean bCompleted;
    private int iPriority;

    public Task(String sDescription, int iPriority){
        this.sDescription = sDescription;
        this.bCompleted = false;
        this.iPriority = iPriority;
    }

    public String getDescription(){
        return sDescription;
    }

    public boolean getCompleted(){
        return bCompleted;
    }

    public int getPriority(){
        return iPriority;
    }

    public void completeTask(){
        this.bCompleted = true;
        System.out.println("A tarefa " + this.sDescription + " foi concluída!");
    }

    public void taskProprerty(){
        System.out.println("Description: " + sDescription);
        System.out.println("Priority: " + iPriority);
        if(this.bCompleted == true){
            System.out.println("Stats: Completed!");
        }
        else{
            System.out.println("Stats: Not Completed!");
        }
    }
}
