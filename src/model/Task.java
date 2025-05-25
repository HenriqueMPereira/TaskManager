package model;


/**
 * Classe abstrata que representa uma tarefa genérica no sistema de gerenciamento de tarefas.
 *
 * <p>Define os atributos e comportamentos comuns que todas as tarefas (como tarefas com duração
 * ou com prazo) devem possuir. Essa classe deve ser estendida por classes concretas
 * que especificam o tipo de tarefa.</p>
 *
 * <p>Os principais atributos são: nome, prioridade e status de conclusão. Inclui métodos para
 * acessar e manipular esses atributos, além de declarar métodos abstratos que devem ser
 * implementados pelas subclasses.</p>
 */
public abstract class Task {
    protected String sTaskName;
    protected boolean bCompleted;
    protected int iPriority;

    /**
     * Construtor da classe Task.
     *
     * @param sTaskName  Nome da tarefa.
     * @param iPriority  Prioridade da tarefa (inteiro, quanto maior, mais prioridade).
     */
    public Task(String sTaskName, int iPriority){
        this.sTaskName = sTaskName;
        this.bCompleted = false;
        this.iPriority = iPriority;
    }

    /**
     * Método abstrato que exibe ao usuário se a task foi completada
     */
    public abstract void isCompleted();

    /**
     * Método que retorna o nome da Task
     */
    public String getTaskName(){
        return sTaskName;
    }

    /**
     * Verifica se a tarefa foi concluída.
     *
     * @return {@code true} se a tarefa estiver concluída, {@code false} caso contrário.
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
     * Método que marca como completa uma Task, alterando seu estado interno.
     */
    public void completeTask(){
        this.bCompleted = true;
    }
}
