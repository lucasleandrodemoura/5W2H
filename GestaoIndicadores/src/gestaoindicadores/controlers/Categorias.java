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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Lucas Leandro de Moura
 */
@Entity
@Table(name = "categorias")
public class Categorias extends Validacoes implements java.io.Serializable{

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "categorias")
    private Acoes acoes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategorias")
     private int idcategorias;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "ativo")
     private Boolean ativo;

    public Categorias() {
    }

    public Categorias(int idcategorias, String descricao, Boolean ativo) {
        this.idcategorias = idcategorias;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Categorias(int idcategorias) {
        this.idcategorias = idcategorias;
    }

    public Categorias(String descricao, Boolean ativo) {
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdcategorias() {
        return idcategorias;
    }

    public void setIdcategorias(int idcategorias) {
        this.idcategorias = idcategorias;
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

    public Acoes getAcoes() {
        return acoes;
    }

    public void setAcoes(Acoes acoes) {
        this.acoes = acoes;
    }
   



}


