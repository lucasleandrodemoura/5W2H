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
@Table(name = "status")
public class Status extends Validacoes implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstatus")
     private int idstatus;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "ativo")
     private Boolean ativo;

    public Status() {
    }

    public Status(int idstatus, String descricao, Boolean ativo) {
        this.idstatus = idstatus;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Status(int idstatus) {
        this.idstatus = idstatus;
    }

    public Status(String descricao, Boolean ativo) {
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getAtivoDescricao() {
        if(this.ativo){
            return "Ativo";
        }else{
            return "Inativo";
        }
    }
   



}


