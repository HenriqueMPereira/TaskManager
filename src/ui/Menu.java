package ui;

import service.TaskManager;
import static utils.InputValidator.isIntegerInput;

import java.util.Scanner;

/**
 * Classe responsãvel por apresentar para o usuário o Menu no terminal
 * e interagir com o usuário para gerenciar tarefas
 *
 * <p>Permite criar, deletar, listar e encerrar o gerenciamento de tarefas</p>
 */
public class Menu {
    private TaskManager taskManager;
    private Scanner scanner;

    public Menu(){
        this.taskManager = new TaskManager();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método que interage com o usuário pelo terminal.
     * Apresenta ao usuário um menu com algumas opções, recebe as escolhas do usuário e
     * exibe ao usuário o resultado que ele deseja.
     */
    public void iniciarMenu(){
        int iUserMenuOption;
        do{
            showMenu();
            iUserMenuOption = receivesUserOption();
            switch (iUserMenuOption){
                case 1:
                    createTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    showTasks();
                    break;
                case 4:
                    completeTask();
                    break;
                case 0:
                    System.out.println("Você escolheu FECHAR o menu.");
                    break;
            }

        }while(iUserMenuOption != 0);
    }

    /**
     * Método para exibir menu para o usuário
     */
    private void showMenu(){
        System.out.println("Menu TaskManager");
        System.out.println("1: Se quiser criar uma task");
        System.out.println("2: Se quiser excluir uma task");
        System.out.println("3: Se quiser listar as tasks");
        System.out.println("4: Se quiser completar uma task");
        System.out.println("0: Se quiser fechar o menu");
        System.out.print("Digite uma opção: ");
    }

    /**
     * Método responsável por receber uma opção do Menu
     * @return O valor int escolhido pelo usuário
     */
    private int receivesUserOption(){
        String sInputUserMenuOption = scanner.nextLine();
        while(!isIntegerInput(sInputUserMenuOption)){
            System.out.print("Opção Inválida! Digite um número inteiro: ");
            sInputUserMenuOption = scanner.nextLine();
        }
        return (Integer.parseInt(sInputUserMenuOption));
    }

    /**
     * Método para criar uma Task
     */
    private void createTask(){
        System.out.print("Você escolheu CRIAR uma task.\nDigite a descrição: ");
        String sTaskDescription = scanner.nextLine();

        System.out.print("Digite um inteiro para a prioridade: ");
        String sInputPriority = scanner.nextLine();
        while(!isIntegerInput(sInputPriority)){
            System.out.print("Entrada inválida! Digite um número inteiro: ");
            sInputPriority = scanner.nextLine();
        }

        int iTaskPriority = Integer.parseInt(sInputPriority);
        taskManager.addTask(sTaskDescription,iTaskPriority);
        System.out.println("Task criada com sucesso!");
    }

    /**
     * Método para deletar uma Task
     */
    private void deleteTask(){
        System.out.println("Você escolheu EXCLUIR uma task.");

        if(taskManager.getTaskListSize() == 0){
            System.out.println("Nenhuma Task na lista! Escolha outra opção");
        }
        else {
            System.out.print("Digite o número da task a ser excluída: ");
            String sInputIndex = scanner.nextLine();
            while (!isIntegerInput(sInputIndex) || !taskManager.isOnTheList(Integer.parseInt(sInputIndex))) {
                if (!isIntegerInput(sInputIndex)) {
                    System.out.print("Entrada inválida! Digite um número inteiro: ");
                    sInputIndex = scanner.nextLine();
                } else if (!taskManager.isOnTheList(Integer.parseInt(sInputIndex))) {
                    System.out.println("Não existe essa task. O número deve ser no máximo " + (taskManager.getTaskListSize() - 1) + ".");
                    System.out.print("Digite outro número: ");
                    sInputIndex = scanner.nextLine();
                }
            }
            int iTaskIndex = Integer.parseInt(sInputIndex);
            taskManager.deleteTask(iTaskIndex);
            System.out.println("Task " + iTaskIndex + " EXCLUÍDA!");
        }
    }

    /**
     * Método para exibir todas as tasks para o usuário
     */
    private void showTasks(){
        System.out.println("Você escolheu LISTAR as tasks.");
        taskManager.showTasks();
    }

    private void completeTask(){
        System.out.println("Você escolheu COMPLETAR uma task!");

        if(taskManager.getTaskListSize() == 0){
            System.out.println("Nenhuma TASK na lista! Escolha outra opção!");
        }
        else {
            System.out.print("Digite o index da Task a ser excluída: ");

            String sInputIndex = scanner.nextLine();
            while (!isIntegerInput(sInputIndex) || !taskManager.isOnTheList(Integer.parseInt(sInputIndex))) {
                if (!isIntegerInput(sInputIndex)) {
                    System.out.println("Entrada inválida! Digite um número inteiro: ");
                } else if (!taskManager.isOnTheList(Integer.parseInt(sInputIndex))){
                    System.out.println("Não existe essa task. O número deve ser no máximo " + (taskManager.getTaskListSize() - 1) + ".");
                    System.out.print("Digite outro número: ");
                    sInputIndex = scanner.nextLine();
                }
            }
            int iTaskIndex = Integer.parseInt(sInputIndex);
            taskManager.completingTask(iTaskIndex);
            System.out.println("Task " + iTaskIndex + " marcada como CONCLUÍDA!");
        }
    }
}