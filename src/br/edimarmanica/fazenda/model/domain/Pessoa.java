/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import br.edimarmanica.fazenda.util.ValidacaoException;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edimar
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByCdPessoa", query = "SELECT p FROM Pessoa p WHERE p.cdPessoa = :cdPessoa"),
    @NamedQuery(name = "Pessoa.findByNmPessoa", query = "SELECT p FROM Pessoa p WHERE p.nmPessoa = :nmPessoa")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "cd_pessoa")
    private Integer cdPessoa;
    @Basic(optional = false)
    @Column(name = "nm_pessoa")
    private String nmPessoa;
    @OneToMany(mappedBy = "cdPessoaEmprestimo")
    private Collection<Caixa> caixaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdPessoa")
    private Collection<Caixa> caixaCollection1;
    @OneToMany(mappedBy = "cdPessoa")
    private Collection<Animal> animalCollection;

    public Pessoa() {
    }

    public Pessoa(Integer cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public Pessoa(Integer cdPessoa, String nmPessoa) {
        this.cdPessoa = cdPessoa;
        this.nmPessoa = nmPessoa;
    }

    public Integer getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(Integer cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa.toUpperCase();
    }

    @XmlTransient
    public Collection<Caixa> getCaixaCollection() {
        return caixaCollection;
    }

    public void setCaixaCollection(Collection<Caixa> caixaCollection) {
        this.caixaCollection = caixaCollection;
    }

    @XmlTransient
    public Collection<Caixa> getCaixaCollection1() {
        return caixaCollection1;
    }

    public void setCaixaCollection1(Collection<Caixa> caixaCollection1) {
        this.caixaCollection1 = caixaCollection1;
    }

    @XmlTransient
    public Collection<Animal> getAnimalCollection() {
        return animalCollection;
    }

    public void setAnimalCollection(Collection<Animal> animalCollection) {
        this.animalCollection = animalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdPessoa != null ? cdPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.cdPessoa == null && other.cdPessoa != null) || (this.cdPessoa != null && !this.cdPessoa.equals(other.cdPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edimarmanica.fazenda.bd.Pessoa[ cdPessoa=" + cdPessoa + " ]";
    }
    
    public void validar() throws ValidacaoException{
        if (this.nmPessoa == null || this.nmPessoa.trim().isEmpty()){
            throw new ValidacaoException("Campo nome não preenchido!");
        }
    }
    
}
