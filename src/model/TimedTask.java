package model;

/**
 * Classe que representa uma tarefa cronometrada, ou seja, uma tarefa que possui uma duração específica.
 *
 * <p>Estende a classe abstrata {@link Task}, herdando seus atributos e comportamentos comuns,
 * e adiciona o atributo {@code iDurationTime} para representar o tempo estimado de execução da tarefa.</p>
 *
 * <p>Essa classe é útil para tarefas que exigem controle de tempo, como "estudar por 30 minutos"
 * ou "fazer exercícios físicos por 45 minutos".</p>
 *
 */
public class TimedTask extends Task{
    private int iDurationTime;

    /**
     * Construtor da classe {@code TimedTask}.
     *
     * @param sInputName         Nome da tarefa.
     * @param iInputPriority     Prioridade da tarefa.
     * @param iInputDurationTime Duração da tarefa em minutos.
     */
    public TimedTask(String sInputName, int iInputPriority, int iInputDurationTime){
        super(sInputName,iInputPriority);
        this.iDurationTime = iInputDurationTime;
    }

    /**
     * Exibe no terminal uma mensagem indicando se a tarefa já foi concluída ou não.
     *
     * <p>Esse método sobrescreve o método abstrato definido na superclasse {@code Task}.</p>
     */
    @Override
    public void isCompleted() {
        if(!bCompleted){
            System.out.println("A task ainda não foi concluída!");
        }
        else{
            System.out.println("A task " + sTaskName + " á foi concluída!");
        }
    }

    /**
     * Retorna o tempo de duração da tarefa.
     *
     * @return Tempo de duração da tarefa, em minutos.
     */
    public int getDurationTime(){
        return iDurationTime;
    }
}
