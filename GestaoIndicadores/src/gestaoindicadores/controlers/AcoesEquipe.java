/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores.controlers;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "acoes_equipe")
@NamedQueries({
    @NamedQuery(name = "AcoesEquipe.findAll", query = "SELECT a FROM AcoesEquipe a")
    , @NamedQuery(name = "AcoesEquipe.findByIdusuarios", query = "SELECT a FROM AcoesEquipe a WHERE a.acoesEquipePK.idusuarios = :idusuarios")
    , @NamedQuery(name = "AcoesEquipe.findByIdacoes", query = "SELECT a FROM AcoesEquipe a WHERE a.acoesEquipePK.idacoes = :idacoes")})
public class AcoesEquipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AcoesEquipePK acoesEquipePK;
    @JoinColumn(name = "idacoes", referencedColumnName = "idacoes", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Acoes acoes;
    @JoinColumn(name = "idfuncoes", referencedColumnName = "idfuncoes")
    @ManyToOne(optional = false)
    private Funcoes idfuncoes;
    @JoinColumn(name = "idusuarios", referencedColumnName = "idusuarios", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public AcoesEquipe() {
    }

    public AcoesEquipe(AcoesEquipePK acoesEquipePK) {
        this.acoesEquipePK = acoesEquipePK;
    }

    public AcoesEquipe(int idusuarios, int idacoes) {
        this.acoesEquipePK = new AcoesEquipePK(idusuarios, idacoes);
    }

    public AcoesEquipePK getAcoesEquipePK() {
        return acoesEquipePK;
    }

    public void setAcoesEquipePK(AcoesEquipePK acoesEquipePK) {
        this.acoesEquipePK = acoesEquipePK;
    }

    public Acoes getAcoes() {
        return acoes;
    }

    public void setAcoes(Acoes acoes) {
        this.acoes = acoes;
    }

    public Funcoes getIdfuncoes() {
        return idfuncoes;
    }

    public void setIdfuncoes(Funcoes idfuncoes) {
        this.idfuncoes = idfuncoes;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acoesEquipePK != null ? acoesEquipePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcoesEquipe)) {
            return false;
        }
        AcoesEquipe other = (AcoesEquipe) object;
        if ((this.acoesEquipePK == null && other.acoesEquipePK != null) || (this.acoesEquipePK != null && !this.acoesEquipePK.equals(other.acoesEquipePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestaoindicadores.controlers.AcoesEquipe[ acoesEquipePK=" + acoesEquipePK + " ]";
    }
    
}
