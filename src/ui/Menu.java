package ui;

import service.TaskManager;

import java.util.Scanner;

public class Menu {

    private TaskManager taskManager;
    private Scanner scanner;

    public Menu(){
        this.taskManager = new TaskManager();
        this.scanner = new Scanner(System.in);
    }

    public void teste(){
        String sUserMenuOption; // String recebe opção do menu escolhida (verificar se int)
        int iOption; // Inteiro para receber a opção convertida
        String sUserInputHelper; // String recebe valor digitado pelo usuário (verificar se int)
        int iUserAuxInput; // Inteiro recebe valor convertido da string acima
        String sTaskDescription; // String recebe descrição da task

        do{
            System.out.println("Menu TaskManager");
            System.out.println("1: Se quiser criar uma task");
            System.out.println("2: Se quiser excluir uma task");
            System.out.println("3: Se quiser listar as tasks");
            System.out.println("0: Se quiser fechar o menu");
            System.out.print("Digite uma opção: ");

            // Recebe entrada do usuário e verifica se é um inteiro
            sUserMenuOption = scanner.nextLine();
            while(!isIntegerInput(sUserMenuOption)){
                System.out.print("Opção Inválida! Digite um número inteiro: ");
                sUserMenuOption = scanner.nextLine();
            }
            iOption = Integer.parseInt(sUserMenuOption);

            switch (iOption){
                case 1: // Caso usuário queira criar uma TASK
                    System.out.print("Você escolheu CRIAR uma task.\nDigite a descrição: ");
                    sTaskDescription = scanner.nextLine();
                    System.out.print("Digite um inteiro para a prioridade: ");
                    sUserInputHelper = scanner.nextLine();
                    while(!isIntegerInput(sUserInputHelper)){ // Verifica se o usuário inseriu um inteiro
                        System.out.print("Entrada inválida! Digite um número inteiro: ");
                        sUserInputHelper = scanner.nextLine();
                    }
                    iUserAuxInput = Integer.parseInt(sUserInputHelper);
                    taskManager.addTask(sTaskDescription,iUserAuxInput);

                    break;
                case 2: // Caso usuário queira deletar uma TASK
                    System.out.print("Você escolheu EXCLUIR uma task.\nDigite o número da task a ser excluída: ");
                    sUserInputHelper = scanner.nextLine();
                    // Verifica se o usuário digitou um inteiro e se está dentro do escopo da lista Task
                    while(!isIntegerInput(sUserInputHelper) || Integer.parseInt(sUserInputHelper) >= taskManager.getTaskListSize()){
                        if(!isIntegerInput(sUserInputHelper)) { // Caso não seja inteiro
                            System.out.print("Entrada inválida! Digite um número inteiro: ");
                            sUserInputHelper = scanner.nextLine();
                        } else if (Integer.parseInt(sUserInputHelper) >= taskManager.getTaskListSize()) { // Caso fora do escopo
                            System.out.println("Não existe essa task. O número deve ser no máximo " + (taskManager.getTaskListSize()-1) +".");
                            System.out.print("Digite outro número: ");
                            sUserInputHelper = scanner.nextLine();
                        }
                    }
                    iUserAuxInput = Integer.parseInt(sUserInputHelper);
                    taskManager.deleteTask(iUserAuxInput);
                    System.out.println("Task " + iUserAuxInput + " EXCLUÍDA!");

                    break;
                case 3: // Caso usuário escolha listas as TASKS
                    System.out.println("Você escolheu LISTAR as tasks.");
                    taskManager.showTasks();

                    break;
                case 0: // Caso usuário escolha fechar o Menu
                    System.out.println("Você escolheu FECHAR o menu.");

                    break;
            }

        }while(iOption != 0);
    }

    // Método para verificar se a String pode ser convertida em int
    public boolean isIntegerInput(String sUserMenuOption){
        try{
            Integer.parseInt(sUserMenuOption);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
