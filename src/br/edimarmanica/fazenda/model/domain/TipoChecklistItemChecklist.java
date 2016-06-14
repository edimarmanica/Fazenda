/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.model.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edimar
 */
@Entity
@Table(name = "tipo_checklist_item_checklist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoChecklistItemChecklist.findAll", query = "SELECT t FROM TipoChecklistItemChecklist t"),
    @NamedQuery(name = "TipoChecklistItemChecklist.findByCdItemChecklist", query = "SELECT t FROM TipoChecklistItemChecklist t WHERE t.tipoChecklistItemChecklistPK.cdItemChecklist = :cdItemChecklist"),
    @NamedQuery(name = "TipoChecklistItemChecklist.findByCdTipoChecklist", query = "SELECT t FROM TipoChecklistItemChecklist t WHERE t.tipoChecklistItemChecklistPK.cdTipoChecklist = :cdTipoChecklist"),
    @NamedQuery(name = "TipoChecklistItemChecklist.findByQtItem", query = "SELECT t FROM TipoChecklistItemChecklist t WHERE t.qtItem = :qtItem")})
public class TipoChecklistItemChecklist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoChecklistItemChecklistPK tipoChecklistItemChecklistPK;
    @Basic(optional = false)
    @Column(name = "qt_item")
    private int qtItem;
    @JoinColumn(name = "cd_item_checklist", referencedColumnName = "cd_item", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ItemChecklist itemChecklist;
    @JoinColumn(name = "cd_tipo_checklist", referencedColumnName = "cd_tipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoChecklist tipoChecklist;

    public TipoChecklistItemChecklist() {
    }

    public TipoChecklistItemChecklist(TipoChecklistItemChecklistPK tipoChecklistItemChecklistPK) {
        this.tipoChecklistItemChecklistPK = tipoChecklistItemChecklistPK;
    }

    public TipoChecklistItemChecklist(TipoChecklistItemChecklistPK tipoChecklistItemChecklistPK, int qtItem) {
        this.tipoChecklistItemChecklistPK = tipoChecklistItemChecklistPK;
        this.qtItem = qtItem;
    }

    public TipoChecklistItemChecklist(int cdItemChecklist, int cdTipoChecklist) {
        this.tipoChecklistItemChecklistPK = new TipoChecklistItemChecklistPK(cdItemChecklist, cdTipoChecklist);
    }

    public TipoChecklistItemChecklistPK getTipoChecklistItemChecklistPK() {
        return tipoChecklistItemChecklistPK;
    }

    public void setTipoChecklistItemChecklistPK(TipoChecklistItemChecklistPK tipoChecklistItemChecklistPK) {
        this.tipoChecklistItemChecklistPK = tipoChecklistItemChecklistPK;
    }

    public int getQtItem() {
        return qtItem;
    }

    public void setQtItem(int qtItem) {
        this.qtItem = qtItem;
    }

    public ItemChecklist getItemChecklist() {
        return itemChecklist;
    }

    public void setItemChecklist(ItemChecklist itemChecklist) {
        this.itemChecklist = itemChecklist;
    }

    public TipoChecklist getTipoChecklist() {
        return tipoChecklist;
    }

    public void setTipoChecklist(TipoChecklist tipoChecklist) {
        this.tipoChecklist = tipoChecklist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoChecklistItemChecklistPK != null ? tipoChecklistItemChecklistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoChecklistItemChecklist)) {
            return false;
        }
        TipoChecklistItemChecklist other = (TipoChecklistItemChecklist) object;
        if ((this.tipoChecklistItemChecklistPK == null && other.tipoChecklistItemChecklistPK != null) || (this.tipoChecklistItemChecklistPK != null && !this.tipoChecklistItemChecklistPK.equals(other.tipoChecklistItemChecklistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edimarmanica.fazenda.bd.TipoChecklistItemChecklist[ tipoChecklistItemChecklistPK=" + tipoChecklistItemChecklistPK + " ]";
    }
    
}
