package gestaoindicadores.controlers;
// Generated 04/06/2017 15:43:50 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import gestaoindicadores.Validacoes;
import gestaoindicadores.models.CRUD;
import gestaoindicadores.models.Config;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import gestaoindicadores.models.HibernateUtil;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lucas Leandro de Moura
 */
@Entity
@Table(name = "usuarios")
public class Usuarios extends Validacoes implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuarios")
     private int idusuarios;
    @Column(name = "nome")
     private String nome;
    @Column(name = "email")
     private String email;
    @Column(name = "senha")
     private String senha;
    @Column(name = "privilegio")
     private int privilegio;
    @Column(name = "ativo")
     private Boolean ativo;

    public Usuarios() {
    }
    
    /**
     * Função responsável por realizar consulta se o usuário é apto a entrar no sistema ou não
     * @param usuario Usuário de autenticação
     * @param senha Senha de autenticação
     * @return TRUE para que foi aceito para entrar no sistema
     * @throws SQLException Deverá ser aplicado SQLException ao utilizar esta função
     */
    public boolean Logar(String usuario,String senha) throws SQLException{
        boolean status = false;
        
         CRUD crud = new CRUD();
         ResultSet select = crud.select("SELECT * FROM usuarios "
                 + "WHERE "
                 + "email = '"+usuario+"' "
                         + "AND senha = '"+senha+"' "
                                 + "and ativo = true");
         
         while(select.next()){
             status = true;
             this.idusuarios = select.getInt("idusuarios");
             this.nome = select.getString("nome");
             this.email = select.getString("email");
             this.senha = select.getString("senha");;
             this.privilegio = select.getInt("privilegio");
             this.ativo = select.getBoolean("ativo");
             Config.usuario_logado = this.getIdusuarios();
             Config.usuario_nome = this.getNome();
             Config.privilegio = this.getPrivilegio();
         }
        
        
        return status;
    }
            

	
    public Usuarios(int idusuarios, String nome, String email, String senha, boolean privilegio) {
        this.idusuarios = idusuarios;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        if(privilegio){
        this.privilegio = 1;
        }
        else{
        this.privilegio = 0;
        }
    }
    
    public Usuarios(int idusuarios, String nome, String email, String senha, boolean privilegio, boolean ativo) {
       this.idusuarios = idusuarios;
       this.nome = nome;
       this.email = email;
       this.senha = senha;
       if(privilegio)
        this.privilegio = 1;
       else
        this.privilegio = 0;
       
       this.ativo = ativo;
       
    }
    
    
    public Usuarios(String nome, String email, String senha, boolean privilegio, boolean ativo) {
      
       this.nome = nome;
       this.email = email;
       this.senha = senha;
       if(privilegio)
        this.privilegio = 1;
       else
        this.privilegio = 0;
       
       this.ativo = ativo;
       
    }
    
    
    
    public int getIdusuarios() {
        return this.idusuarios;
    }
    
    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getPrivilegio() {
        return this.privilegio;
    }
    
    
     public boolean getPrivilegioBoolean() {
        if(this.getPrivilegio()==0)
         return false;
        else
            return true;
         
    }
    
    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
    public Boolean getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getAtivoDescricao() {
        if(this.getAtivo()){
            return "Sim";
        }else{
            return "Não";
        }
    }




}


