package utils;

/**
 * Classe utilitária para validar entradas de usuário
 */
public class InputValidator {
    /**
     * Verifica se uma string pode ser convertida para um inteiro
     * @param sUserMenuOption string a ser verificada
     * @return true se for um inteiro, false caso contrário
     */
    public static boolean isIntegerInput(String sUserMenuOption){
        try{
            Integer.parseInt(sUserMenuOption);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
