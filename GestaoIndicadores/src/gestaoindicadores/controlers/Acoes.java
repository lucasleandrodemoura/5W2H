/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores.controlers;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "acoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acoes.findAll", query = "SELECT a FROM Acoes a")
    , @NamedQuery(name = "Acoes.findByIdacoes", query = "SELECT a FROM Acoes a WHERE a.idacoes = :idacoes")
    , @NamedQuery(name = "Acoes.findByCategoria", query = "SELECT a FROM Acoes a WHERE a.categoria = :categoria")
    , @NamedQuery(name = "Acoes.findByOque", query = "SELECT a FROM Acoes a WHERE a.oque = :oque")
    , @NamedQuery(name = "Acoes.findByOnde", query = "SELECT a FROM Acoes a WHERE a.onde = :onde")
    , @NamedQuery(name = "Acoes.findByDataCadastro", query = "SELECT a FROM Acoes a WHERE a.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "Acoes.findByPorque", query = "SELECT a FROM Acoes a WHERE a.porque = :porque")
    , @NamedQuery(name = "Acoes.findByComo", query = "SELECT a FROM Acoes a WHERE a.como = :como")
    , @NamedQuery(name = "Acoes.findByStatus", query = "SELECT a FROM Acoes a WHERE a.status = :status")
    , @NamedQuery(name = "Acoes.findByFeedback", query = "SELECT a FROM Acoes a WHERE a.feedback = :feedback")
    , @NamedQuery(name = "Acoes.findByAvisarEnvolvidos", query = "SELECT a FROM Acoes a WHERE a.avisarEnvolvidos = :avisarEnvolvidos")
    , @NamedQuery(name = "Acoes.findByDiasAntecedencia", query = "SELECT a FROM Acoes a WHERE a.diasAntecedencia = :diasAntecedencia")
    , @NamedQuery(name = "Acoes.findByQuando", query = "SELECT a FROM Acoes a WHERE a.quando = :quando")})
public class Acoes implements Serializable {

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

    public Acoes() {
    }

    public Acoes(Integer idacoes) {
        this.idacoes = idacoes;
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
    
}
