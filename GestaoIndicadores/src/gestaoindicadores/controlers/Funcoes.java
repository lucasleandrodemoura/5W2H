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
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lucas Leandro de Moura
 */
@Entity
@Table(name = "funcoes")
public class Funcoes extends Validacoes implements java.io.Serializable{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfuncoes")
    private Collection<AcoesEquipe> acoesEquipeCollection;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfuncoes")
     private int idfuncoes;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "ativo")
     private Boolean ativo;

    public Funcoes() {
    }

    public Funcoes(int idfuncoes, String descricao, Boolean ativo) {
        this.idfuncoes = idfuncoes;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Funcoes(int idfuncoes) {
        this.idfuncoes = idfuncoes;
    }

    public Funcoes(String descricao, Boolean ativo) {
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdfuncoes() {
        return idfuncoes;
    }

    public void setIdfuncoes(int idfuncoes) {
        this.idfuncoes = idfuncoes;
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

    public Collection<AcoesEquipe> getAcoesEquipeCollection() {
        return acoesEquipeCollection;
    }

    public void setAcoesEquipeCollection(Collection<AcoesEquipe> acoesEquipeCollection) {
        this.acoesEquipeCollection = acoesEquipeCollection;
    }
   



}


