/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores;

import gestaoindicadores.views.Login;
import gestaoindicadores.models.*;

/**
 *
 * @author lucas
 */
public class GestaoIndicadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Config.host = "localhost";
        Config.porta = "5432";
        Config.usuario = "postgres";
        Config.senha = "1234";
        Config.base = "sisacoes";
        new CRUD().createTable();
        new Login().setVisible(true);
    }
    
}
