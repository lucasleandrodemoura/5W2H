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
    
     public Connection getConexao() {
        return conexao;
    }

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
     * Função que realiza a criação de todas as tabelas necessárias para o sistema
     */
     public void createTable(){
         String sql = "CREATE TABLE IF NOT EXISTS usuarios (\n" +
"  idusuarios SERIAL NOT NULL,\n" +
"  nome VARCHAR(255) NOT NULL,\n" +
"  email VARCHAR(255) NOT NULL UNIQUE,\n" +
"  senha VARCHAR(50) NOT NULL,\n" +
"  privilegio INT NULL DEFAULT 0,\n" +
"  ativo boolean NULL DEFAULT false,\n" +
"  PRIMARY KEY (idusuarios)\n" +
"  );\n" +
"CREATE TABLE IF NOT EXISTS categorias (\n" +
"  idcategorias SERIAL NOT NULL,\n" +
"  descricao VARCHAR(150) NOT NULL,\n" +
"  ativo BOOLEAN NULL DEFAULT true,\n" +
"  PRIMARY KEY (idcategorias))\n" +
";\n" +
"CREATE TABLE IF NOT EXISTS status (\n" +
"  idstatus SERIAL NOT NULL,\n" +
"  descricao VARCHAR(45) NOT NULL,\n" +
"  ativo BOOLEAN NULL DEFAULT true,\n" +
"  PRIMARY KEY (idstatus))\n" +
";\n" +
"CREATE TABLE IF NOT EXISTS acoes (\n" +
"  idacoes SERIAL NOT NULL,\n" +
"  quem INT NOT NULL,\n" +
"  categoria INT NOT NULL,\n" +
"  oque VARCHAR(255) NOT NULL ,\n" +
"  onde VARCHAR(255) NOT NULL ,\n" +
"  quando DATE NOT NULL ,\n" +
"  data_cadastro TIMESTAMP NOT NULL DEFAULT now(),\n" +
"  porque VARCHAR(255) NOT NULL ,\n" +
"  como VARCHAR(255) NOT NULL ,\n" +
"  status INT NOT NULL DEFAULT 1,\n" +
"  feedback VARCHAR(255) NULL,\n" +
"  avisar_envolvidos boolean DEFAULT false,\n" +
"  dias_antecedencia INT NULL DEFAULT 0,\n" +
"  PRIMARY KEY (idacoes),\n" +
"  CONSTRAINT fk_categorias\n" +
"    FOREIGN KEY (idacoes)\n" +
"    REFERENCES categorias (idcategorias)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT fk_quem\n" +
"    FOREIGN KEY (quem)\n" +
"    REFERENCES usuarios (idusuarios)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT fk_status\n" +
"    FOREIGN KEY (idacoes)\n" +
"    REFERENCES status (idstatus)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION)\n" +
";\n" +
"CREATE TABLE IF NOT EXISTS funcoes (\n" +
"  idfuncoes SERIAL NOT NULL,\n" +
"  descricao VARCHAR(150) NOT NULL,\n" +
"  ativo BOOLEAN NULL DEFAULT TRUE,\n" +
"  PRIMARY KEY (idfuncoes))\n" +
";\n" +
"CREATE TABLE IF NOT EXISTS acoes_equipe (\n" +
"  idusuarios INT NOT NULL,\n" +
"  idacoes INT NOT NULL,\n" +
"  idfuncoes INT NOT NULL,\n" +
"  PRIMARY KEY (idusuarios, idacoes),\n" +
"  \n" +
"  CONSTRAINT fk_usuarios\n" +
"    FOREIGN KEY (idusuarios)\n" +
"    REFERENCES usuarios (idusuarios)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT fk_acoes\n" +
"    FOREIGN KEY (idacoes)\n" +
"    REFERENCES acoes (idacoes)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT fk_funcoes\n" +
"    FOREIGN KEY (idfuncoes)\n" +
"    REFERENCES funcoes (idfuncoes)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION)\n" +
";";
         
         this.update(sql);
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
