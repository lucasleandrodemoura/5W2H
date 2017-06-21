/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores;

/**
 * Classe com funções básicas de validações
 * @author Lucas
 */
public class Validacoes {
    /**
     * Retorna se um e-mail contém o @ ou nao
     * @param email Email a ser analisado
     * @return boolean Retorna verdadeiro ou falso
     */
    public boolean validarEmail(String email){

    
        int validar = email.indexOf("@");
        if(validar>0){
            return true;
        }else{
            return false;
        }

    }
}
