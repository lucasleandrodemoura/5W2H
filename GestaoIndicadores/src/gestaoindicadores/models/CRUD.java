/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores.models;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * Realiza as operações de banco de dados
 * @author Lucas Leandro de Moura
 */
public class CRUD {
    private static CRUD instancia = null;
    public Connection conexao = null;
    public Statement stmt = null;
    public ResultSet result = null;
    public int retorno = 0;
    private static Connection con;
    public String erro = "";
    
     /**
      * Realiza a conexão
      */
     public CRUD() {
        try {
         
            String dbdriver = "org.postgresql.Driver";
           
            String dburl = "jdbc:postgresql://"+Config.host+":"+Config.porta+"/"+Config.base;
            String dbuser = Config.usuario;
            String dbsenha = Config.senha;
            // Carrega Driver MySQL
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl);
            }

        } catch (Exception e) {
            System.err.println(e);
            this.erro = e.getMessage();
        }
    }
     /**
      * Checa se existe uma conexão ativa
      * @return boolean
      */
     public boolean isConectado(){
         if(conexao==null){
             return false;
         }else{
             return true;
         }
     }
     
     /**
      * Recebe uma instrução de modificação
      * @param sql UPDATE, DELETE ou INSERT
      */
     public void update(String sql){
        try {
            this.stmt = this.conexao.createStatement();
            this.retorno = this.stmt.executeUpdate(sql);
            if(retorno==1){
                //JOptionPane.showMessageDialog(null, "Ação realizada com sucesso!");
            }else{
                //JOptionPane.showMessageDialog(null, "Não foi possível realizar esta ação.");
                System.out.println("Erro: "+sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } 
     }
     
     /**
      * Realiza SELECTs no banco de dados
      * @param sql SELECT
      * @return Retorna um ResultSet de resultados
      */
     public ResultSet select(String sql){
        try {
            this.stmt = this.conexao.createStatement();
            return this.stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
     }
    
    
}
