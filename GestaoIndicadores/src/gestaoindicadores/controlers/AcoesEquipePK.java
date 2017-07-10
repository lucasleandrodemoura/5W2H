/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores.controlers;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author lucas
 */
@Embeddable
public class AcoesEquipePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idusuarios")
    private int idusuarios;
    @Basic(optional = false)
    @Column(name = "idacoes")
    private int idacoes;

    public AcoesEquipePK() {
    }

    public AcoesEquipePK(int idusuarios, int idacoes) {
        this.idusuarios = idusuarios;
        this.idacoes = idacoes;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public int getIdacoes() {
        return idacoes;
    }

    public void setIdacoes(int idacoes) {
        this.idacoes = idacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idusuarios;
        hash += (int) idacoes;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcoesEquipePK)) {
            return false;
        }
        AcoesEquipePK other = (AcoesEquipePK) object;
        if (this.idusuarios != other.idusuarios) {
            return false;
        }
        if (this.idacoes != other.idacoes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestaoindicadores.controlers.AcoesEquipePK[ idusuarios=" + idusuarios + ", idacoes=" + idacoes + " ]";
    }
    
}
