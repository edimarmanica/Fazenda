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
@Table(name = "item_checklist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemChecklist.findAll", query = "SELECT i FROM ItemChecklist i"),
    @NamedQuery(name = "ItemChecklist.findByCdItem", query = "SELECT i FROM ItemChecklist i WHERE i.cdItem = :cdItem"),
    @NamedQuery(name = "ItemChecklist.findByNmItem", query = "SELECT i FROM ItemChecklist i WHERE i.nmItem = :nmItem")})
public class ItemChecklist extends Entidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_item")
    private Integer cdItem;
    @Basic(optional = false)
    @Column(name = "nm_item")
    private String nmItem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemChecklist")
    private Collection<TipoChecklistItemChecklist> tipoChecklistItemChecklistCollection;

    public ItemChecklist() {
    }

    public ItemChecklist(Integer cdItem) {
        this.cdItem = cdItem;
    }

    public ItemChecklist(Integer cdItem, String nmItem) {
        this.cdItem = cdItem;
        this.nmItem = nmItem;
    }

    public Integer getCdItem() {
        return cdItem;
    }

    public void setCdItem(Integer cdItem) {
        this.cdItem = cdItem;
    }

    public String getNmItem() {
        return nmItem;
    }

    public void setNmItem(String nmItem) {
        this.nmItem = nmItem;
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
        hash += (cdItem != null ? cdItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemChecklist)) {
            return false;
        }
        ItemChecklist other = (ItemChecklist) object;
        if ((this.cdItem == null && other.cdItem != null) || (this.cdItem != null && !this.cdItem.equals(other.cdItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edimarmanica.fazenda.bd.ItemChecklist[ cdItem=" + cdItem + " ]";
    }

    @Override
    public void validar() throws ValidacaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
