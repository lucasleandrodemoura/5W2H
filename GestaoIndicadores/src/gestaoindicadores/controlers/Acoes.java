/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores.controlers;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "acoes")
@NamedQueries({
    @NamedQuery(name = "Acoes.findAll", query = "SELECT a FROM Acoes a")})
public class Acoes implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acoes")
    private Collection<AcoesEquipe> acoesEquipeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacoes")
    private Integer idacoes;
    @Basic(optional = false)
    @Column(name = "categoria")
    private int categoria;
    @Basic(optional = false)
    @Column(name = "oque")
    private String oque;
    @Basic(optional = false)
    @Column(name = "onde")
    private String onde;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Basic(optional = false)
    @Column(name = "porque")
    private String porque;
    @Basic(optional = false)
    @Column(name = "como")
    private String como;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "avisar_envolvidos")
    private Boolean avisarEnvolvidos;
    @Column(name = "dias_antecedencia")
    private Integer diasAntecedencia;
    @Column(name = "quando")
    private String quando;
    @JoinColumn(name = "categoria", referencedColumnName = "idcategorias", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Categorias categorias;
    @JoinColumn(name = "status", referencedColumnName = "idstatus", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Status statusC;
    @JoinColumn(name = "quem", referencedColumnName = "idusuarios")
    @ManyToOne(optional = false)
    private Usuarios quem;

    public Status getStatusC() {
        return statusC;
    }

    public void setStatusC(Status statusC) {
        this.statusC = statusC;
    }
    
    
    

    public Acoes() {
    }

    public Acoes(Integer idacoes) {
        this.idacoes = idacoes;
    }

    public Acoes(Integer idacoes, int categoria, String oque, String onde, Date dataCadastro, String porque, String como, int status, String feedback, Boolean avisarEnvolvidos, Integer diasAntecedencia, String quando, Categorias categorias, Usuarios quem) {
        this.idacoes = idacoes;
        this.categoria = categoria;
        this.oque = oque;
        this.onde = onde;
        this.dataCadastro = dataCadastro;
        this.porque = porque;
        this.como = como;
        this.status = status;
        this.feedback = feedback;
        this.avisarEnvolvidos = avisarEnvolvidos;
        this.diasAntecedencia = diasAntecedencia;
        this.quando = quando;
        this.categorias = categorias;
        this.quem = quem;
    }
    
    

    public Acoes(Integer idacoes, int categoria, String oque, String onde, String porque, String como, int status) {
        this.idacoes = idacoes;
        this.categoria = categoria;
        this.oque = oque;
        this.onde = onde;
        this.porque = porque;
        this.como = como;
        this.status = status;
    }

    public Integer getIdacoes() {
        return idacoes;
    }

    public void setIdacoes(Integer idacoes) {
        this.idacoes = idacoes;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getOque() {
        return oque;
    }

    public void setOque(String oque) {
        this.oque = oque;
    }

    public String getOnde() {
        return onde;
    }

    public void setOnde(String onde) {
        this.onde = onde;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getPorque() {
        return porque;
    }

    public void setPorque(String porque) {
        this.porque = porque;
    }

    public String getComo() {
        return como;
    }

    public void setComo(String como) {
        this.como = como;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Boolean getAvisarEnvolvidos() {
        return avisarEnvolvidos;
    }

    public void setAvisarEnvolvidos(Boolean avisarEnvolvidos) {
        this.avisarEnvolvidos = avisarEnvolvidos;
    }

    public Integer getDiasAntecedencia() {
        return diasAntecedencia;
    }

    public void setDiasAntecedencia(Integer diasAntecedencia) {
        this.diasAntecedencia = diasAntecedencia;
    }

    public String getQuando() {
        return quando;
    }

    public void setQuando(String quando) {
        this.quando = quando;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Usuarios getQuem() {
        return quem;
    }

    public void setQuem(Usuarios quem) {
        this.quem = quem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacoes != null ? idacoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acoes)) {
            return false;
        }
        Acoes other = (Acoes) object;
        if ((this.idacoes == null && other.idacoes != null) || (this.idacoes != null && !this.idacoes.equals(other.idacoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestaoindicadores.controlers.Acoes[ idacoes=" + idacoes + " ]";
    }

    public Collection<AcoesEquipe> getAcoesEquipeCollection() {
        return acoesEquipeCollection;
    }

    public void setAcoesEquipeCollection(Collection<AcoesEquipe> acoesEquipeCollection) {
        this.acoesEquipeCollection = acoesEquipeCollection;
    }
    
}
