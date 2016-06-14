/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

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
@Table(name = "tipo_checklist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoChecklist.findAll", query = "SELECT t FROM TipoChecklist t"),
    @NamedQuery(name = "TipoChecklist.findByCdTipo", query = "SELECT t FROM TipoChecklist t WHERE t.cdTipo = :cdTipo"),
    @NamedQuery(name = "TipoChecklist.findByNmTipo", query = "SELECT t FROM TipoChecklist t WHERE t.nmTipo = :nmTipo")})
public class TipoChecklist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_tipo")
    private Integer cdTipo;
    @Basic(optional = false)
    @Column(name = "nm_tipo")
    private String nmTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoChecklist")
    private Collection<TipoChecklistItemChecklist> tipoChecklistItemChecklistCollection;

    public TipoChecklist() {
    }

    public TipoChecklist(Integer cdTipo) {
        this.cdTipo = cdTipo;
    }

    public TipoChecklist(Integer cdTipo, String nmTipo) {
        this.cdTipo = cdTipo;
        this.nmTipo = nmTipo;
    }

    public Integer getCdTipo() {
        return cdTipo;
    }

    public void setCdTipo(Integer cdTipo) {
        this.cdTipo = cdTipo;
    }

    public String getNmTipo() {
        return nmTipo;
    }

    public void setNmTipo(String nmTipo) {
        this.nmTipo = nmTipo;
    }

    @XmlTransient
    public Collection<TipoChecklistItemChecklist> getTipoChecklistItemChecklistCollection() {
        return tipoChecklistItemChecklistCollection;
    }

    public void setTipoChecklistItemChecklistCollection(Collection<TipoChecklistItemChecklist> tipoChecklistItemChecklistCollection) {
        this.tipoChecklistItemChecklistCollection = tipoChecklistItemChecklistCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdTipo != null ? cdTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoChecklist)) {
            return false;
        }
        TipoChecklist other = (TipoChecklist) object;
        if ((this.cdTipo == null && other.cdTipo != null) || (this.cdTipo != null && !this.cdTipo.equals(other.cdTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edimarmanica.fazenda.bd.TipoChecklist[ cdTipo=" + cdTipo + " ]";
    }
    
}
