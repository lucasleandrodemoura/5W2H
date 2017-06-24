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
public class Acoes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idacoes")
    private Integer idacoes;
    @Column(name = "categoria")
    private int categoria;
    @Column(name = "oque")
    private String oque;
    @Column(name = "onde")
    private String onde;
    @Column(name = "quando")
    private String quando;
    
    @Column(name = "data_cadastro")
   
    private String dataCadastro;
    
    @Column(name = "porque")
    private String porque;
    
    @Column(name = "como")
    private String como;
    
    @Column(name = "status")
    private int status;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "avisar_envolvidos")
    private Boolean avisarEnvolvidos;
    @Column(name = "dias_antecedencia")
    private Integer diasAntecedencia;

    public Acoes(Integer idacoes) {
        this.idacoes = idacoes;
    }
    
    
    
}
